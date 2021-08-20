package com.example.demo;


import org.springframework.beans.BeanUtils;
import org.springframework.util.ReflectionUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Demo1 {

    public static void main(String[] args) {
        /*HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("haha","所发生的");
        System.out.println(stringObjectHashMap);*/
        /*User user = new User();
        user.setAge(1);
        user.setName("haha");
        Map<String, Object> stringObjectMap = parseObj2Map(user);
        System.out.println(stringObjectMap);*/
        //String aa = "aa";

        /*List<String> strings = Arrays.asList(aa.split("\\|"));
        if(strings.contains("")){
            System.out.println(1111);
        }*/
        /*Map<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("weqweq","hahah");
        System.out.println(stringObjectHashMap);*/
        HashSet<String> strings = new HashSet<>();
        strings.add("1");
        strings.add("2");


        //ConcurrentLinkedHashMap concurrentlinkedhashmap = new ConcurrentLinkedHashMap();

        System.out.println(strings);

    }


    public static Map<String, Object> parseObj2Map(Object args) {
        return Arrays.stream(BeanUtils.getPropertyDescriptors(args.getClass()))
                .filter(pd -> !"class".equals(pd.getName()))
                .collect(HashMap::new,
                        (map, pd) -> map.put(pd.getName(), ReflectionUtils.invokeMethod(pd.getReadMethod(), args)),
                        HashMap::putAll);
    }
}
