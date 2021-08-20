package com.example.demo.juc;

import com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap;
import com.googlecode.concurrentlinkedhashmap.EvictionListener;

/**
 * Copyright© 2021 Transsion Inc
 * Author youwei.bi
 * Created on 2021/8/20
 * ConcurrentLinkedHashMap 是google团队提供的一个容器。它有什么用呢？其实它本身是对ConcurrentHashMap的封装，可以用来实现一个基于LRU策略的缓存。
 *
 * LRU（Least recently used，最近最少使用）算法根据数据的历史访问记录来进行淘汰数据，淘汰掉最不经常使用的数据。
 */
public class ConCurrentLinkedHashMapDemo {

    public static void main(String[] args) {

        EvictionListener<String,String> listener = new EvictionListener<String,String>(){

            @Override
            public void onEviction(String s, String s2) {
                System.out.println("key = "+s+"; value = "+s2+";  数据被丢弃");
            }
        };

        ConcurrentLinkedHashMap<String, String> concurrentLinkedHashMap = new ConcurrentLinkedHashMap
                .Builder<String, String>().maximumWeightedCapacity(3).listener(listener).build();

        concurrentLinkedHashMap.put("1","1");
        concurrentLinkedHashMap.put("2","2");
        concurrentLinkedHashMap.put("3","3");
        concurrentLinkedHashMap.get("1");
        concurrentLinkedHashMap.put("4","4");
        concurrentLinkedHashMap.put("5","5");

        System.out.println(concurrentLinkedHashMap);
    }

}
