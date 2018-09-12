package com.example.threaddemo.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantlockTest {

    public static void main(String[] args) {
        ReentrantLock lock =new ReentrantLock(false);
        lock.lock();
        lock.lock();
        lock.lock();
        System.out.println("aaa");
        lock.unlock();
        lock.unlock();
        lock.unlock();
    }
}

