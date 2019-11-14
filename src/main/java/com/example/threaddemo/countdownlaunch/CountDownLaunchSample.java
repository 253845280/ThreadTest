package com.example.threaddemo.countdownlaunch;

import java.util.concurrent.CountDownLatch;


public class CountDownLaunchSample {

    public static void main(String[] args) throws InterruptedException {
        long now = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(new SeeDoctorTask(countDownLatch)).start();
        new Thread(new QueueTask(countDownLatch)).start();
        //等待线程池中的2个任务执行完毕，否则一直
        countDownLatch.await();
        System.out.println("看完医生回家吃饭, 时间:"+(System.currentTimeMillis()-now));
    }
}
