public class Knoten<T> {
    private T daten;
    private Knoten<T> naechster;

    public Knoten(T daten) {
        this.daten = daten;
        this.naechster = null;
    }

    public T getDaten() {
        return daten;
    }

    public void setDaten(T daten) {
        this.daten = daten;
    }

    public Knoten<T> getNaechster() {
        return naechster;
    }

    public void setNaechster(Knoten<T> naechster) {
        this.naechster = naechster;
    }
}