package com.example.demo;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author byw
 * @description: TODO
 * @date 2020/11/1314:37
 */
@Service
public class IndexService {
    public void getName(){


    }


    public static void main(String[] args) {
        /*ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();


        int   MAX_VALUE = 0x7fffffff;
        int MAXIMUM_CAPACITY = 1 << 30;
       int DEFAULT_INITIAL_CAPACITY = 1 << 4;
        System.out.println(MAX_VALUE);
        System.out.println(MAXIMUM_CAPACITY);
        System.out.println(DEFAULT_INITIAL_CAPACITY);
        System.out.println(new BigDecimal(Math.pow(2,31)));*/
        int hours = getHours(900);
        System.out.println(Math.round(15/2));
        System.out.println(hours);
    }


    public static int getHours(int time){
        int i=1;
        int j = time % 3600;
        if(j!=0){
            if(j>=1800){
                i = time / 3600 + 1;
            }else{
                i = time / 3600;
            }

        }else{
            if(time / 3600!=0){
                i = time / 3600;
            }
        }
        return i==0?1:i;
    }
}
