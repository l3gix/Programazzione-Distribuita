/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javasocket.esercizio3;

import java.util.HashMap;
import java.util.*;

/**
 *
 * @author l3gix
 */
public class LibreriaMusicaleServer 
{
    private final HashMap<Integer, Brano> brani;

    public LibreriaMusicaleServer() {
        brani = new HashMap<>();
    }

    public synchronized boolean aggiungiBrano(Brano brano) {

        if (brani.containsKey(brano.getId())) {
            return false;
        }

        brani.put(brano.getId(), brano);

        return true;
    }

    public synchronized boolean rimuoviBrano(int id) {

        return brani.remove(id) != null;
    }

    public synchronized List<Brano> visualizzaBrani() {

        return new ArrayList<>(brani.values());
    }

    public synchronized List<Brano> cercaPerTitolo(String titolo) {

        List<Brano> risultati = new ArrayList<>();

        for (Brano brano : brani.values()) {

            if (brano.getTitolo().toLowerCase()
                    .contains(titolo.toLowerCase())) {

                risultati.add(brano);
            }
        }

        return risultati;
    }

    public synchronized List<Brano> cercaPerArtista(String artista) {

        List<Brano> risultati = new ArrayList<>();

        for (Brano brano : brani.values()) {

            if (brano.getArtista().toLowerCase()
                    .contains(artista.toLowerCase())) {

                risultati.add(brano);
            }
        }

        return risultati;
    }

    public synchronized String ottieniLink(int id) {

        Brano brano = brani.get(id);

        if (brano != null) {
            return brano.getLink();
        }

        return null;
    }
}
