/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javasocket.esercizio1;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.logging.Logger;

/**
 *
 * @author l3gix
 */
public class RegistroServer {
    static Logger logger = Logger.getLogger("global");

    public static void main(String[] args) {

        HashMap<String, RecordRegistro> hash =
                new HashMap<String, RecordRegistro>();

        Socket socket = null;

        System.out.println("In attesa di connessioni...");

        try {
            // Creazione ed accept su socket
            ServerSocket serverSocket = new ServerSocket(7000);

            while (true) {

                socket = serverSocket.accept();

                ObjectInputStream inStream =
                        new ObjectInputStream(socket.getInputStream());

                RecordRegistro record =
                        (RecordRegistro) inStream.readObject();

                if (record.getIndirizzo() != null) { // si tratta di una scrittura

                    logger.info("Inserisco:" + record.getNome() + "," + record.getIndirizzo());

                    hash.put(record.getNome(), record);

                } else { // è una ricerca

                    logger.info("Cerco:" + record.getNome());

                    RecordRegistro res = hash.get(record.getNome());

                    ObjectOutputStream outStream =
                            new ObjectOutputStream(socket.getOutputStream());

                    outStream.writeObject(res); // se non c'è il record, res è null
                    outStream.flush();
                }

                socket.close();

            } // fine while

        } catch (EOFException e) {

            logger.severe("Problemi con la connessione:" + e.getMessage());
            e.printStackTrace();

        } catch (Throwable t) {

            logger.severe("Lanciata Throwable:" + t.getMessage());
            t.printStackTrace();

        } finally { // chiusura del socket e terminazione programma

            try {
                socket.close();

            } catch (IOException e) {

                e.printStackTrace();
                System.exit(0);
            }
        }
    }
}
