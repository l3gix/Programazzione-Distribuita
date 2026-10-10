/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javasocket.esercizio3;

import java.util.List;

/**
 *
 * @author l3gix
 */
public interface LibreriaMusicale 
{
    boolean aggiungiBrano(Brano brano) throws Exception;
    
    boolean rimuoviBrano(int id) throws Exception;
    
    List<Brano> visualizzaBrani() throws Exception;
    
    List<Brano> cercaPerTitolo(String titolo) throws Exception;
    
    List<Brano> cercaPerArtista(String artista) throws Exception;
    
    String ottieniLink(int id) throws Exception;
    
    
    
    
    
}
