package business;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Taux {
    private static long compteur = 0;
    private long id;
    private double valeur;

    public Taux(double valeur) {
        this.id = ++compteur;
        this.valeur = valeur;
    }

    public long getId() {
        return id;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }
}