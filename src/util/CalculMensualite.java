package util;

public class CalculMensualite {

    public CalculMensualite() {
    }

    public double getCalculMensualite(double montant, double coefficient, int mois){
        double i = coefficient/100/mois;
        double resultCalcul = montant*(i / (1-Math.pow((1+i),-mois)));
        return (double)Math.round(resultCalcul*100)/100;
    }
}
