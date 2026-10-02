/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javathread.esercizio1;

/**
 *
 * @author l3gix
 */
public class IncrementThreadWithRace extends Thread
{
    Counter c;
    
    public IncrementThreadWithRace(Counter c)
    {
        this.c = c;
    }
    
    public void incrent()
    {
        for(int i = 0 ; i < 10000 ; i++)
        {
            synchronized (c) {
                c.conta();
            }
        }
    }
    
    
    public void run()
    {
       incrent();
    }
}
