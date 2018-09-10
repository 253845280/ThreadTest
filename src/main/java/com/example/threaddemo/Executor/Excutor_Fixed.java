package com.example.threaddemo.Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Excutor_Fixed {

    //创建固定长度的线程池，每次提交任务创建一个线程，直到达到线程池的最大数量，线程池的大小不再变化。
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 15; i++) {
            final int index = i ;
            exec.execute(new Runnable() {//execute方法接收Runnable对象，无返回值
                @Override
                public void run() {
                    System.out.println( "index:"+index + "   ThradName:"+ Thread.currentThread().getName());
                }
            });
        }
    }
}
