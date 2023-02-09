package service.impl;

import business.Duree;
import business.Motif;
import service.DureeService;

import java.util.ArrayList;
import java.util.List;

public class DureeServiceImpl implements DureeService {
    private static List<Duree> dureeList = new ArrayList<>();

    @Override
    public Duree ajouterDuree(int dureeEnMois) {
        Duree duree = new Duree(dureeEnMois);
        dureeList.add(duree);
        return duree;
    }

    @Override
    public List<Duree> recupererDurees() {
        return dureeList;
    }

    /**
     * On créé une fonction pour retourner la durée en moid avec son id
     * De plus on ne va pas parcour la liste mais on va utiliser des méthodes de flux
     * pour parcourir la liste, ce qui peut être plus efficace que de parcourir la liste manuellement.
     */
    @Override
    public int getDureeEnMois(long id) {
        return dureeList.stream() // Création d'un flux à partir de la liste des objets Motif
            .filter(duree -> duree.getId() == id) // Filtrage du flux pour n'inclure que les éléments avec l'id correspondant
            .map(Duree::getDureeEnMois) // On map le flux filtré pour n'inclure que le coefficient de chaque objet Motif
            .findFirst() // Obtient le premier élément du flux d'une map
            .orElse(-1); // Si aucun élément n'est trouvé, on renvoie -1
    }

}
