package com.rookie.springbootest.entity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args){
        //创建一个空集合
        List list =new ArrayList();
        //添加元素，在添加了第一个元素后，集合容量默认设置为10
        list.add(1);
        list.add(2);
        list.add(3);
        //删除索引为2的元素
        list.remove(2);
        //获取索引为1的元素，并且将其转化为字符串。
        String mun= list.get(1).toString();
        System.out.println(list);

        LinkedList linkedList=new LinkedList();
    }
}
