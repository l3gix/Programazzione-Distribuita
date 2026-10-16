/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javarmi.esercizio1;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.security.Permission;
import java.util.logging.Logger;

/**
 *
 * @author l3gix
 */
public class CalculatorClient {
    static Logger logger= Logger.getLogger("global");
    
    public static void main(String args[]) { 
        try {
        Registry registry = LocateRegistry.getRegistry();
        logger.info("Sto cercando l’oggetto remoto..."); 
        Calculator obj = (Calculator) registry.lookup("CalculatorServer");  
        logger.info("... Trovato! Invoco metodo somma...");
        double somma = obj.somma(1,1);
        System.out.println("Ricevuto somma:"+ somma); 
        logger.info("... Trovato! Invoco metodo somma...");
        double sottrazione = obj.sottrazione(1,1);
        System.out.println("Ricevuto sottrazione:"+ sottrazione); 
        logger.info("... Trovato! Invoco metodo sottrazione...");
        double moltiplicazione = obj.moltiplicazione(1,1);
        System.out.println("Ricevuto moltiplicazione:"+ moltiplicazione); 
        logger.info("... Trovato! Invoco metodo moltiplicazione...");
        double divisione = obj.divisione(1,1);
        System.out.println("Ricevuto divisione:"+ divisione); 
        
        
        } 
        catch (Exception e) { e.printStackTrace(); }

    }
}
