package com.example.threaddemo.Executor;




import org.springframework.boot.origin.SystemEnvironmentOrigin;

import java.util.Map;
import java.util.RandomAccess;
import java.util.concurrent.*;


public class Executor_Future {
    public static void main(String[] args) {
        ExecutorService threapool = Executors.newSingleThreadExecutor();
        Future<String> future =  threapool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "hello";
            }
        });
        System.out.println("等待");
        try {
            System.out.println(future.get());
            System.out.println("输出");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        ExecutorService exec = Executors.newFixedThreadPool(10);
        CompletionService<String> completionService = new ExecutorCompletionService<String>(exec);
        for(int i=0;i<10;i++) {
            final int index = i;
            completionService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return  String.valueOf("abc" + index);
                }
            });
        }
        try {
            for(int i=0;i<10;i++) {

                System.out.println(completionService.take().get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
    /*FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
        @Override
        public Integer call() throws Exception {
            System.out.println("futureTask is wokring 1+1!");
            //TimeUnit.SECONDS.sleep(2);
            return 2;
        }
    });*/






    /*executor.(futureTask);//也可以使用execute，证明其是一个Runnable类型对象
    executor.shutdown();
    while(!futureTask.isDone()){
            System.out.println("子线程还没做完，我再睡会");
            TimeUnit.SECONDS.sleep(1);
        }
    try {
            System.out.println("子线程运行的结果："+futureTask.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }*/

    //exec.shu
}
