package service.impl;

import business.Mensualite;
import service.MensualiteService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MensualiteServiceImpl implements MensualiteService {
    private static List<Mensualite> mensualiteList = new ArrayList<>();
    @Override
    public Mensualite ajouterMensualites(LocalDate datePrelevement, double partInteretsRembourses, double partCapitalRembourse, long idPret) {
        Mensualite mensualite = new Mensualite(datePrelevement, partInteretsRembourses, partCapitalRembourse, idPret);
        mensualiteList.add(mensualite);
        return mensualite;
    }
    @Override
    public List<Mensualite> recupererMensualitesById(long idPret) {
        return mensualiteList.stream().filter(m -> m.getIdPret() == idPret).collect(Collectors.toList());
}
}
