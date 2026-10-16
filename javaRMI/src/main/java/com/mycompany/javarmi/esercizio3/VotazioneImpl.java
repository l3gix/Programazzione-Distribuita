/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javarmi.esercizio3;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author l3gix
 */
public class VotazioneImpl extends UnicastRemoteObject implements Votazione{
    
      private ArrayList<Candidato> candidati = new ArrayList<>();
    
    public VotazioneImpl() throws RemoteException {
        candidati.add(new Candidato(1, "Mario"));
        candidati.add(new Candidato(2, "Luigi"));
        candidati.add(new Candidato(3, "Giovanni"));
    }

    @Override
    public List<Candidato> visualizzaCandidati() throws RemoteException 
    {
       return  new ArrayList<>(candidati);
        
    }

    @Override
    public boolean votaCandidato(int id, int voto) throws RemoteException 
    {
        for(Candidato t : candidati )
        {
            if(t.getId() == id )
            {
                t.aggiungiVoto(voto);
                return true;
            }
        }
        
        return false;
    }

    @Override
    public List<Candidato> risultatiVotazioni() throws RemoteException 
    {
        return new ArrayList<>(candidati);
    }
    
}
