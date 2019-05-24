package arnaldo.lezione7;

/**
 * Esempio di classe utilizzante Java Generics con vincoli
 * Il vincolo sul tipo generico T è che implementi l'interfaccia Comparable, in modo da rendere possibile il
 * confronto fra i due elementi
 * @param <T>
 */
public class Coppia<T extends Comparable<T>> {
    private T primo;
    private T secondo;

    /**
     * Costruttore
     * @param primo Il primo elemento della coppia
     * @param secondo Il secondo elemento della coppia
     */
    public Coppia(T primo, T secondo) {
        this.primo = primo;
        this.secondo = secondo;
    }

    /**
     * Metodo che restituisce il valore maggiore fra i due presenti nella coppia, utilizzando il metodo compareTo
     * Se i due elementi sono uguali (secondo quanto stabilito da compareTo, restituisco il secondo (tanto sono uguali)
     * @return Il valore massimo presente nella coppia
     */
    public T getMax()  {
        if (this.primo.compareTo(secondo) > 0)
            return this.primo;

        return this.secondo;
    }
}
