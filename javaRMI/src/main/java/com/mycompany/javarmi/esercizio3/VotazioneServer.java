/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javarmi.esercizio3;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.security.Permission;
import java.util.logging.Logger;

/**
 *
 * @author l3gix
 */
public class VotazioneServer {
    static Logger logger= Logger.getLogger("global");
      public static void main(String args[])throws RemoteException 
    {
         System.setSecurityManager(new SecurityManager() {
            @Override
            public void checkPermission(Permission perm) {
            }
            @Override
            public void checkPermission(Permission perm, Object context) {
            }
        });
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            logger.info("Creo l’oggetto remoto..."); 
            VotazioneImpl obj = new VotazioneImpl();
            logger.info("... ne effettuo il rebind...");
            registry.rebind("VotazioneServer", obj); 
            logger.info("... Pronto!");
            
        } catch (Exception e) { 
            e.printStackTrace();
        }
    }
}
