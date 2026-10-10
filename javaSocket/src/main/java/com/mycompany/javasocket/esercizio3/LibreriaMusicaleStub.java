/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javasocket.esercizio3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author l3gix
 */
public class LibreriaMusicaleStub implements LibreriaMusicale
{
    Socket socket;
    ObjectOutputStream out;
    ObjectInputStream in;

    public LibreriaMusicaleStub(String host) throws Throwable
    {
        socket = new Socket(host,9000);
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());
    }

    @Override
    public boolean aggiungiBrano(Brano brano) throws Exception {
        out.writeObject("aggiungiBrano");
        out.writeObject(brano);
        out.flush();
        
        return in.readBoolean();
    }

    @Override
    public boolean rimuoviBrano(int id) throws Exception {
       out.writeObject("rimuoviBrano");
       out.writeInt(id);
       out.flush();
       
       return in.readBoolean();
    }

    @Override
    public List<Brano> visualizzaBrani() throws Exception {
        out.writeObject("visualizzaBrani");    
        out.flush();
        
        return (List<Brano>) in.readObject();
    }

    @Override
    public List<Brano> cercaPerTitolo(String titolo) throws Exception {
        out.writeObject("cercaPerTitolo");
        out.writeObject(titolo);
        
        return (List<Brano>) in.readObject();
    }

    @Override
    public List<Brano> cercaPerArtista(String artista) throws Exception {
        out.writeObject("cercaPerArtista");
        out.writeObject(artista);
        out.flush();
        
        return (List<Brano>) in.readObject();
    }

    @Override
    public String ottieniLink(int id) throws Exception {
        out.writeObject("ottieniLink");
        out.writeInt(id);
        out.flush();
        
        return(String) in.readObject();
        
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
