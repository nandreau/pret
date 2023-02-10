package service;

import business.Duree;

import java.time.LocalDate;
import java.util.List;

public interface DureeService {
    Duree ajouterDuree(int dureeEnMois);

    List<Duree> recupererDurees();

    int getDureeListLenght();

    int getDureeEnMois(long id);

}
