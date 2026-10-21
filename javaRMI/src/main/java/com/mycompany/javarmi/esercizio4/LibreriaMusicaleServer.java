package com.mycompany.javarmi.esercizio4;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Logger;

public class LibreriaMusicaleServer {

    static Logger logger = Logger.getLogger("global");

    public static void main(String args[]) {

        try {

            Registry registry = LocateRegistry.createRegistry(1099);

            logger.info("Creo l'oggetto remoto...");

            LibreriaMusicaleImpl obj = new LibreriaMusicaleImpl();

            logger.info("Effettuo il rebind...");

            registry.rebind("LibreriaMusicaleServer", obj);

            logger.info("Server RMI pronto!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}