package arnaldo.lezione7;

/**
 * Esempio di classe che implementa l'interfaccia Comparable
 */
public class Pizza implements Comparable<Pizza> {
    private double prezzo;
    private String gusto;

    /**
     * Costrutture
     * @param gusto Il gusto della pizza
     * @param prezzo Il prezzo della pizza
     */
    public Pizza(String gusto, double prezzo) {
        this.prezzo = prezzo;
        this.gusto = gusto;
    }

    /**
     * Implementazione del metodo compareTo(...), definito da Comparable
     * Il confronto che fa è sul prezzo, se i due prezzi sono uguali, allora fa un confronto sulle String
     * del gusto della pizza (utilizzando il compareTo(...) della classe String
     * Ovvero ordina le pizze in ordine di prezzo e fra pizze con prezzo uguale in ordine alfabetico
     * @param pizza La pizza con cui confrontare this
     * @return 0 se le due pizze sono uguali
     *         positivo se this è maggiore dell'argomento
     *         negativo se this è minore dell'argomento
     */
    @Override
    public int compareTo(Pizza pizza) {
        // confronto fra prezzi
        if (this.prezzo != pizza.prezzo)
            return this.prezzo > pizza.prezzo ? 1 : -1;

        // confronto fra stringhe se i prezzi sono uguali
        return this.gusto.compareTo(pizza.gusto);
    }

    /**
     * Utilizzato per stampare informazioni sulla pizza
     * @return String stampabile con informazioni sulla pizza
     */
    @Override
    public String toString() {
        return String.format("Pizza %s, prezzo %f€", this.gusto, this.prezzo);
    }
}