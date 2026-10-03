/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javathread.esercizio5;

/**
 *
 * @author l3gix
 */
   public class Smiley extends Thread {
       
       private static final Object lock = new Object();
       
       public void run() {
           while(true) {
               try { 
                  synchronized (lock) {

                    printduepunti();
                    printtrattino();
                    printparentesichiusa();

                }
                   
               } catch (InterruptedException e)
               { e.printStackTrace(); }
           }
       }
   
       private  void printparentesichiusa() throws InterruptedException {
           System.out.println(")"); Thread.sleep(100);
       }
       private void printtrattino() throws InterruptedException {
           System.out.print("-"); Thread.sleep(100);
       }
       private void printduepunti() throws InterruptedException {
           System.out.print(":"); Thread.sleep(100);
       }
       public static void main(String[] args) {
           new Smiley().start();
           new Smiley().start();
       }
   }
