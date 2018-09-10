package com.example.threaddemo.Thread;

public class ThreadTest {
    static int sum = 0;
    public static void main(String[] args) {
        for(int i=0;i<10;i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (ThreadTest.class) {
                        addValue("first");
                    }
                }
            }).start();
        }
        for(int i=0;i<10;i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (ThreadTest.class) {
                        try {
                            Thread.sleep(100L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        addValue("second");
                    }
                }
            }).start();
        }

    }

    public static void addValue(String type){
        sum++;
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sum:" + sum + "  "+type+"cThreadname" + Thread.currentThread().getName());
    }
}
