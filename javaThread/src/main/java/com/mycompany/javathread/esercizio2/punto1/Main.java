/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javathread.esercizio2.punto1;

/**
 *
 * @author l3gix
 */
public class Main 
{
    public static void main(String args[])
    {
        int array[] = new int[1200000];
        long inizio = System.nanoTime();
        for(int i = 0; i < 1200000 ; i++)
        {
            array[i] = 42;
        }
        
        long fine = System.nanoTime();
        
        System.out.println("Tempo impiegato : " + (fine - inizio) + "ns");
        
    }
}
