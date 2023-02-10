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
    private long idClient;
    private long idTaux;

    public Pret(Double montantDemande, Double montantMensualite, LocalDateTime dateSouscription, LocalDate dateEffet, String observations, long idClient, long idTaux) {
        this.id = ++compteur;
        this.montantDemande = montantDemande;
        this.montantMensualite = montantMensualite;
        this.dateSouscription = dateSouscription;
        this.dateEffet = dateEffet;
        this.observations = observations;
        this.idClient = idClient;
        this.idTaux = idTaux;
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

    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    public long getTauxInteret() {
        return idTaux;
    }

    public void setTauxInteret(long idTaux) {
        this.idTaux = idTaux;
    }
}