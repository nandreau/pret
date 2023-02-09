package service;

import business.Taux;

public interface TauxService {
    Taux ajouterTaux(Double valeur, int dureeEnMois, String nom, String description);
}
