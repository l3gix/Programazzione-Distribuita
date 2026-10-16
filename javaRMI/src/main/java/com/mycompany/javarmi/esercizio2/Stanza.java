/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javarmi.esercizio2;

import java.io.Serializable;

/**
 *
 * @author l3gix
 */
public class Stanza implements Serializable
{
    private int id;
    private boolean disponibile;
    
    public Stanza(int id,boolean disponibile)
    {
        this.id = id;
        this.disponibile = disponibile;
    }

    public int getId() {
        return id;
    }
    
    public void setDisponibile()
    {
        disponibile = !disponibile;
    }
    
    public boolean isDisponibile() {
        return disponibile;
    }

    @Override
    public String toString() {
        return "Stanza{" + "id=" + id + ", disponibile=" + disponibile + '}';
    }

    
    
}
