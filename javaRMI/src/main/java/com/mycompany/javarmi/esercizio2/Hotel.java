/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.javarmi.esercizio2;

import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author l3gix
 */
public interface Hotel extends java.rmi.Remote
{
    List<?> visualizzaStanze() throws RemoteException;
    
    boolean prenotaStanzaPerId(int id)throws RemoteException;
    
}
