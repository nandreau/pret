import business.Client;
import business.Taux;
import service.ClientService;
import service.DureeService;
import service.MotifService;
import service.TauxService;
import service.impl.ClientServiceImpl;
import service.impl.DureeServiceImpl;
import service.impl.MotifServiceImpl;
import service.impl.TauxServiceImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.List;
import java.util.Scanner;


public class Main {
	static Scanner sc = new Scanner(System.in);
    private static final ClientService clientService = new ClientServiceImpl();
    private static final TauxService tauxService = new TauxServiceImpl();
    private static final DureeService dureeService = new DureeServiceImpl();
    private static final MotifService motifService = new MotifServiceImpl();

    public static void main(String[] args) {
        ajouterJoueurs();
        ajouterTaux();
        initChoix();
        Scanner sc = new Scanner(System.in);
        while (true) {
          int choice = sc.nextInt();

          switch (choice) {
            case 1:
              // Code pour afficher les prêts triées par montant
              break;
            case 2:
              // Code pour afficher les prêts triées par taux
              break;
            case 3:
              // Code pour afficher la liste des prêts entre deux dates
              break;
            case 4:
              // Code pour ajouter un prêt
                initPret();
            case 5:
              System.exit(0);
            default:
              System.out.println("Choix non valide. Veuillez réessayer.");
          }
        }
    }

    private static void initChoix(){
        System.out.println("Bienvenue sur prêt à la consommation");
        System.out.println("1. Voir tous les prêts triées par montant (du plus élevé au plus petit)");
        System.out.println("2. Voir tous les prêts triées par taux (du plus élevé au plus petit)");
        System.out.println("3. Voir la liste des prêts qui débutent entre deux dates données");
        System.out.println("4. Ajouter un prêt");
        System.out.println("5. Quitter");
        System.out.println("Faîtes votre choix :");
    }

    private static void initPret() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vous avez selectionnés : 4. Ajouter un prêt");
        afficherJoueurs();

        System.out.println("Veuillez saisir l'id du client concerné :");
        long idClient  = selectJoueur();

        System.out.println("Veuillez saisir le montant demandé :");
        int montantDemande = choisirMontant();

        long idTauxAnnuel = afficherEtSelectTaux();

        System.out.println("Veuillez saisir la date d'effet au format MM/yyyy :");
        LocalDate dateEffet = selectDateEffet();

    }

    private static void ajouterJoueurs(){
        clientService.ajouterClient("Alex","pont");
        clientService.ajouterClient("jean","penot");
        clientService.ajouterClient("Alexis","Barrier");
        clientService.ajouterClient("Romain","Gojart");
        clientService.ajouterClient("Maxime","Compte");
    }

    private static void afficherJoueurs(){
        clientService.recupererClients().forEach(
                client -> System.out.println(client.getId()+". "+client.getPrenom()+" "+client.getNom())
        );
    }
    private static long selectJoueur() {
        while (true) {
            long choixId = sc.nextInt();
            boolean idExiste = clientService.recupererClients().stream().anyMatch(client -> client.getId() == choixId);
            if (idExiste) {
                return choixId;
            } else {
                System.out.println("L'id ne correspond à aucun client. Veuillez saisir un id valide.");
            }
        }
    }

    private static void ajouterTaux(){
        dureeService.ajouterDuree(12);
        dureeService.ajouterDuree(24);

        motifService.ajouterMotif("moto","vehicule à deux roues",0.8);
        motifService.ajouterMotif("auto","vehicule à quatres roues",1);
        motifService.ajouterMotif("velo electrique","moyen de déplacement à deux roues écologique",0.3);

        dureeService.ajouterDuree(36);
    }

    private static long afficherEtSelectTaux(){
        List<Taux> tauxList = tauxService.recupererTaux();
        tauxList.sort((t1, t2) -> motifService.getNom(t1.getIdMotif()).compareTo(motifService.getNom(t2.getIdMotif())));

        int index = 0;
        for (Taux taux : tauxList) {
            int dureeEnMois = dureeService.getDureeEnMois(taux.getIdDuree());
            double calculTaux = (double)Math.round(motifService.getCoefficient(taux.getIdMotif()) * (dureeEnMois/12)*10)/10;
            System.out.println(++index +". "+calculTaux+"% sur "+dureeEnMois+" mois pour "+motifService.getNom(taux.getIdMotif()));
        }

        System.out.println("Veuillez saisir l'id du taux annuel :");
        while (true) {
            long choixId = sc.nextInt();
            boolean tauxChoisi = tauxList.stream().anyMatch(client -> client.getId() == choixId);
            if (tauxChoisi) {
                return choixId;
            } else {
                System.out.println("Choix du taux non valide. Veuillez saisir un id valide.");
            }
        }
    }

    public static LocalDate selectDateEffet() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String dateStr = sc.nextLine();
            try {
                // ResolverStyle.STRICT for 30, 31 days checking, and also leap year.
                return LocalDate.parse("01/"+dateStr,
                        DateTimeFormatter.ofPattern("d/M/uuuu").withResolverStyle(ResolverStyle.STRICT)
                );
            } catch (DateTimeParseException e) {
                System.out.println("Format de date non valide. Veuillez entrer une date au format MM/yyyy.");
            }
        }
    }

    public static int choisirMontant(){
        while (true) {
            int choixMontant = sc.nextInt();
            if (choixMontant > 0) {
                return choixMontant;
            } else {
                System.out.println("Choix du montant non valide. Veuillez saisir un montant supérieur à 0.");
            }
        }
    }
}