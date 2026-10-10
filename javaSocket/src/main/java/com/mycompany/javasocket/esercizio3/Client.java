package com.mycompany.javasocket.esercizio3;




import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class Client {

    static Logger logger = Logger.getLogger("global");

    public static void main(String[] args) throws Throwable {

        Scanner scanner = new Scanner(System.in);
        LibreriaMusicaleStub libreria = null;

        try {

            // ==========================================
            // 1. RICERCA DELLA LIBRERIA NEL REGISTRO
            // ==========================================

            RecordRegistro richiesta =
                    new RecordRegistro("LibreriaMusicale", null);

            Socket socketRegistro = new Socket("localhost", 7000);

            ObjectOutputStream socketOut =
                    new ObjectOutputStream(socketRegistro.getOutputStream());

            socketOut.writeObject(richiesta);
            socketOut.flush();

            ObjectInputStream socketIn =
                    new ObjectInputStream(socketRegistro.getInputStream());

            RecordRegistro risultato =
                    (RecordRegistro) socketIn.readObject();

            socketRegistro.close();

            // Verifica se la libreria esiste
            if (risultato == null) {

                System.out.println(
                        "ERRORE: Libreria musicale non trovata nel registro!"
                );

                return;
            }

            System.out.println("Libreria musicale trovata!");
            System.out.println("Indirizzo: " + risultato.getIndirizzo());

            // ==========================================
            // 2. CREAZIONE DELLO STUB
            // ==========================================

            libreria = new LibreriaMusicaleStub(
                    risultato.getIndirizzo()
            );

            System.out.println("Connessione al server riuscita!");

            // ==========================================
            // 3. MENU INTERATTIVO
            // ==========================================

            int scelta;

            do {

                System.out.println("\n==================================");
                System.out.println("        LIBRERIA MUSICALE");
                System.out.println("==================================");

                System.out.println("1. Aggiungi brano");
                System.out.println("2. Rimuovi brano");
                System.out.println("3. Visualizza tutti i brani");
                System.out.println("4. Cerca brano per titolo");
                System.out.println("5. Cerca brano per artista");
                System.out.println("6. Ottieni link streaming");
                System.out.println("0. Esci");

                System.out.println("==================================");
                System.out.print("Scegli un'operazione: ");

                scelta = Integer.parseInt(scanner.nextLine());

                switch (scelta) {

                    // ==================================
                    // AGGIUNTA BRANO
                    // ==================================
                    case 1:

                        System.out.println("\n--- AGGIUNGI BRANO ---");

                        System.out.print("Inserisci ID: ");
                        int id = Integer.parseInt(scanner.nextLine());

                        System.out.print("Inserisci titolo: ");
                        String titolo = scanner.nextLine();

                        System.out.print("Inserisci artista: ");
                        String artista = scanner.nextLine();

                        System.out.print("Inserisci link streaming: ");
                        String link = scanner.nextLine();

                        Brano nuovoBrano =
                                new Brano(id, titolo, artista, link);

                        boolean aggiunto =
                                libreria.aggiungiBrano(nuovoBrano);

                        if (aggiunto) {
                            System.out.println(
                                    "Brano aggiunto correttamente!"
                            );
                        } else {
                            System.out.println(
                                    "Errore: esiste gia' un brano con questo ID!"
                            );
                        }

                        break;

                    // ==================================
                    // RIMOZIONE BRANO
                    // ==================================
                    case 2:

                        System.out.println("\n--- RIMUOVI BRANO ---");

                        System.out.print("Inserisci ID del brano: ");
                        int idRimuovi =
                                Integer.parseInt(scanner.nextLine());

                        boolean rimosso =
                                libreria.rimuoviBrano(idRimuovi);

                        if (rimosso) {
                            System.out.println(
                                    "Brano rimosso correttamente!"
                            );
                        } else {
                            System.out.println(
                                    "Brano non trovato!"
                            );
                        }

                        break;

                    // ==================================
                    // VISUALIZZAZIONE BRANI
                    // ==================================
                    case 3:

                        System.out.println("\n--- LISTA BRANI ---");

                        List<Brano> brani =
                                libreria.visualizzaBrani();

                        if (brani.isEmpty()) {

                            System.out.println(
                                    "La libreria musicale e' vuota!"
                            );

                        } else {

                            for (Brano brano : brani) {
                                System.out.println(brano);
                            }
                        }

                        break;

                    // ==================================
                    // RICERCA PER TITOLO
                    // ==================================
                    case 4:

                        System.out.println("\n--- CERCA PER TITOLO ---");

                        System.out.print("Inserisci titolo: ");
                        String titoloRicerca = scanner.nextLine();

                        List<Brano> risultatiTitolo =
                                libreria.cercaPerTitolo(titoloRicerca);

                        if (risultatiTitolo.isEmpty()) {

                            System.out.println(
                                    "Nessun brano trovato!"
                            );

                        } else {

                            for (Brano brano : risultatiTitolo) {
                                System.out.println(brano);
                            }
                        }

                        break;

                    // ==================================
                    // RICERCA PER ARTISTA
                    // ==================================
                    case 5:

                        System.out.println("\n--- CERCA PER ARTISTA ---");

                        System.out.print("Inserisci artista: ");
                        String artistaRicerca = scanner.nextLine();

                        List<Brano> risultatiArtista =
                                libreria.cercaPerArtista(artistaRicerca);

                        if (risultatiArtista.isEmpty()) {

                            System.out.println(
                                    "Nessun brano trovato!"
                            );

                        } else {

                            for (Brano brano : risultatiArtista) {
                                System.out.println(brano);
                            }
                        }

                        break;

                    // ==================================
                    // OTTIENI LINK STREAMING
                    // ==================================
                    case 6:

                        System.out.println("\n--- LINK STREAMING ---");

                        System.out.print("Inserisci ID del brano: ");
                        int idLink =
                                Integer.parseInt(scanner.nextLine());

                        String linkStreaming =
                                libreria.ottieniLink(idLink);

                        if (linkStreaming != null) {

                            System.out.println(
                                    "Link streaming: " + linkStreaming
                            );

                        } else {

                            System.out.println(
                                    "Brano non trovato!"
                            );
                        }

                        break;

                    // ==================================
                    // USCITA
                    // ==================================
                    case 0:

                        System.out.println(
                                "Disconnessione dalla libreria musicale..."
                        );

                        break;

                    default:

                        System.out.println(
                                "Scelta non valida! Riprova."
                        );
                }

            } while (scelta != 0);

        } catch (NumberFormatException e) {

            System.out.println(
                    "Errore: devi inserire un numero valido!"
            );

        } catch (Exception e) {

            logger.severe("Errore: " + e.getMessage());
            e.printStackTrace();

        } finally {

            if (libreria != null) {

                try {
                    libreria.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            scanner.close();
        }
    }
}