/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javasocket.esercizio2;

import com.mycompany.javasocket.esercizio1.*;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Logger;

/**
 *
 * @author l3gix
 */
public class ImpiegatoSkeleton extends Thread{
    static Logger logger = Logger.getLogger("global");
    
    private ImpiegatoServer mioServer;
    
    public ImpiegatoSkeleton(ImpiegatoServer server)
    {
        mioServer = server;
    }
    
    public static void main(String args[]) throws IOException {

    // Istanziazione oggetto Server
    ImpiegatoServer impiegato =
            new ImpiegatoServer("Mario Rossi", "01721", 30000);

    // Istanziazione skeleton e sua esecuzione
    ImpiegatoSkeleton skel = new ImpiegatoSkeleton(impiegato);
    skel.start();

    // Registrazione dell'oggetto
    InetAddress addr = null;
    String ipAddrStr = "";

    try {
        // trovo l'indirizzo IP locale
        addr = InetAddress.getLocalHost();

        byte[] ipAddr = addr.getAddress();

        // convertiamo l'indirizzo
        for (int i = 0; i < ipAddr.length; i++) {

            if (i > 0)
                ipAddrStr += ".";

            ipAddrStr += ipAddr[i] & 0xFF; // unsigned bytes
        }

    } catch (UnknownHostException e) {
        logger.severe("Non conosco localhost??" + e.getMessage());
        e.printStackTrace();
    }

    logger.info("Registro l'oggetto all'indirizzo " + ipAddrStr);

    RecordRegistro r = new RecordRegistro("Rossi", ipAddrStr);

    Socket socket;

    try {
        socket = new Socket("localhost", 7000);

        ObjectOutputStream sock_out =
                new ObjectOutputStream(socket.getOutputStream());

        sock_out.writeObject(r);
        sock_out.flush();

        socket.close();

    } catch (UnknownHostException e) {
        logger.severe("Host non conosciuto" + e.getMessage());
        e.printStackTrace();

    } catch (IOException e) {
        logger.severe(
                "Problemi sul socket per la registrazione" + e.getMessage()
        );
        e.printStackTrace();
    }
}
    
   // Attività dello Skeleton
public void run() {

    Socket socket = null;
   

    System.out.println("Attendo connessioni...");

    try {
        // Creazione ed accept su socket
        ServerSocket serverSocket = new ServerSocket(9000);

        System.out.println("Accettata una connessione... attendo comandi.");


        while (true) {

            socket = serverSocket.accept();
            System.out.println("Nuovo client conesso");
            
            GestoreClient gestore = new GestoreClient(socket,mioServer);
            
            gestore.start();

        } // fine while

    } catch (EOFException e) {

        System.out.println("Terminata la connessione");

    } catch (Throwable t) {

        t.printStackTrace();
        System.out.println("Skeleton:" + t.getMessage());

    } finally { // chiusura del socket e terminazione programma

        try {
            socket.close();

        } catch (IOException e) {

            e.printStackTrace();
            System.exit(0);
        }
    }
} // fine run()
}
