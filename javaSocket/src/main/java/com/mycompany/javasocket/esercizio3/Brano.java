/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javasocket.esercizio3;

import java.io.Serializable;

/**
 *
 * @author l3gix
 */
public class Brano implements Serializable
{
    private int id;
    private String titolo;
    private String artista;
    private String link;

    public Brano(int id, String titolo, String artista, String link) {
        this.id = id;
        this.titolo = titolo;
        this.artista = artista;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return super.toString() + "[id :" + id + ",titolo:"+titolo+",artista:"+artista+",link:"+link+"]";
    }
    
    
    
}
