package com.loring.threads.chapter04;

public class Daemon {
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
        thread.setDaemon(true);
        thread.start();
        SleepUtils.second(5);
    }
    static class DaemonRunner implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("DaemonThread after 10s");
                SleepUtils.second(10);
            } finally {
                System.out.println("DaemonThread finally run.");
            }
        }
    }
}
