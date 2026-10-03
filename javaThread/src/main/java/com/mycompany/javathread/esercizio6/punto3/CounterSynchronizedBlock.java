package com.mycompany.javathread.esercizio6.punto3;


public class CounterSynchronizedBlock implements Contatore {

    private int counter = 0;

    private final Object lock = new Object();

    @Override
    public void incrementa() {

        synchronized (lock) {
            counter++;
        }
    }

    @Override
    public int getCounter() {
        return counter;
    }
}