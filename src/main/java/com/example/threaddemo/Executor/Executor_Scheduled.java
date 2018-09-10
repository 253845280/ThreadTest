package com.example.threaddemo.Executor;

import org.springframework.boot.origin.SystemEnvironmentOrigin;

import java.util.concurrent.*;

public class Executor_Scheduled {

    //创建一个定长线程池，支持定时及周期性任务执行
    public static void main(String[] args) {

        //也就是将在 initialDelay 后开始执行，然后在initialDelay+period 后执行，接着在 initialDelay + 2 * period 后执行，依此类推
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println( " aaaaaa:"+ Thread.currentThread().getName());
            }
        }, 5000, 1000, TimeUnit.MILLISECONDS);



       /* executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println( " aaaaaa:"+ Thread.currentThread().getName());
            }
        }, 5000, 1000,TimeUnit.MILLISECONDS);*/




           /*executorService.schedule(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "hello";
            }
        }, 5000,TimeUnit.MILLISECONDS);*/
    }
}
