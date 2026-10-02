/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javathread.esercizio2.punto2;

/**
 *
 * @author l3gix
 */
public class ArrayThread extends Thread
{
    private int array[];
    private int start;
    private int finish;
    
    public ArrayThread(int []array,int start,int finish)
    {
        this.array = array;
        this.start = start;
        this.finish = finish;
    }
    
    @Override
    public void run()
    {
         for (int i = start; i < finish; i++) {
            array[i] = 42;
        }
    }
    
}
