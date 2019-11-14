package com.example.threaddemo.Volatile;

public class VolatileThreadTest {
    public static volatile int race = 0;


    private static final int THREADS_COUNT = 200;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++)
                        race++;
                }
            });

            threads[i].start();
        }

        Thread.sleep(3000);
        System.out.println(race);
    }
}
