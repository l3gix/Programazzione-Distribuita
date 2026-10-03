/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javathread.esercizio3.punto2;

import java.util.Random;

/**
 *
 * @author l3gix
 */
public class Main {
    public static void main(String args[]) throws InterruptedException
    {
        int dimensione = 1200000;

        int[] array = new int[dimensione];

        Random random = new Random();

        // Inizializzazione pseudo-casuale
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }

        int numeroThread = 10; // numero dei thread da scegliere
        
        SumThread[] threads = new SumThread[numeroThread];
        
        long start =  System.currentTimeMillis();
              // Creo e avvio i thread
        for (int i = 0; i < numeroThread; i++) 
         {

                int inizio = i * dimensione / numeroThread;
                int fine = (i + 1) * dimensione / numeroThread;

                threads[i] = new SumThread(array, inizio, fine);

                threads[i].start();
            }
        
          // Aspetto tutti i thread
        for (int i = 0; i < numeroThread; i++) {
                threads[i].join();
            }
        
          // Sommo i risultati parziali
        long sommaTotale = 0;

        for (int i = 0; i < numeroThread; i++) 
        {
                sommaTotale += threads[i].getSomma();
            }
        
        long end =  System.currentTimeMillis();
        
        System.out.println("Somma : " + sommaTotale);
        System.out.println(
                " - Tempo: " + (end - start) + " ms"
            );

        
    }
}
