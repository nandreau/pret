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

    /**
     * On créé une fonction pour retourner la valeur du taux avec son id
     * De plus on ne va pas parcour la liste mais on va utiliser des méthodes de flux
     * pour parcourir la liste, ce qui peut être plus efficace que de parcourir la liste manuellement.
     */
    @Override
    public double recupererTauxValeurparId(long idTaux) {
        return tauxList.stream()
            .filter(taux -> taux.getId() == idTaux)
            .map(Taux::getValeur)
            .findFirst()
            .orElse(Double.valueOf(-1));
    }
}
