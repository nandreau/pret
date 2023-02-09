package business;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Taux {
    private static long compteur = 0L;
    private long id;
    private double valeur;

    public Taux(Double valeur, int duree, String nom, String description) {
        this.id = ++compteur;
        this.valeur = valeur;
        //todo duree, nom, description
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