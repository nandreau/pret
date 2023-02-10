package service;

import business.Mensualite;

import java.time.LocalDate;
import java.util.List;

public interface MensualiteService {
    Mensualite ajouterMensualites(LocalDate datePrelevement, double partInteretsRembourses, double partCapitalRembourse, long idPret);

    List<Mensualite> recupererMensualitesById(long idPret);
}
