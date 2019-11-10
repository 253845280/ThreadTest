package com.example.threaddemo.Semaphore;

import java.util.concurrent.Semaphore;

/**
 * :可用于流量控制，限制最大的并发访问数
 */
public class SemaphoreSample {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        for (int i=0;i<5;i++){
            new Thread(new Task(semaphore,"数量线程+"+i)).start();
        }
    }

    static class Task extends Thread{
        Semaphore semaphore;

        public Task(Semaphore semaphore,String tname){
            this.semaphore = semaphore;
            this.setName(tname);
        }

        public void run() {
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName()+":aquire() at time:"+System.currentTimeMillis());
                Thread.sleep(1000);
                semaphore.release();
                //System.out.println(Thread.currentThread().getName()+":aquire() at time:"+System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
