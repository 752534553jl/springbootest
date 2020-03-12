package com.rookie.springbootest.entity;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LinkListTest {
    public static void main(String[] args){
        LinkedList linkedList=new LinkedList();
        //添加元素
        linkedList.add("sad");
        linkedList.add("dfasd");
        //在首部添加元素
        linkedList.addFirst("asda");
        //在尾部添加元素
        linkedList.addLast("dfasd");
        //在指定位置添加元素
        linkedList.add(2,"dasd");
        //删除首部元素
        linkedList.removeFirst();
        //删除指定位置元素
        linkedList.remove(2);
        //删除尾部元素
        linkedList.removeLast();
        //元素个数
        int a=linkedList.size();
        //获取索引为3的元素并且将其转化为字符串
        String item=linkedList.get(3).toString();
    }

    Map map=new HashMap();

}
