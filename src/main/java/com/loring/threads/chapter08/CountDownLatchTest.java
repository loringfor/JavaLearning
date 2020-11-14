package com.loring.threads.chapter08;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {

    static CountDownLatch c = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start............");
        new Thread(new Runnable() {
            public void run() {
                System.out.println(1);
                c.countDown();
                System.out.println(2);
                c.countDown();
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        c.await();
        System.out.println("All end.........");
    }

}
