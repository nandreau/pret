package business;
import java.time.LocalDate;
public class Mensualite {
    private static long compteur = 0L;
    private long id;
    private LocalDate datePrelevement;
    private double partInteretsRembourses;
    private double partCapitalRembourse;
    private long idPret;

    public Mensualite(LocalDate datePrelevement, double partInteretsRembourses, double partCapitalRembourse, long idPret) {
        this.id = ++compteur;
        this.datePrelevement = datePrelevement;
        this.partInteretsRembourses = partInteretsRembourses;
        this.partCapitalRembourse = partCapitalRembourse;
        this.idPret = idPret;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDatePrelevement() {
        return datePrelevement;
    }

    public void setDatePrelevement(LocalDate datePrelevement) {
        this.datePrelevement = datePrelevement;
    }

    public double getPartInteretsRembourses() {
        return partInteretsRembourses;
    }

    public void setPartInteretsRembourses(double partInteretsRembourses) {
        this.partInteretsRembourses = partInteretsRembourses;
    }

    public double getPartCapitalRembourse() {
        return partCapitalRembourse;
    }

    public void setPartCapitalRembourse(double partCapitalRembourse) {
        this.partCapitalRembourse = partCapitalRembourse;
    }

    public long getIdPret() {
        return idPret;
    }

    public void setIdPret(long idPret) {
        this.idPret = idPret;
    }
}