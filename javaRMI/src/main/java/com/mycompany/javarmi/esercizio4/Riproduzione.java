/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javarmi.esercizio4;

import java.time.LocalDateTime;

/**
 *
 * @author l3gix
 */
public class Riproduzione 
{
    private String titolo;
    private boolean playList;
    private LocalDateTime dataOra;

    public Riproduzione(String titolo, boolean playList) {
        this.titolo = titolo;
        this.playList = playList;
        this.dataOra = LocalDateTime.now();
    }

    public String getTitolo() {
        return titolo;
    }

    public boolean isPlayList() {
        return playList;
    }

    public LocalDateTime getDataOra() {
        return dataOra;
    }
    
    
}
