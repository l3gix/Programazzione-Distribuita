/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javathread.esercizio1;

/**
 *
 * @author l3gix
 */
public class Main {
    public static void main(String args[])throws InterruptedException
    {
        Counter c = new Counter();
        Increment i = new Increment();
        i.incrementa(c);
        System.out.println("Incremento : " + c.getCounter());
        
        //Senza Race
        Counter c1 = new Counter();
        IncrementThread t1 = new IncrementThread(c1);
        IncrementThread t2 = new IncrementThread(c1);
        IncrementThread t3 = new IncrementThread(c1);
        IncrementThread t4 = new IncrementThread(c1);
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        
        
        System.out.println("Incremento con thread : " + c1.getCounter());
        
        //Con race
        Counter c2 = new Counter();
        IncrementThreadWithRace tr1 = new IncrementThreadWithRace(c2);
        IncrementThreadWithRace tr2 = new IncrementThreadWithRace(c2);
        IncrementThreadWithRace tr3 = new IncrementThreadWithRace(c2);
        IncrementThreadWithRace tr4 = new IncrementThreadWithRace(c2);
        
        tr1.start();
        tr2.start();
        tr3.start();
        tr4.start();

        tr1.join();
        tr2.join();
        tr3.join();
        tr4.join();
        
        System.out.println("Incremento con thread con rise condiction : " + c2.getCounter());
        
    }
}
