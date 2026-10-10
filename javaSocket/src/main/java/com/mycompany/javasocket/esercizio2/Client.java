/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javasocket.esercizio2;

import com.mycompany.javasocket.esercizio1.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Logger;

/**
 *
 * @author l3gix
 */
public class Client {
    static Logger logger = Logger.getLogger("global");
    
    public static void main(String args[])
    {
        try{
            RecordRegistro r = new RecordRegistro("Rossi", null);
            Socket socket = new Socket("localhost",7000);
            ObjectOutputStream socket_out = new ObjectOutputStream(socket.getOutputStream());
            socket_out.writeObject(r);
            socket_out.flush();
            
            ObjectInputStream socket_in = new ObjectInputStream(socket.getInputStream());
            RecordRegistro result = (RecordRegistro) socket_in.readObject();
            socket_in.close();

             if(result != null)
             {
                 Impiegato imp = new ImpiegatoStub(result.getIndirizzo());
                 System.out.println("Nome :" + imp.getNome());
                 System.out.println("ID :" + imp.getID());
                 System.out.println("Stipendio : " + imp.getStipendio());
                 System.out.println("Aumentiamo stipendio di 1000 euro");
                 System.out.println("Ora il suo stipendio è di : " + imp.aumentaStipednio(1000));
                 ((ImpiegatoStub) imp).close();
             }else 
             {
                 System.out.println("Non esiste un oggetto remoto con mome Rossi");
             }
        }catch(Throwable t)
        {
            logger.severe("lancia Throwable : " + t.getMessage());
            t.printStackTrace();
        }
    }
}
