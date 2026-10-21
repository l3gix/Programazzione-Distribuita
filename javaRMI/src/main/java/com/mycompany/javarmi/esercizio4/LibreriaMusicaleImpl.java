/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javarmi.esercizio4;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author l3gix
 */
public class LibreriaMusicaleImpl extends UnicastRemoteObject implements LibreriaMusicale
{
    private final Map<String,Canzone> canzoni = new HashMap<>();
    
    private final Map<String,Playlist> playlist = new HashMap<>();
    
    private final List<Riproduzione> riproduzioni = new ArrayList<>();
    
    public LibreriaMusicaleImpl() throws RemoteException{}

    @Override
    public synchronized List<Canzone> visualizzaCanzoni() throws RemoteException {
        return new ArrayList<>(canzoni.values());
        
    }

    @Override
    public synchronized boolean aggiungiCanzone(Canzone canzone) throws RemoteException {
        if (canzone == null || canzone.getTitolo() == null
                || canzone.getTitolo().trim().isEmpty()
                || canzone.getLinkYouTube() == null
                || canzone.getLinkYouTube().trim().isEmpty()) {
            return false;
        }
        
        String titolo = canzone.getTitolo();
        
        if(canzoni.containsKey(titolo)) return false;
        
        canzoni.put(titolo, canzone);
        
        return true;
        
    }
    
    @Override
    public synchronized List<Playlist> visualizzaPlaylist()throws RemoteException {

        return new ArrayList<>(playlist.values());
    }

    @Override
    public synchronized boolean creaPlaylist(String titolo, List<String> titoliCanzoni) throws RemoteException {
        if(titolo == null || titolo.trim().isEmpty() || titoliCanzoni == null) return false;
        
        if(playlist.containsKey(titolo)) return false;
        
        List<Canzone> lista = new ArrayList<>();
        
        for(String nome : titoliCanzoni)
        {
            Canzone c = canzoni.get(nome);
            
            if(c == null) return false;
            
            lista.add(c);
        }
        
        Playlist p = new Playlist(titolo, lista);
        
        playlist.put(titolo,p);
        
        return true;
    }

    @Override
    public synchronized String riproduciCanzoni(String titolo) throws RemoteException {
         Canzone c = canzoni.get(titolo);

        if (c == null) {
            return null;
        }

        // Registro la riproduzione
        riproduzioni.add(
            new Riproduzione(titolo, false)
        );

        // Restituisco il link YouTube
        return c.getLinkYouTube();
    }

    @Override
    public synchronized List<String> riproduciPlaylist(String titolo) throws RemoteException {
        
        Playlist p = playlist.get(titolo);

        if (p == null) {
            return null;
        }

        List<String> links = new ArrayList<>();

        // Recupero i link delle canzoni
        for (Canzone c : p.getCanzoni()) {

            links.add(c.getLinkYouTube());
        }

        // Registro la riproduzione della playlist
        riproduzioni.add(
            new Riproduzione(titolo, true)
        );

        return links;
    }

    @Override
    public List<String> top10Canzoni(int giorni) throws RemoteException {
        return calcolaTop10(giorni, false);
    }

    @Override
    public List<String> top10Playlist(int giorni) throws RemoteException {
        return calcolaTop10(giorni, true);
    }
    
    private List<String> calcolaTop10(int giorni, boolean isPlaylist) {

        if (giorni <= 0) {
            return new ArrayList<>();
        }

        // Data limite
        LocalDateTime limite =
                LocalDateTime.now().minusDays(giorni);

        // Titolo -> numero riproduzioni
        Map<String, Integer> conteggi = new HashMap<>();

        for (Riproduzione r : riproduzioni) {

            // Controllo periodo e tipo
            if (!r.getDataOra().isBefore(limite)
                    && r.isPlayList() == isPlaylist) {

                String titolo = r.getTitolo();

                conteggi.put(
                    titolo,
                    conteggi.getOrDefault(titolo, 0) + 1
                );
            }
        }

        // Converto la mappa in lista
        List<Map.Entry<String, Integer>> classifica =
                new ArrayList<>(conteggi.entrySet());

        // Ordino per numero di riproduzioni decrescente
        classifica.sort((a, b) -> {
            int confronto = b.getValue().compareTo(a.getValue());

            if (confronto != 0) {
                return confronto;
            }

            return a.getKey().compareTo(b.getKey());
        });

        List<String> risultato = new ArrayList<>();

        int posizione = 1;

        for (Map.Entry<String, Integer> entry : classifica) {

            if (posizione > 10) {
                break;
            }

            risultato.add(
                posizione + ". " + entry.getKey()
                + " - Riproduzioni: " + entry.getValue()
            );

            posizione++;
        }

        return risultato;
    }
    
}
