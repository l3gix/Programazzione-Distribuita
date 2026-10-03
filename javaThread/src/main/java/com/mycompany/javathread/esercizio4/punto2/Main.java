/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javathread.esercizio4.punto2;

/**
 *
 * @author l3gix
 */
public class Main 
{
    public static void main(String[] args) throws InterruptedException {

        int dimensione = 1200000;

        int numeroThread = 5;
        
        int[] array = new int[dimensione];

        MaxThread[] threads =new MaxThread[numeroThread];

        long inizioTempo = System.currentTimeMillis();

            // Creazione e avvio thread
        for (int i = 0; i < numeroThread; i++) {

            int inizio =i * dimensione / numeroThread;

            int fine =(i + 1) * dimensione / numeroThread;
            threads[i] =new MaxThread(array, inizio, fine);

            threads[i].start();
         }

            // Aspetto tutti i thread
        for (int i = 0; i < numeroThread; i++) {
                threads[i].join();
            }

            // Trovo il massimo tra i massimi parziali
        int massimoTotale =threads[0].getMassimo();

        for (int i = 1; i < numeroThread; i++) {

            if (threads[i].getMassimo() > massimoTotale) {

                massimoTotale =threads[i].getMassimo();
            }
        }

        long fineTempo = System.currentTimeMillis();

            System.out.println(
                    "Thread: " + numeroThread +
                    " - Massimo: " + massimoTotale +
                    " - Tempo: " + (fineTempo - inizioTempo) + " ms"
            );
        }
    
}
