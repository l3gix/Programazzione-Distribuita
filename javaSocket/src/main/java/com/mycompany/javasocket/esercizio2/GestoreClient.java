/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.javasocket.esercizio2;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
/**
 *
 * @author l3gix
 */


public class GestoreClient extends Thread {

    private Socket socket;
    private ImpiegatoServer mioServer;

    public GestoreClient(Socket socket, ImpiegatoServer server) {

        this.socket = socket;
        this.mioServer = server;
    }

    @Override
    public void run() {

        try (
            Socket clientSocket = socket;
            ObjectInputStream inStream =
                    new ObjectInputStream(clientSocket.getInputStream());

            ObjectOutputStream outStream =
                    new ObjectOutputStream(clientSocket.getOutputStream())
        ) {

            String metodo;
            int parametro;

            System.out.println(
                "Thread " + Thread.currentThread().getId()
                + " avviato"
            );

            while (true) {

                metodo = (String) inStream.readObject();

                System.out.println(
                    "Thread " + Thread.currentThread().getId()
                    + " - Metodo richiesto: " + metodo
                );

                if (metodo.equals("getNome")) {

                    outStream.writeObject(mioServer.getNome());
                    outStream.flush();

                } else if (metodo.equals("getID")) {

                    outStream.writeObject(mioServer.getID());
                    outStream.flush();

                } else if (metodo.equals("getStipendio")) {

                    outStream.writeInt(mioServer.getStipendio());
                    outStream.flush();

                } else if (metodo.equals("aumentaStipendio")) {

                    parametro = inStream.readInt();

                    outStream.writeInt(
                        mioServer.aumentaStipendio(parametro)
                    );

                    outStream.flush();

                } else {

                    break;
                }
            }

        } catch (EOFException e) {

            System.out.println("Client disconnesso");

        } catch (IOException | ClassNotFoundException e) {

            e.printStackTrace();
        }
    }
}