/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.javarmi.esercizio4;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author l3gix
 */
public interface LibreriaMusicale extends Remote
{
    List<Canzone> visualizzaCanzoni() throws RemoteException;
    
    boolean aggiungiCanzone(Canzone canzone) throws RemoteException;
    
    List<Playlist> visualizzaPlaylist() throws RemoteException;
    
    boolean creaPlaylist(String titolo, List<String> titoliCanzoni) throws RemoteException;
            
    String riproduciCanzoni(String titolo) throws RemoteException;
    
    List<String> riproduciPlaylist(String titolo) throws RemoteException;
    
    List<String> top10Canzoni(int giorni) throws RemoteException;
    
    List<String> top10Playlist(int giorni) throws RemoteException;
}
