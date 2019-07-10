package com.loring.threads.chapter05;

import com.loring.threads.chapter04.SleepUtils;
import java.util.concurrent.locks.Lock;

public class TwinsLockTest {
    public static void main(String[] args) {
        final Lock lock = new TwinsLock();
        // 启动10个线程
        for (int i = 0; i < 10; i++) {
            Worker w = new Worker(lock);
            w.setDaemon(true);
            w.start();
        }
        // 每隔1秒换行
        for (int i = 0; i < 10; i++) {
            SleepUtils.second(1);
            System.out.println();
        }
    }
}

class Worker extends Thread{
    private Lock lock;

    public void setLock(Lock lock) {
        this.lock = lock;
    }

    public Worker(){}
    public Worker(Lock lock){
        this.lock=lock;
    }

    @Override
    public void run() {
        while (true){
            lock.lock();
            try {
                SleepUtils.second(1);
                System.out.println(Thread.currentThread().getName());
                SleepUtils.second(1);
            }finally {
                lock.unlock();
            }
        }
    }
}
