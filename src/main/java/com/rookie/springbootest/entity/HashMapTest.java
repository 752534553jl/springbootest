package com.rookie.springbootest.entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapTest {
    public static void main(String[ ] args){

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(3, "c");
        map.put(5, "e");
        map.put(2, "b");
        //通过forEach循环遍历
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key = " + entry.getKey() + " Value = "+ entry.getValue());
        }
        //通过forEach迭代键值对
        for (Integer key : map.keySet()) {
            System.out.println("Key = " + key);
        }
        for (String value : map.values()) {
            System.out.println("Value = " + value);
        }
        //使用迭代器进行遍历
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = (Map.Entry<Integer, String>)iterator.next();
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println("Key = " + key + " Value = "+ value);
        }
        //通过Java8 Lambda表达式遍历
        map.forEach((key, value) -> {
            System.out.println("Key = " + key + "  " + " Value = " + value);
        });
    }
}
