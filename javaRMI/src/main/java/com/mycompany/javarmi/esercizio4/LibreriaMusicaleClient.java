package com.mycompany.javarmi.esercizio4;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class LibreriaMusicaleClient {

    static Logger logger = Logger.getLogger("global");

    public static void main(String args[]) {

        try {

            Registry registry = LocateRegistry.getRegistry();

            logger.info("Sto cercando l'oggetto remoto...");

            LibreriaMusicale obj = (LibreriaMusicale)
                    registry.lookup("LibreriaMusicaleServer");

            logger.info("Oggetto remoto trovato!");

            Scanner scanner = new Scanner(System.in);

            System.out.print("Inserisci il nome del client: ");
            String nomeClient = scanner.nextLine();

            int scelta;

            do {

                System.out.println("\n===== LIBRERIA MUSICALE =====");
                System.out.println("1. Visualizza canzoni");
                System.out.println("2. Aggiungi canzone");
                System.out.println("3. Crea playlist");
                System.out.println("4. Visualizza playlist");
                System.out.println("5. Riproduci canzone");
                System.out.println("6. Riproduci playlist");
                System.out.println("7. TOP 10 canzoni");
                System.out.println("8. TOP 10 playlist");
                System.out.println("0. Esci");

                System.out.print("Inserisci scelta: ");

                scelta = scanner.nextInt();
                scanner.nextLine();

                switch (scelta) {

                    case 1: {

                        logger.info("Visualizzo le canzoni...");

                        List<Canzone> canzoni = obj.visualizzaCanzoni();

                        for (Canzone c : canzoni) {
                            System.out.println(c);
                        }

                        break;
                    }

                    case 2: {

                        System.out.print("Titolo canzone: ");
                        String titolo = scanner.nextLine();

                        System.out.print("Link YouTube: ");
                        String link = scanner.nextLine();

                        Canzone c = new Canzone(
                                titolo, link, nomeClient
                        );

                        boolean risultato = obj.aggiungiCanzone(c);

                        System.out.println(
                                "Esito aggiunta: " + risultato
                        );

                        break;
                    }

                    case 3: {

                        System.out.print("Titolo playlist: ");
                        String titolo = scanner.nextLine();

                        System.out.print("Numero di canzoni: ");
                        int numero = scanner.nextInt();
                        scanner.nextLine();

                        List<String> titoli = new ArrayList<>();

                        for (int i = 0; i < numero; i++) {

                            System.out.print("Titolo canzone: ");
                            String nome = scanner.nextLine();

                            titoli.add(nome);
                        }

                        boolean risultato =
                                obj.creaPlaylist(titolo, titoli);

                        System.out.println(
                                "Esito creazione playlist: " + risultato
                        );

                        break;
                    }

                    case 4: {

                        logger.info("Visualizzo le playlist...");

                        List<Playlist> playlists =
                                obj.visualizzaPlaylist();

                        for (Playlist p : playlists) {
                            System.out.println(p);
                        }

                        break;
                    }

                    case 5: {

                        System.out.print("Titolo canzone: ");
                        String titolo = scanner.nextLine();

                        String link = obj.riproduciCanzoni(titolo);

                        if (link != null) {
                            System.out.println("Link YouTube: " + link);
                        } else {
                            System.out.println("Canzone non trovata!");
                        }

                        break;
                    }

                    case 6: {

                        System.out.print("Titolo playlist: ");
                        String titolo = scanner.nextLine();

                        List<String> links =
                                obj.riproduciPlaylist(titolo);

                        if (links != null) {

                            for (String link : links) {
                                System.out.println(link);
                            }

                        } else {
                            System.out.println("Playlist non trovata!");
                        }

                        break;
                    }

                    case 7: {

                        System.out.print(
                                "Inserisci periodo (7, 30, 365 giorni): "
                        );

                        int giorni = scanner.nextInt();
                        scanner.nextLine();

                        List<String> top = obj.top10Canzoni(giorni);

                        System.out.println("\nTOP 10 CANZONI");

                        for (String s : top) {
                            System.out.println(s);
                        }

                        break;
                    }

                    case 8: {

                        System.out.print(
                                "Inserisci periodo (7, 30, 365 giorni): "
                        );

                        int giorni = scanner.nextInt();
                        scanner.nextLine();

                        List<String> top = obj.top10Playlist(giorni);

                        System.out.println("\nTOP 10 PLAYLIST");

                        for (String s : top) {
                            System.out.println(s);
                        }

                        break;
                    }

                    case 0: {

                        System.out.println("Chiusura client...");
                        break;
                    }

                    default: {

                        System.out.println("Scelta non valida!");
                    }
                }

            } while (scelta != 0);

            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}