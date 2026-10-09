/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javasocket.esercizio1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author l3gix
 */
public class ImpiegatoStub implements Impiegato
{
    Socket socket;
    ObjectOutputStream out;
    ObjectInputStream in;
    
    public ImpiegatoStub(String host) throws Throwable
    {
        socket = new Socket(host,9000);
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());
    }

    @Override
    public String getNome() throws Throwable {
        out.writeObject("getNome");
        out.flush();
        return (String) in.readObject();
    }

    @Override
    public String getID() throws Throwable {
        out.writeObject("getID");
        out.flush();
        return (String) in.readObject();
    }

    @Override
    public int getStipendio() throws Throwable {
         out.writeObject("getStipendio");
        out.flush();
        return in.readInt();
    }

    @Override
    public int aumentaStipednio(int diQuanto) throws Throwable {
       out.writeObject("aumentaStipendio");
       out.writeInt(diQuanto);
       out.flush();
      return in.readInt();
    }
    
    public void close()
    {
        try 
        {
            socket.close();
        }catch(IOException e)
        {
            System.out.println("Chiusura Socket");
        }
    }
    
    
    
}
