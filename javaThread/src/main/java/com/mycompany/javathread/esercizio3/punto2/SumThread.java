/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javathread.esercizio3.punto2;

/**
 *
 * @author l3gix
 */
public class SumThread extends Thread
{
    private int[] array;
    private int inizio;
    private int fine;

    private long somma;

    public SumThread(int[] array, int inizio, int fine) {
        this.array = array;
        this.inizio = inizio;
        this.fine = fine;
    }

    @Override
    public void run() {

        somma = 0;

        for (int i = inizio; i < fine; i++) {
            somma += array[i];
        }
    }

    public long getSomma() {
        return somma;
    }
}
