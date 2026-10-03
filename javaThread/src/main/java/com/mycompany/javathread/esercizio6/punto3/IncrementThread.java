package com.mycompany.javathread.esercizio6.punto3;


public class IncrementThread extends Thread {

    private Contatore counter;
    private int numeroIncrementi;

    public IncrementThread(Contatore counter, int numeroIncrementi) {
        this.counter = counter;
        this.numeroIncrementi = numeroIncrementi;
    }

    @Override
    public void run() {

        for (int i = 0; i < numeroIncrementi; i++) {
            counter.incrementa();
        }
    }
}