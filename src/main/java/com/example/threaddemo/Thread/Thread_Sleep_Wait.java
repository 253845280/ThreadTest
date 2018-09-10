package com.example.threaddemo.Thread;

public class Thread_Sleep_Wait implements Runnable {
        int number = 10;
        public void firstMethod() throws Exception {
            synchronized (this) {
                System.out.println("firstMethod");
                number += 100;
                System.out.println(number);

            }
        }
        public void secondMethod() throws Exception {
            synchronized (this) {
                System.out.println("secondMethod");

                Thread.yield();
                //this.wait(2000);
                Thread.sleep(2000);
                number *= 200;
                System.out.println(number);
            }
        }
        @Override
        public void run() {
            try {
                firstMethod();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        public static void main(String[] args) throws Exception {
            Thread_Sleep_Wait threadTest = new Thread_Sleep_Wait();
            Thread thread = new Thread(threadTest);
            thread.start();
            thread.setPriority(1);
            threadTest.secondMethod();
        }
}
