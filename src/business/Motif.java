package business;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Motif {
    private static long compteur = 0L;
    private long id;
    private String nom;
    private String description;
    private double coefficient;

    public Motif(String nom, String description, double coefficient) {
        this.id = ++compteur;
        this.nom = nom;
        this.description = description;
        this.coefficient = coefficient;
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

    public double getCoefficient() {
        return coefficient;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}