package service.impl;

import business.Taux;
import service.TauxService;

import java.util.ArrayList;
import java.util.List;

public class TauxServiceImpl implements TauxService {

    private static List<Taux> tauxList = new ArrayList<>();

    @Override
    public Taux ajouterTaux(Double valeur, long idMotif, long idDuree) {
        Taux taux = new Taux(valeur, idMotif, idDuree);
        tauxList.add(taux);
        return taux;
    }

    @Override
    public List<Taux> recupererTaux() {
        return tauxList;
    }
}
