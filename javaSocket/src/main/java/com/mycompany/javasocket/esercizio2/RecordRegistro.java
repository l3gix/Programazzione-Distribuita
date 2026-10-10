/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javasocket.esercizio2;

import com.mycompany.javasocket.esercizio1.*;
import java.io.Serializable;

/**
 *
 * @author l3gix
 */
public class RecordRegistro implements Serializable
{
    private static final long serialVersionUID = -414713386465982122L;
    
    private String nome;
    private String indirizzo;

    public RecordRegistro(String nome, String indirizzo) {
        this.nome = nome;
        this.indirizzo = indirizzo;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getNome() {
        return nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }
    
    
}
