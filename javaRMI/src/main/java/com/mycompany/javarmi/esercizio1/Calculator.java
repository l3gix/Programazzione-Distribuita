/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.javarmi.esercizio1;

import java.rmi.RemoteException;

/**
 *
 * @author l3gix
 */
public interface Calculator extends java.rmi.Remote
{
    double somma(double n1,double n2) throws RemoteException;
    
    double sottrazione(double n1,double n2) throws RemoteException;
    
    double moltiplicazione(double n1,double n2) throws RemoteException;
    
    double divisione(double n1,double n2) throws RemoteException;
}
