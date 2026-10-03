package com.mycompany.javathread.esercizio6.punto3;


import java.util.concurrent.atomic.AtomicInteger;

public class CounterAtomic implements Contatore {

    private AtomicInteger counter = new AtomicInteger(0);

    @Override
    public void incrementa() {
        counter.incrementAndGet();
    }

    @Override
    public int getCounter() {
        return counter.get();
    }
}