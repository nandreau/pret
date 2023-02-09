package service;

import business.Taux;

import java.util.List;

public interface TauxService {

    Taux ajouterTaux(Double valeur, long idMotif, long idDuree);

    List<Taux> recupererTaux();
}
