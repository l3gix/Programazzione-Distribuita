/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javathread.esercizio2.punto2;

/**
 *
 * @author l3gix
 */
public class Main 
{
    public static void main(String[] args) throws InterruptedException 
    {
        int dimensione = 1200000;
        
        int p = 16; 
        
        for(int numeroThread = 1 ; numeroThread <= p ; numeroThread++)
        {
            int []array = new int[dimensione];
            
            Thread[] t = new Thread[numeroThread];
            
            long inizio =  System.currentTimeMillis();
            for (int i = 0; i < numeroThread; i++) {

                int start = i * dimensione / numeroThread;
                int end = (i + 1) * dimensione / numeroThread;

                t[i] = new ArrayThread(array, start, end);

                t[i].start();
            }

            // Aspetto che tutti i thread finiscano
            for (int i = 0; i < numeroThread; i++) {
                t[i].join();
            }

            long fine =  System.currentTimeMillis();

            System.out.println(
                "Thread: " + numeroThread +
                " - Tempo: " + (fine - inizio) + " ms"
            );
        }
        
        
    }
    
}
