package com.example.threaddemo.lock;



import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Lock_ReadWrite {
    //读写锁
    static int sum = 1;
    public static void main(String[] args) {
        //高位读锁  低位写锁
        ReadWriteLockDemo rw = new ReadWriteLockDemo();
        for (int k = 0; k < 10; k++ ) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    rw.set(sum++);
                }
            }, "Write:").start();
        }

        for (int i = 0; i < 10; i++ ) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //rw.set(++sum);
                    rw.get();
                }
            }, "Read:").start();
        }
    }
}


class ReadWriteLockDemo {

    private int number = 0;

    private ReadWriteLock lock = new ReentrantReadWriteLock();

    //读
    public void get() {
        lock.readLock().lock();    //上锁
        try {
            System.out.println(Thread.currentThread().getName() + " : " + number);
        } finally {
            lock.readLock().unlock();    //释放锁
        }
    }

    //写
    public void set(int number) {
        lock.writeLock().lock();    //上锁
        try {
            System.out.println(Thread.currentThread().getName() +number);
            this.number = number;
        } finally {
            lock.writeLock().unlock();    //释放锁
        }
    }
}

