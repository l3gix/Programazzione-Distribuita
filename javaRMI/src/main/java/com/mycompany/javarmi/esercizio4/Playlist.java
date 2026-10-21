/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javarmi.esercizio4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author l3gix
 */
public class Playlist implements Serializable
{
    private String titolo;
    private List<Canzone> canzoni;

    public Playlist(String titolo, List<Canzone> canzoni) {
        this.titolo = titolo;
        this.canzoni = new ArrayList<>(canzoni);
    }

    public String getTitolo() {
        return titolo;
    }

    public List<Canzone> getCanzoni() {
        return new ArrayList<>(canzoni);
    }

    @Override
    public String toString() {
        return "Playlist{" + "titolo=" + titolo + ", canzoni=" + canzoni + '}';
    }
    
    
    
    
    
    
    
    
}
