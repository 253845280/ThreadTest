package com.example.threaddemo.Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Excutor_Cache {

    //是一个”无限“容量的线程池，它会根据需要创建新线程。特点是可以根据需要来创建新的线程执行任务，没有特定的corePool.
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();

        for (int i = 0; i < 20; i++) {
            final  int index = i;
            exec.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("index:" +index + " taskBegin:"+  Thread.currentThread().getName() + " doing task");
                }
            });
        }
    }
}
