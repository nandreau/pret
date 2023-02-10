package service;

import business.Motif;

import java.util.List;

public interface MotifService {
    Motif ajouterMotif(String nom, String description, double coefficient);
    List<Motif> recupererMotifs();

    int getMotifListLenght();

    String getNom(long id);
}
