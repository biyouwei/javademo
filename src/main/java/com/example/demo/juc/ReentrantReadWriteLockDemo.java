package com.example.demo.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author byw
 * @description: 读写锁案例
 * @date 2020/12/210:53
 */

class ReadWriteDemo{

    static ReentrantReadWriteLock  lock= new ReentrantReadWriteLock();
    static int readWriteNUm = 0;

    static void add(){
       lock.writeLock().lock();
        try {
        readWriteNUm++;

            TimeUnit.MILLISECONDS.sleep(100);
            if(readWriteNUm>3){
                readWriteNUm=0;
            }
            System.out.println(Thread.currentThread().getName()+"/t addNUm = "+readWriteNUm);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.writeLock().unlock();
        }



    }

    static int get(){
        int num = 0;
        lock.readLock().lock();

        try {
            num = readWriteNUm;
            System.out.println(Thread.currentThread().getName()+"/t getNUm = "+num);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.readLock().unlock();
        }
        /*lock.readLock().unlock();
        System.out.println(Thread.currentThread().getName()+"/t getNUm = "+readWriteNUm);*/
        return num;



    }

}

public class ReentrantReadWriteLockDemo {




    public static void main(String[] args) {

        for(int i = 1;i<=10;i++){
            new Thread(()->{
                for(int j = 0;j<20;j++){
                    ReadWriteDemo.add();
                }
            },String.valueOf(i)).start();

        }

        for(int i = 1;i<=10;i++){
            new Thread(()->{
                for(int j = 0;j<20;j++){

                    if(ReadWriteDemo.get()>3){
                        System.out.println("读取数据出错了");
                    }
                }
            },String.valueOf(i)).start();

        }


        /*new Thread(()->{
            for(int i = 0;i<5;i++){
                ReadWriteDemo.add();
            }
        },"bb").start();

        new Thread(()->{
            for(int i = 0;i<5;i++){
                ReadWriteDemo.add();
            }
        },"cc").start();*/

    }


}
