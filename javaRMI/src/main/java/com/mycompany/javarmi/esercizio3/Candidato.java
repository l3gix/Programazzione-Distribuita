/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javarmi.esercizio3;

import java.io.Serializable;

/**
 *
 * @author l3gix
 */
public class Candidato implements Serializable
{
    private int id;
    private String nome;
    private int sommaVoti;
    private int numerodivoti;
    
    public Candidato(int id,String nome)
    {
        this.id = id;
        this.nome = nome;
        sommaVoti = 0;
        numerodivoti = 0;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    
    public void aggiungiVoto(int voto)
    {
        sommaVoti += (voto > 0 ? voto : 0 );
        numerodivoti += (voto > 0 ? 1 : 0);
    }
    
    public double getMedia()
    {
        if(numerodivoti == 0) return 0;
        
        return (double) sommaVoti / numerodivoti;
    }

    @Override
    public String toString() {
        return "Candidato{" + "id=" + id + ", nome=" + nome + ", sommaVoti=" + sommaVoti + ", numerodivoti=" + numerodivoti + '}';
    }
    
    
}
