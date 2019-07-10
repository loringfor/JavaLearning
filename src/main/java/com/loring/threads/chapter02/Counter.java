package com.loring.threads.chapter02;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private int i = 0;

    public static void main(String[] args) {
        final Counter counter = new Counter();
        List<Thread> threadList = new ArrayList<Thread>(600);
        long start = System.currentTimeMillis();
        for (int j = 0; j < 100; j++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        counter.count();
                        counter.safeCount();
                    }
                }
            });
            threadList.add(t);
        }
        for (Thread t : threadList) {
            t.start();
        }
        // 等待所有线程执行完成
        for (Thread t : threadList) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println(counter.i);
        System.out.println(counter.atomicInteger.get());
        System.out.println(System.currentTimeMillis() - start);
    }

    /**
     * 使用counter实现线程安全计数器
     */
    private void safeCount() {
        for (;;) {
            int i = atomicInteger.get();
            boolean suc = atomicInteger.compareAndSet(i, ++i);
            if (suc) {
                break;
            }
        }
    }
    /**
     * 非线程安全计数器
     */
    private void count() {
            i++;
    }
}
