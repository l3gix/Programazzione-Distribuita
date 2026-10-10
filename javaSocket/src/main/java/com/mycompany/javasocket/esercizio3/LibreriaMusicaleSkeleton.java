/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javasocket.esercizio3;


import java.io.IOException;
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
public class LibreriaMusicaleSkeleton extends Thread
{
     static Logger logger = Logger.getLogger("global");
    
    private LibreriaMusicaleServer mioserver;

    public LibreriaMusicaleSkeleton(LibreriaMusicaleServer mioserver) {
        this.mioserver = mioserver;
    }
    
    public static void main(String args[]) throws IOException {

    // Istanziazione skeleton e sua esecuzione
    LibreriaMusicaleServer libreria = new LibreriaMusicaleServer();
    LibreriaMusicaleSkeleton skel = new LibreriaMusicaleSkeleton(libreria);
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

    RecordRegistro r = new RecordRegistro("LibreriaMusicale", ipAddrStr);

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
    
    @Override
public void run() {

    System.out.println("Server libreria musicale avviato");

    try (ServerSocket serverSocket = new ServerSocket(9000)) {

        while (true) {

            Socket socket = serverSocket.accept();

            System.out.println("Nuovo client connesso!");

            GestoreClient gestore = new GestoreClient(socket, mioserver);

            gestore.start();

            System.out.println(
                "Thread avviato: " + gestore.getName()
            );
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
}
    
}
