/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.javasocket.esercizio2;

import com.mycompany.javasocket.esercizio1.*;

/**
 *
 * @author l3gix
 */
public interface Impiegato {
    
    String getNome() throws Throwable;
    String getID() throws Throwable;
    int getStipendio() throws Throwable;
    int aumentaStipednio(int diQuanto) throws Throwable;
}
