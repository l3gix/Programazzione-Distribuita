/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javathread.esercizio4.punto2;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author l3gix
 */
public class MaxThread extends Thread
{
    private int[] array;
    private int inizio;
    private int fine;

    private int massimo;

    public MaxThread(int[] array, int inizio, int fine) {
        this.array = array;
        this.inizio = inizio;
        this.fine = fine;
    }

    @Override
    public void run() {

        massimo = Integer.MIN_VALUE;

        for (int i = inizio; i < fine; i++) {

            // Il thread assegna il valore casuale
            array[i] = ThreadLocalRandom.current().nextInt(1000000);

            // E controlla subito se è il massimo
            if (array[i] > massimo) {
                massimo = array[i];
            }
        }
    }

    public int getMassimo() {
        return massimo;
    }
}
