/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javathread.esercizio1;

/**
 *
 * @author l3gix
 */
public class Increment 
{
    private static int MAXCOUNTER = 4000;
    public void incrementa(Counter c)
    {
        for(int i = 0 ; i < MAXCOUNTER ; i++)
        {
            c.conta();
        }
    }
}
