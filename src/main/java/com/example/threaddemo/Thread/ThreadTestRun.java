package com.example.threaddemo.Thread;

public class ThreadTestRun {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable");
            }
        }) {
            @Override
            public void run() {
                System.out.println("Run");
            }
        }.start();

        System.out.println("aaa");
    }

}
