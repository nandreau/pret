package service;

import business.Pret;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface PretService {
    Pret ajouterPret(Double montantDemande, Double montantMensualite, LocalDateTime dateSouscription, LocalDate dateEffet, String observations, double dureeEnMois, double coefficient, long idClient, long idTaux);

    List<Pret> recupererPretsParMontant();

    List<Pret> recupererPretsParTaux();

    List<Pret> recupererPretsParIntervalle(LocalDate debut, LocalDate fin);
}
