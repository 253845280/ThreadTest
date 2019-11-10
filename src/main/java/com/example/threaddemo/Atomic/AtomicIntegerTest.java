package com.example.threaddemo.Atomic;

import java.util.concurrent.atomic.AtomicInteger;


public class AtomicIntegerTest {
    static AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) {
        for (int i = 0; i<100; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    atomicInteger.incrementAndGet();
                }
            }).start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("自加10次数值：--->"+atomicInteger.get());
    }

}
