package business;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Duree {
    private static long compteur = 0;
    private long id;
    private int dureeEnMois;

    public Duree(int dureeEnMois) {
        this.id = ++compteur;
        this.dureeEnMois = dureeEnMois;
    }

    public long getId() {
        return id;
    }

    public int getDureeEnMois() {
        return dureeEnMois;
    }

    public void setDureeEnMois(int dureeEnMois) {
        this.dureeEnMois = dureeEnMois;
    }
}
