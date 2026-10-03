package com.mycompany.javathread.esercizio6.punto1;


import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args) {

        Object lock1 = new Object();
        Object lock2 = new Object();

        CountDownLatch latch = new CountDownLatch(2);

        Thread t1 = new Thread() {

            @Override
            public void run() {

                synchronized (lock1) {

                    System.out.println("Thread 1 ha preso lock1");

                    latch.countDown();

                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Thread 1 aspetta lock2...");

                    synchronized (lock2) {
                        System.out.println("Thread 1 ha preso lock2");
                    }
                }
            }
        };


        Thread t2 = new Thread() {

            @Override
            public void run() {

                synchronized (lock2) {

                    System.out.println("Thread 2 ha preso lock2");

                    latch.countDown();

                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Thread 2 aspetta lock1...");

                    synchronized (lock1) {
                        System.out.println("Thread 2 ha preso lock1");
                    }
                }
            }
        };


        t1.start();
        t2.start();
    }
}