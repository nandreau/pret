package service.impl;

import business.Taux;
import service.TauxService;

import java.util.ArrayList;
import java.util.List;

public class TauxServiceImpl implements TauxService {

    private static List<Taux> tauxList = new ArrayList<>();

    @Override
    public Taux ajouterTaux(Double valeur, int dureeEnMois, String nom, String description) {
        Taux taux = new Taux(valeur, dureeEnMois, nom, description);
        tauxList.add(taux);
        return taux;
    }
}
