/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javarmi.esercizio3;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 *
 * @author l3gix
 */
public class VotazioneClient 
{
    
    static Logger logger = Logger.getLogger("global");

    public static void main(String args[]) {

        try {
            Registry registry = LocateRegistry.getRegistry();

            logger.info("Sto cercando l'oggetto remoto...");

            Votazione obj = (Votazione) registry.lookup("VotazioneServer");

            logger.info("... Oggetto remoto trovato!");

            Scanner scanner = new Scanner(System.in);

            int scelta;

            do {
                System.out.println("\n===== MENU VOTAZIONI =====");
                System.out.println("1. Visualizza candidati");
                System.out.println("2. Vota candidato");
                System.out.println("3. Visualizza risultati");
                System.out.println("0. Esci");
                System.out.print("Inserisci la tua scelta: ");

                scelta = scanner.nextInt();

                switch (scelta) {

                    case 1:
                        logger.info("Invoco metodo visualizzaCandidati...");

                        List<Candidato> candidati =(List<Candidato>) obj.visualizzaCandidati();

                        for (Candidato c : candidati) {
                            System.out.println(c);
                        }
                        break;

                    case 2:
                        System.out.print("Inserisci ID candidato: ");
                        int id = scanner.nextInt();

                        System.out.print("Inserisci voto (1-10): ");
                        int voto = scanner.nextInt();

                        logger.info("Invoco metodo votaCandidato...");

                        boolean risultato = obj.votaCandidato(id, voto);

                        if (risultato) {
                            System.out.println("Voto registrato correttamente!");
                        } else {
                            System.out.println("Errore: voto o candidato non valido!");
                        }
                        break;

                    case 3:
                        logger.info("Invoco metodo risultatiVotazioni...");

                        List<Candidato> risultati =(List<Candidato>) obj.risultatiVotazioni();

                        for (Candidato c : risultati) {
                            System.out.println(c.getNome()
                                    + " - Media voti: " + c.getMedia());
                        }
                        break;

                    case 0:
                        System.out.println("Chiusura del client...");
                        break;

                    default:
                        System.out.println("Scelta non valida!");
                }

            } while (scelta != 0);

            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
