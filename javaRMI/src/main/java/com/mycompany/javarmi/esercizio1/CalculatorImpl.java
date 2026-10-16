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
public class CalculatorImpl extends java.rmi.server.UnicastRemoteObject implements Calculator
{
    private static final long serialVersionUID = -4469091140865645865L;
    
    public CalculatorImpl()throws RemoteException { }
    
    @Override
    public double somma(double n1,double n2) throws RemoteException
    {
        return n1+n2;
    }
    
    @Override
    public double sottrazione(double n1,double n2) throws RemoteException
    {
        return n1 - n2;
    }
    
    @Override
    public double moltiplicazione(double n1,double n2) throws RemoteException
    {
        return n1*n2;
    }
    
    @Override
    public double divisione(double n1,double n2) throws RemoteException
    {
        return n1/n2;
    }
}
