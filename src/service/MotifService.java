package service;

import business.Motif;

import java.util.List;

public interface MotifService {
    Motif ajouterMotif(String nom, String description, double coefficient);
    List<Motif> recupererMotifs();

    int getMotifListLenght();

    double getCoefficient(long id);

    String getNom(long id);
}
