/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javasocket.esercizio1;

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
    
    public int aumentoStipendio(int diQuanto)
    {
        if(diQuanto > 0) stipendio += diQuanto;
        return stipendio;
    }

    int aumentaStipendio(int parametro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    int getStipendio() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Object getID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Object getNome() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
    
}
