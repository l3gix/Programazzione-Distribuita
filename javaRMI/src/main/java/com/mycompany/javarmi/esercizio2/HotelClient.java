/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javarmi.esercizio2;


import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author l3gix
 */
public class HotelClient 
{
    static Logger logger= Logger.getLogger("global");
      public static void main(String args[]) { 
        try {
        Registry registry = LocateRegistry.getRegistry();
        logger.info("Sto cercando l’oggetto remoto..."); 
        Hotel obj = (Hotel) registry.lookup("HotelServer");  
        logger.info("... Trovato! Invoco metodo Lista delle stanze...");
        List<?> stanze = obj.visualizzaStanze();
        System.out.println("Ricevuto Lista stanze :"+ stanze); 
        logger.info("... Trovato! Invoco metodo Per prenotare una stanza...");
        System.out.println("Ricevuto esito della prenotazione:"+ obj.prenotaStanzaPerId(0)); 
        
        
        } 
        catch (Exception e) { e.printStackTrace(); }

    }
}
