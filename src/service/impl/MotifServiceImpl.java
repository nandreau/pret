package service.impl;

import business.Motif;
import service.MotifService;

import java.util.ArrayList;
import java.util.List;

public class MotifServiceImpl implements MotifService {
    private static List<Motif> motifList = new ArrayList<>();

    @Override
    public Motif ajouterMotif(String nom, String description, double coefficient) {
        Motif motif = new Motif(nom,description,coefficient);
        motifList.add(motif);
        return motif;
    }

    @Override
    public List<Motif> recupererMotifs() {
        return motifList;
    }

    /**
     * On créé une fonction pour retourner le coefficient avec son id
     * De plus on ne va pas parcour la liste mais on va utiliser des méthodes de flux
     * pour parcourir la liste, ce qui peut être plus efficace que de parcourir la liste manuellement.
     */
    @Override
    public double getCoefficient(long id) {
        return motifList.stream() // Création d'un flux à partir de la liste des objets Motif
            .filter(motif -> motif.getId() == id) // Filtrage du flux pour n'inclure que les éléments avec l'id correspondant
            .map(Motif::getCoefficient) // On map le flux filtré pour n'inclure que le coefficient de chaque objet Motif
            .findFirst() // Obtient le premier élément du flux d'une map
            .orElse(-1.0); // Si aucun élément n'est trouvé, on renvoie -1.0
    }

    /**
     * On créé une fonction pour retourner le nom du véhicule avec son id
     */
    @Override
    public String getNom(long id) {
        return motifList.stream() // Création d'un flux à partir de la liste des objets Motif
                .filter(motif -> motif.getId() == id) // Filtrage du flux pour n'inclure que les éléments avec l'id correspondant
                .map(Motif::getNom) // On map le flux filtré pour n'inclure que le coefficient de chaque objet Motif
                .findFirst() // Obtient le premier élément du flux d'une map
                .orElse("indisponible"); // Si aucun élément n'est trouvé, on renvoie indisponible
    }
}
