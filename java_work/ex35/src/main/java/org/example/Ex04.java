package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ex04 {

    public static void main(String[] args) {
        Runnable run1 = () -> {
            int n1 = 10;
            int n2 = 20;
            System.out.println(Thread.currentThread().getName()+" "+(n1+n2));
        };

//        ExecutorService exr = Executors.newSingleThreadExecutor();
        // 쓰레드의 분기를 나눌 수 있음
        ExecutorService exr = Executors.newFixedThreadPool(3);
        exr.submit(run1);
        exr.submit(run1);
        exr.submit(run1);
        exr.submit(run1);
        // 쓰레드 하나 기다렸다가 하고, 하나 기다렸다가 함

        System.out.println("end "+Thread.currentThread().getName());
        exr.shutdown();
    }
}