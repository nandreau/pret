package service.impl;

import business.Pret;
import service.MensualiteService;
import service.PretService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PretServiceImpl implements PretService {

    private static List<Pret> pretList = new ArrayList<>();
    private static final MensualiteService mensualiteService = new MensualiteServiceImpl();
    @Override
    public Pret ajouterPret(Double montantDemande, Double montantMensualite, LocalDateTime dateSouscription, LocalDate dateEffet, String observations, double dureeEnMois, double coefficient, long idClient, long idTaux) {
        Pret pret = new Pret(montantDemande, montantMensualite, dateSouscription, dateEffet, observations, idClient, idTaux);
        pretList.add(pret);
        for (int i=0;i<dureeEnMois;i++){
            double interets = (double)Math.round(montantMensualite * ((coefficient/100)* ((dureeEnMois-i)/dureeEnMois))*100)/100;
            double capital = (double)Math.round((montantMensualite - interets)*100)/100;;
            mensualiteService.ajouterMensualites(dateEffet.plusMonths(i),capital,interets,pret.getId());
        }
        return pret;
    }
}
