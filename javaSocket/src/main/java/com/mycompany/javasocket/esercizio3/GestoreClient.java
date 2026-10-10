/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javasocket.esercizio3;


import java.io.*;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author l3gix
 */
public class GestoreClient extends Thread{
     private Socket socket;
    private LibreriaMusicaleServer mioServer;

    public GestoreClient(Socket socket, LibreriaMusicaleServer server) {

        this.socket = socket;
        this.mioServer = server;
    }
    
     @Override
    public void run() {

        System.out.println(
            "Thread " + Thread.currentThread().getId() + " avviato"
        );

        try (
            Socket clientSocket = socket;

            ObjectOutputStream outStream =
                    new ObjectOutputStream(clientSocket.getOutputStream());

            ObjectInputStream inStream =
                    new ObjectInputStream(clientSocket.getInputStream())
        ) {

            String metodo;

            while (true) {

                // Lettura del metodo richiesto dal Client
                metodo = (String) inStream.readObject();

                System.out.println(
                    "Thread " + Thread.currentThread().getId()
                    + " - Metodo richiesto: " + metodo
                );

                // AGGIUNTA BRANO
                if (metodo.equals("aggiungiBrano")) {

                    Brano brano = (Brano) inStream.readObject();

                    boolean risultato = mioServer.aggiungiBrano(brano);

                    outStream.writeBoolean(risultato);
                    outStream.flush();

                }

                // RIMOZIONE BRANO
                else if (metodo.equals("rimuoviBrano")) {

                    int id = inStream.readInt();

                    boolean risultato = mioServer.rimuoviBrano(id);

                    outStream.writeBoolean(risultato);
                    outStream.flush();

                }

                // VISUALIZZAZIONE BRANI
                else if (metodo.equals("visualizzaBrani")) {

                    List<Brano> brani = mioServer.visualizzaBrani();

                    outStream.writeObject(brani);
                    outStream.flush();

                }

                // RICERCA PER TITOLO
                else if (metodo.equals("cercaPerTitolo")) {

                    String titolo = (String) inStream.readObject();

                    List<Brano> risultati =
                            mioServer.cercaPerTitolo(titolo);

                    outStream.writeObject(risultati);
                    outStream.flush();

                }

                // RICERCA PER ARTISTA
                else if (metodo.equals("cercaPerArtista")) {

                    String artista = (String) inStream.readObject();

                    List<Brano> risultati =
                            mioServer.cercaPerArtista(artista);

                    outStream.writeObject(risultati);
                    outStream.flush();

                }

                // OTTENERE LINK STREAMING
                else if (metodo.equals("ottieniLink")) {

                    int id = inStream.readInt();

                    String link = mioServer.ottieniLink(id);

                    outStream.writeObject(link);
                    outStream.flush();

                }

                // CHIUSURA CONNESSIONE
                else if (metodo.equals("close")) {

                    System.out.println("Client in disconnessione...");
                    break;

                }

                // METODO NON RICONOSCIUTO
                else {

                    System.out.println("Metodo non riconosciuto: " + metodo);
                    break;
                }
            }

        } catch (EOFException e) {

            System.out.println(
                "Client disconnesso - Thread "
                + Thread.currentThread().getId()
            );

        } catch (IOException | ClassNotFoundException e) {

            e.printStackTrace();

        } finally {

            System.out.println(
                "Thread " + Thread.currentThread().getId()
                + " terminato"
            );
        }
    }
}
