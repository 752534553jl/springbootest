package com.rookie.springbootest.entity;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 银行账户类
 */
class Mbank{
    //创建一个线程本地变量ThreadLocal
    private static ThreadLocal<Integer> sum=new ThreadLocal<Integer>(){
        protected Integer initialValue(){
            return 2000;
        }
    };
    public static void take(int k){
        //取款,设置线程副本中的值
        sum.set(sum.get()-k);
        try {
            Thread.sleep((int)(1000*Math.random()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //输出线程副本中的值
        System.out.println("sum="+sum.get());
    }
}
/**
 * 用户取款的线程类
 */
class Customer extends Thread{
    public void run(){
        for(int i=1;i<=4;i++){
            Mbank.take(100);
        }
    }
}
/***
 *调用线程的主类
 */
public class ThreadData {
    public static void main(String [] args){
        Customer customer1=new Customer();
        Customer customer2=new Customer();
        customer1.start();
        customer2.start();
        ThreadPoolExecutor threadPoolExecutor;
    }
}
