package com.interview;

public class PrintThread {
    private static boolean flga1 = true;
    private static boolean flga2 = false;
    private static boolean flga3 = false;

    public static void main(String[] args) {
        final PrintThread printThread = new PrintThread();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    while (true) {
                        synchronized (printThread) {
                            if (!flga1) {
                                try {
                                    printThread.wait();
                                } catch (InterruptedException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }

                            } else {
                                System.out.println(Thread.currentThread()
                                        .getName());
                                flga1 = false;
                                flga2 = true;
                                flga3 = false;
                                printThread.notifyAll();
                                break;
                            }
                        }
                    }

                }

            }
        }, "A");

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    while (true) {
                        synchronized (printThread) {
                            if (!flga2) {
                                try {
                                    printThread.wait();
                                } catch (InterruptedException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }

                            } else {
                                System.out.println(Thread.currentThread()
                                        .getName());
                                flga1 = false;
                                flga2 = false;
                                flga3 = true;
                                printThread.notifyAll();
                                break;
                            }
                        }

                    }
                }

            }
        }, "B");

        Thread t3 = new Thread(new Runnable() {

            @Override
            public void run() {

                for (int i = 0; i < 10; i++) {

                    while (true) {
                        synchronized (printThread) {
                            if (!flga3) {
                                try {
                                    printThread.wait();
                                } catch (InterruptedException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }

                            } else {
                                System.out.println(Thread.currentThread()
                                        .getName());
                                flga1 = true;
                                flga2 = false;
                                flga3 = false;
                                printThread.notifyAll();
                                break;
                            }
                        }
                    }
                }

            }
        }, "C");

        t1.start();
        t2.start();
        t3.start();

    }

}
