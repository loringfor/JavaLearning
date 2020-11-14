package com.loring.threads.chapter08;

import static java.lang.Thread.sleep;

public class JoinCountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        Thread parser1 = new Thread(new Runnable() {
            public void run() {
                System.out.println("parser1 finish");
                try {
                    sleep(3000);
                    System.out.println(3333);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread parser2 = new Thread(new Runnable() {
            public void run() {
                System.out.println("parser2 finish");
                try {
                    sleep(5000);
                    System.out.println(555);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        parser1.start();
        parser2.start();
        parser2.join();
        parser1.join();
        System.out.println("all parser finish");
    }

}
