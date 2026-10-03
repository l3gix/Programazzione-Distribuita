package com.mycompany.javathread.esercizio6.punto3;


public class CounterUnsafe implements Contatore {

    private int counter = 0;

    @Override
    public void incrementa() {
        counter++;
    }

    @Override
    public int getCounter() {
        return counter;
    }
}