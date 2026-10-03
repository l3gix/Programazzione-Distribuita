package com.mycompany.javathread.esercizio6.punto3;


public class Main {

    public static void main(String[] args) throws InterruptedException {

        int n = 100;        // numero di thread
        int m = 100000;     // incrementi per ogni thread

        System.out.println("Numero thread: " + n);
        System.out.println("Incrementi per thread: " + m);
        System.out.println("Risultato atteso: " + (n * m));
        System.out.println();


        // SENZA SINCRONIZZAZIONE
        eseguiTest(
                "Senza sincronizzazione",
                new CounterUnsafe(),
                n,
                m
        );


        // SYNCHRONIZED SUL METODO
        eseguiTest(
                "Synchronized sul metodo",
                new CounterSynchronized(),
                n,
                m
        );


        // SYNCHRONIZED CON OBJECT
        eseguiTest(
                "Synchronized con Object",
                new CounterSynchronizedBlock(),
                n,
                m
        );



        // ATOMIC INTEGER
        eseguiTest(
                "AtomicInteger",
                new CounterAtomic(),
                n,
                m
        );
    }


    public static void eseguiTest(
            String nome,
            Contatore counter,
            int n,
            int m) throws InterruptedException {

        IncrementThread[] threads =
                new IncrementThread[n];

        long inizio = System.nanoTime();


        // Creo e avvio tutti i thread
        for (int i = 0; i < n; i++) {

            threads[i] =
                    new IncrementThread(counter, m);

            threads[i].start();
        }


        // Aspetto che tutti i thread finiscano
        for (int i = 0; i < n; i++) {

            threads[i].join();
        }


        long fine = System.nanoTime();

        double tempo =
                (fine - inizio) / 1_000_000.0;


        System.out.println(nome);

        System.out.println(
                "Risultato: " + counter.getCounter()
        );

        System.out.println(
                "Tempo: " + tempo + " ms"
        );

        System.out.println();
    }
}