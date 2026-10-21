/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javarmi.esercizio4;

import java.io.Serializable;

/**
 *
 * @author l3gix
 */
public class Canzone implements Serializable
{
    private String titolo;
    private String linkYouTube;
    private String nomeCliente;

    public Canzone(String titolo, String linkYouTube, String nomeCliente) {
        this.titolo = titolo;
        this.linkYouTube = linkYouTube;
        this.nomeCliente = nomeCliente;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getLinkYouTube() {
        return linkYouTube;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    @Override
    public String toString() {
        return "Canzone{" + "titolo=" + titolo + ", linkYouTube=" + linkYouTube + ", nomeCliente=" + nomeCliente + '}';
    }

   
    
    
    
}
