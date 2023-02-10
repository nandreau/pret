package business;

import java.time.LocalDate;
import java.util.ArrayList;

public class Client {
    private static long compteur = 0L;
    private ArrayList<Client> main;
    private long id;
    private String nom;
    private String prenom;
    private Pret pret;

    public Client(String prenom, String nom) {
        this.id = ++compteur;
        this.prenom = prenom;
        this.nom = nom;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Pret getPret() {
        return pret;
    }

    public void setPret(Pret pret) {
        this.pret = pret;
    }
}
