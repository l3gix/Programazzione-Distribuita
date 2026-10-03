/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javathread.esercizio3.punto1;

import java.util.Random;

/**
 *
 * @author l3gix
 */
public class Main 
{
    public static void main(String args[])
    {
        int dimensione = 1200000;

        int[] array = new int[dimensione];

        Random random = new Random();

        // Inizializzazione pseudo-casuale
        for (int i = 0; i < array.length; i++) 
        {
            array[i] = random.nextInt(100);
        }
        
        long inizio =  System.currentTimeMillis();
        
        int somma = 0;
        for(int i = 0 ; i < dimensione ; i++)
        {
            somma += array[i];
        }
        
        long fine =  System.currentTimeMillis();
        System.out.println("Somma : " + somma);
        System.out.println(
                " - Tempo: " + (fine - inizio) + " ms"
            );
        
         
        
    }
}
