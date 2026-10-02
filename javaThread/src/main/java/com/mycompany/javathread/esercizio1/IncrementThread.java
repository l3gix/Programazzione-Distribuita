/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javathread.esercizio1;

/**
 *
 * @author l3gix
 */
public class IncrementThread extends Thread
{
    Counter c;
    
    public IncrementThread(Counter c)
    {
        this.c = c;
    }
    
    
    public void run()
    {
        for(int i = 0 ; i < 10000 ; i++)
        {
            c.conta();
        }
    }
    
}
