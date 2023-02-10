package service;

import business.Client;
import business.Mensualite;
import business.Pret;
import business.Taux;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface PretService {
    Pret ajouterPret(Double montantDemande, Double montantMensualite, LocalDateTime dateSouscription, LocalDate dateEffet, String observations, double dureeEnMois, double coefficient, long idClient, long idTaux);
}
