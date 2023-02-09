package business;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Pret {
    private static long compteur = 0L;
    private long id;
    private Double montantDemande;
    private Double montantMensualite;
    private LocalDateTime dateSouscription;
    private LocalDate dateEffet;
    private String observations;
    private Client client;
    private Mensualite mensualite;
    private Taux tauxInteret;

    public Pret(Double montantDemande, Double montantMensualite, LocalDateTime dateSouscription, LocalDate dateEffet, String observations, Client client, Mensualite mensualite, Taux tauxInteret) {
        this.id = ++compteur;
        this.montantDemande = montantDemande;
        this.montantMensualite = montantMensualite;
        this.dateSouscription = dateSouscription;
        this.dateEffet = dateEffet;
        this.observations = observations;
        this.client = client;
        this.mensualite = mensualite;
        this.tauxInteret = tauxInteret;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMontantDemande() {
        return montantDemande;
    }

    public void setMontantDemande(Double montantDemande) {
        this.montantDemande = montantDemande;
    }

    public Double getMontantMensualite() {
        return montantMensualite;
    }

    public void setMontantMensualite(Double montantMensualite) {
        this.montantMensualite = montantMensualite;
    }

    public LocalDateTime getDateSouscription() {
        return dateSouscription;
    }

    public void setDateSouscription(LocalDateTime dateSouscription) {
        this.dateSouscription = dateSouscription;
    }

    public LocalDate getDateEffet() {
        return dateEffet;
    }

    public void setDateEffet(LocalDate dateEffet) {
        this.dateEffet = dateEffet;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Mensualite getMensualite() {
        return mensualite;
    }

    public void setMensualite(Mensualite mensualite) {
        this.mensualite = mensualite;
    }

    public Taux getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(Taux tauxInteret) {
        this.tauxInteret = tauxInteret;
    }
}