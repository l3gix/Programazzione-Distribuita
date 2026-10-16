/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javarmi.esercizio2;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author l3gix
 */
public class HotelImpl extends java.rmi.server.UnicastRemoteObject implements Hotel
{
    private static final long serialVersionUID = -4469091140865645865L;
    
    private ArrayList<Stanza> stanze = new ArrayList<>();
    
    public HotelImpl()throws RemoteException 
    {
        stanze.add(new Stanza(0, true));
        stanze.add(new Stanza(1, true));
        stanze.add(new Stanza(2, true));
    }
    
    public synchronized List<?> visualizzaStanze() throws RemoteException {
       return stanze;
    }

    @Override
    public synchronized boolean prenotaStanzaPerId(int id) throws RemoteException {
       for( Stanza t : stanze ) 
       {
           if(t.getId() == id && t.isDisponibile() ) 
           {
               t.setDisponibile();
               return true;
           }
       }
       
       return false;
    }
    
}
