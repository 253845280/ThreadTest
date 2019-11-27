package com.example.threaddemo.Executor;


import sun.awt.SunHints;

import java.util.concurrent.*;

public class Executor_Single {
    //创建一个使用单个 worker 线程的 Executor。即使任务再多，也只用1个线程完成任务。
    //如果线程挂了 。 会创建一个新线程继续执行
    public static void main(String[] args) {


        /*ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i <11; i++) {
            exec.execute(new Runnable() {//execute方法接收Runnable对象，无返回值
                @Override
                public void run() {
                    System.out.println("first:" +Thread.currentThread().getName());
                    //Integer.valueOf("123");
                }
            });
        }*/

        ExecutorService exec =   new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(5));
        for (;;) {
            exec.submit(new Runnable() {//execute方法接收Runnable对象，无返回值
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("first:" +Thread.currentThread().getName());
                }
            });
        }






    }
}
