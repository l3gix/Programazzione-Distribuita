/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javasocket.esercizio2;

import com.mycompany.javasocket.esercizio1.*;

/**
 *
 * @author l3gix
 */
public class ImpiegatoServer 
{
    public String nome;
    public String ID;
    public int stipendio;

    public ImpiegatoServer(String nome, String ID, int stipendio) {
        this.nome = nome;
        this.ID = ID;
        this.stipendio = stipendio;
    }
    
    

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setStipendio(int stipendio) {
        this.stipendio = stipendio;
    }
    
    public synchronized int aumentaStipendio(int diQuanto)
    {
        if(diQuanto > 0) stipendio += diQuanto;
        return stipendio;
    }

    public String getNome() {
        return nome;
    }

    public String getID() {
        return ID;
    }

    public synchronized int getStipendio() {
        return stipendio;
    }
    
    



   
    
    
    
    
    
}
