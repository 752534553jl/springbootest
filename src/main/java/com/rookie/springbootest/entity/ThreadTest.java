package com.rookie.springbootest.entity;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//继承Thread类创建线程
class Thread_01 extends Thread{

    public void run(){
        System.out.print("Thread_01.run()");
        try {
            for(int i = 4; i > 0; i--) {
                System.out.println("Thread: " + Thread_01.currentThread().getName() + ", " + i);
                // 让线程睡眠一会
                Thread.sleep(50);
            }
        }catch (InterruptedException e) {
            System.out.println("Thread " +  Thread_01.currentThread().getName() + " interrupted.");
        }
        System.out.println("Thread " +  Thread_01.currentThread().getName() + " exiting.");
    }
}

//实现Runable接口
class Thread_02 implements Runnable{
    public void run(){
        System.out.print("Thread_01.run()");
        try {
            for(int i = 4; i > 0; i--) {
                System.out.println("Thread: " + Thread.currentThread().getName() + ", " + i);
                // 让线程睡眠一会
                Thread.sleep(50);
            }
        }catch (InterruptedException e) {
            System.out.println("Thread " +  Thread.currentThread().getName() + " interrupted.");
        }
        System.out.println("Thread " +  Thread.currentThread().getName() + " exiting.");
    }

}
//使用Callable和Future接口创建线程
class Thread_03 implements Callable<Integer>{
    /**
     * 与run()方法不同，call()方法具有返回值
     * @return
     */
    @Override
    public Integer call () {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            System.out.println("Thread:"+ Thread.currentThread().getName() +", i:"+ i);
            sum += i;
        }
        return sum;
    }
}

public class ThreadTest {

    public static void main(String [] args){
        // 创建myCallable对象
        Callable<Integer> myCallable = new Thread_03();
        // 使用FutureTask来包装myCallable对象
        FutureTask<Integer> ft = new FutureTask<Integer>(myCallable);
        System.out.println("Thread:"+ Thread.currentThread().getName());
        // FutureTask对象作为Thread对象的target创建新的线程
        Thread thread = new Thread(ft);
        // 线程进入到就绪状态
        thread.start();
        System.out.println("主线程for执行完毕...");
        try {
            // 取得新创建的新线程中的call()方法返回的结果
            int sum = ft.get();
            System.out.println("sum:"+ sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
