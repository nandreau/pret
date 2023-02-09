package business;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Motif {
    private static long compteur = 0L;
    private long id;
    private String nom;
    private String description;

    public Motif(String nom, String description) {
        this.id = ++compteur;
        this.nom = nom;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}