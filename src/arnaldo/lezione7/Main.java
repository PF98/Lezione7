package arnaldo.lezione7;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        /////////////////////////////////////////////////////
        // Esercizio 7.1.1

        // crea un po' di coppie e stampa il valora più grande dei due
	    Coppia<Pizza> cp = new Coppia<>(new Pizza("Sandro", 3.90), new Pizza("Carciofi", 3.90));
	    System.out.println("Valore massimo: " + cp.getMax());

        cp = new Coppia<>(new Pizza("Margherita", 5), new Pizza("Wurstel", 6.50));
        System.out.println("Valore massimo: " + cp.getMax());

        cp = new Coppia<>(new Pizza("Quattro stagioni", 7), new Pizza("Marinara", 4.50));
        System.out.println("Valore massimo: " + cp.getMax());


        System.out.println();
        /////////////////////////////////////////////////////
        // Esercizio 7.1.2

        LinkedList<Integer> ll = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 5, 4, 5, 4, 9, 4));

        // Stampa prima di chiamare il metodo
        System.out.print("Prima: [ ");
        for (int el : ll) System.out.print(el + " ");
        System.out.println("]");

        // elimina la il secondo elemento uguale a 4
        eliminaSecondo(ll, 4);

        // stampa la lista dopo aver chiamato il metodo
        System.out.print("Dopo : [ ");
        for (int el : ll) System.out.print(el + " ");
        System.out.println("]");
    }

    /**
     * Metodo generico che elimina il secondo elemento in una LinkedList uguale all'oggetto fornito e restituisce
     * il valore eliminato.
     * Il confronto fra due oggetti avviene tramite compareTo(...) dell'interfaccia Comparable
     * Questo metodo mostra un'applicazione in cui utilizzare esplicitamente gli Iterator risulta molto utile
     * @param list La LinkedList da cui eliminare l'elemento
     * @param elem L'oggetto di tipo T con cui confrontare gli elementi della LinkedList
     * @param <T> Parametro di tipo: deve implementare l'interfaccia Comparable
     * @return L'oggetto eliminato dalla lista (se presente), null altrimenti
     */
    private static <T extends Comparable<T>> T eliminaSecondo(LinkedList<T> list, T elem) {
        // creazione del listIterator dalla LinkedList
        ListIterator<T> iter = list.listIterator();
        int count = 0; // conta quanti elementi uguali abbiamo trovato
        // scorre la lista finché l'iterator ha elementi disponibili
        while (iter.hasNext()) {
            T next = iter.next();
            // confronto vero e proprio
            if (next.compareTo(elem) == 0) {
                count++;
                // se abbiamo trovato 2 elementi uguali ad elem:
                if (count == 2) {
                    // elimina in maniera molto efficiente l'elemento dalla lista
                    iter.remove();
                    return next;
                }
            }
        }

        // se arrivati in fondo alla lista non abbiamo trovato due elementi, restituiamo null
        return null;
    }
}
