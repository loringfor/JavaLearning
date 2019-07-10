package com.loring.threads.chapter08;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangerTest {
    private static Exchanger<String> exchanger = new Exchanger<String>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try{
                    String A = "银行流水A";
                    String str = exchanger.exchange(A);
                    System.out.println(str);
                }catch (InterruptedException e){
                    System.out.println("Erro");
                }
            }
        });

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try{
                    String B = "银行流水B";
                    String A = exchanger.exchange(B);
                    System.out.println("A和B数据是否一致：" + A.equals(B) + "，A录入的是：" + A + "，B录入是：" + B);
                }catch (InterruptedException e){
                    System.out.println("Erro");
                }
            }
        });

        threadPool.shutdown();
    }
}
