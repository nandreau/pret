package util;

public class CalculTaux {
    public CalculTaux() {
    }

    /**
     * Le taux est calculé en fonction du type du véhicule de base et augmente de manière progressive au fil des mois
     * Après un an le taux va seulement doublé de moitié chaque année
     */
    public double getCalculTaux(double coefficient, int dureeEnMois){
        double resultTaux = (double)Math.round((coefficient + (coefficient /2)*((dureeEnMois-12)/12)) *10)/10;
        return resultTaux;
    }
}
