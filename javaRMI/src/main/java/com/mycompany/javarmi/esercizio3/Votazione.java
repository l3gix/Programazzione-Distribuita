/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.javarmi.esercizio3;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author l3gix
 */
public interface Votazione extends Remote 
{
    List<?> visualizzaCandidati() throws RemoteException;
    
    boolean votaCandidato(int id,int voto) throws RemoteException;
    
     List<?> risultatiVotazioni() throws RemoteException;
    
}
