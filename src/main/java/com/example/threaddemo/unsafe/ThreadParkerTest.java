package com.example.threaddemo.unsafe;

import java.util.concurrent.locks.LockSupport;

public class ThreadParkerTest {

    public static void main(String[] args) {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("begin t theard ");
                LockSupport.park();//阻塞当前线程
                System.out.println("end t thread");
            }
        });

        t.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LockSupport.unpark(t);//唤醒指定的线程




        /*//拿出票据使用
        //LockSupport.park();
        LockSupport.unpark(Thread.currentThread());
        System.out.println("begin park");
        //相当于先往池子里放了一张票据
        //LockSupport.unpark(Thread.currentThread());
        LockSupport.park();
        System.out.println("end park");*/

    }

}
