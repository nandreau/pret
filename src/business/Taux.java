package business;
import business.Taux;
import java.time.LocalDate;
import java.time.LocalDateTime;
public class Taux {
    private static long compteur = 0L;
    private long id;
    private long idMotif;
    private long idDuree;
    private double valeur;

    public Taux(Double valeur, long idMotif, long idDuree) {
        this.id = ++compteur;
        this.valeur = valeur;
        this.idMotif = idMotif;
        this.idDuree = idDuree;
    }

    public long getId() {
        return id;
    }

    public long getIdDuree() {
        return idDuree;
    }

    public long getIdMotif() {
        return idMotif;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }
}