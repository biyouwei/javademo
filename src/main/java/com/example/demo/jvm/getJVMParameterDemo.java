package com.example.demo.jvm;

import java.util.concurrent.TimeUnit;

/**
 * @author byw
 * @description: 获取jvm参数
 * @date 2020/12/313:57
 */
public class getJVMParameterDemo {


    /**
     * -Xms128m  初始堆内存   -Xmx512m 最大堆内存  -XX:+PrintGCDetails 打印GC信息  -XX:+PrintCommandLineFlags显示跟初始化参数不同的jvm参数
     * jps -l 查看java进程号
     * jinfo -flag  属性名 进程号 （查看jvm某一属性的值）
     * jinfo -flags 进程号  （查看jvm属性的值）
     * java -XX:+PrintFlagsInitial 查看默认的jvm参数  java -XX:+PrintFlagsFinal 查看修改后的jvm参数
     *
     *
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("测试=====");
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);
        System.gc();
        try {
            TimeUnit.SECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
