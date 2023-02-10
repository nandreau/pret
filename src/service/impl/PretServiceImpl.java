package service.impl;

import business.Pret;
import service.MensualiteService;
import service.PretService;
import service.TauxService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PretServiceImpl implements PretService {

    private static List<Pret> pretList = new ArrayList<>();
    private static final MensualiteService mensualiteService = new MensualiteServiceImpl();
    private static final TauxService tauxService = new TauxServiceImpl();
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

    @Override
    public List<Pret> recupererPretsParMontant() {
        pretList.sort((p1, p2) -> Double.compare(p2.getMontantDemande(), p1.getMontantDemande()));
        return pretList;
    }

    @Override
    public List<Pret> recupererPretsParTaux() {
        pretList.sort((p1, p2) -> Double.compare(tauxService.recupererTauxValeurparId(p2.getIdTaux()),
                tauxService.recupererTauxValeurparId(p1.getIdTaux()))
        );
        return pretList;
    }

    @Override
    public List<Pret> recupererPretsParIntervalle(LocalDate debut, LocalDate fin) {
        return pretList.stream()
            .filter(pret -> pret.getDateEffet().isAfter(debut) && pret.getDateEffet().isBefore(fin))
            .collect(Collectors.toList());
    }
}
