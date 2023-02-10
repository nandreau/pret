import business.Client;
import business.Pret;
import business.Taux;
import service.*;
import service.impl.*;
import util.CalculMensualite;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;


public class Main {
	static Scanner sc = new Scanner(System.in);
    private static final ClientService clientService = new ClientServiceImpl();
    private static final TauxService tauxService = new TauxServiceImpl();
    private static final DureeService dureeService = new DureeServiceImpl();
    private static final MotifService motifService = new MotifServiceImpl();
    private static final PretService pretService = new PretServiceImpl();
    private static final MensualiteService mensualiteService = new MensualiteServiceImpl();
    private static final CalculMensualite calculMensualite = new CalculMensualite();
    public static void main(String[] args) {
        ajouterClients();
        ajouterTaux();
        ajouterPret();
        System.out.println("Bienvenue sur prêt à la consommation");
        initChoix();
    }

    private static void initChoix(){
        System.out.println("1. Voir tous les prêts triées par montant (du plus élevé au plus petit)");
        System.out.println("2. Voir tous les prêts triées par taux (du plus élevé au plus petit)");
        System.out.println("3. Voir la liste des prêts qui débutent entre deux dates données");
        System.out.println("4. Ajouter un prêt");
        System.out.println("5. Ajouter une durée");
        System.out.println("6. Ajouter un motif");
        System.out.println("7. Quitter");
        System.out.print("Faîtes votre choix : ");
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
                    break;
                case 5:
                    // Code pour ajouter une durée
                    initDuree();
                    break;
                case 6:
                    // Code pour ajouter un motif
                    initMotif();
                    break;
                case 7:
                    System.out.print("Au revoir");
                    System.exit(0);
                default:
                    System.out.println("Choix non valide. Veuillez réessayer.");
            }
        }
    }

    private static void initDuree() {
        System.out.println("Vous avez sélectionné : 5. Ajouter une durée");
        System.out.print("Veuillez saisir la durée en mois souhaitée : ");
        boolean validInput = false;
        int duree = 0;
        while (!validInput) {
            try {
                duree = sc.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Durée non valide, veuillez saisir un nombre entier.");
                sc.next();
            }
        }
        dureeService.ajouterDuree(duree);
        System.out.println("La durée a été ajoutée avec succès !");
        initChoix();
    }

    private static void initMotif() {
        System.out.println("Vous avez sélectionné : 6. Ajouter un motif");
        System.out.print("Veuillez saisir le nom du véhicule souhaité : ");
        String nomMotif = sc.nextLine();
        System.out.print("Veuillez saisir la description du véhicule souhaité : ");
        String descriptionMotif = sc.nextLine();
        boolean isValid = false;
        double coefficientMotif = 0;
        while (!isValid) {
            System.out.print("Veuillez saisir le coefficient du véhicule souhaité : ");
            if (sc.hasNextDouble()) {
                coefficientMotif = sc.nextDouble();
                isValid = true;
            } else {
                System.out.println("Coefficient non valide, veuillez saisir un nombre");
                sc.next();
            }
        }
        motifService.ajouterMotif(nomMotif, descriptionMotif, coefficientMotif);
        System.out.println("Le motif a été ajouté avec succès");
        initChoix();
    }

    private static void initPret() {
        System.out.println("Vous avez selectionnés : 4. Ajouter un prêt");
        afficherClients();

        System.out.print("Veuillez saisir l'id du client concerné : ");
        Client client  = selectClient();

        System.out.print("Veuillez saisir le montant demandé : ");
        Double montantDemande = choisirMontant();

        Taux tauxAnnuel = afficherEtSelectTaux();

        System.out.print("Veuillez saisir la date d'effet au format MM/yyyy : ");
        LocalDate dateEffet = selectDateEffet();
        LocalDateTime dateSouscription = LocalDateTime.now();

        double montantMensualite = calculMensualite.getCalculMensualite(montantDemande,tauxAnnuel.getValeur(),dureeService.getDureeEnMois(tauxAnnuel.getIdDuree()));
        Pret pretCree = pretService.ajouterPret(montantDemande, montantMensualite, dateSouscription, dateEffet, "", dureeService.getDureeEnMois(tauxAnnuel.getIdDuree()),tauxAnnuel.getValeur(), client.getId(),tauxAnnuel.getId());

        System.out.println("Voici les détails du prêt : id : "+pretCree.getId()+", client : "+client.getPrenom()+" "+client.getNom() +", montant emprunté : "+pretCree.getMontantDemande()+", mensualité : "+pretCree.getMontantMensualite());
        printArrayRemboursement(pretCree.getId());

        initChoix();
    }

    private static void ajouterMotif(ArrayList<String> listeMotifs, String motif) {
        listeMotifs.add(motif);
    }

    private static void ajouterClients(){
        clientService.ajouterClient("Alex","pont");
        clientService.ajouterClient("jean","penot");
        clientService.ajouterClient("Alexis","Barrier");
        clientService.ajouterClient("Romain","Gojart");
        clientService.ajouterClient("Maxime","Compte");
    }

    private static void afficherClients(){
        clientService.recupererClients().forEach(
                client -> System.out.println(client.getId()+". "+client.getPrenom()+" "+client.getNom())
        );
    }
    private static Client selectClient() {
        while (true) {
            long choixId = sc.nextInt();
            Client choixJoueur = clientService.recupererClients().stream().filter(client -> client.getId() == choixId).findFirst().orElse(null);;
            if (choixJoueur != null) {
                return choixJoueur;
            } else {
                System.out.println("L'id ne correspond à aucun client. Veuillez saisir un id valide.");
            }
        }
    }
    private static void ajouterPret(){

    }
    private static void ajouterTaux(){
        motifService.ajouterMotif("moto","vehicule à deux roues",0.8);
        motifService.ajouterMotif("auto","vehicule à quatres roues",1);
        motifService.ajouterMotif("velo electrique","moyen de déplacement à deux roues écologique",0.3);

        dureeService.ajouterDuree(12);
        dureeService.ajouterDuree(24);
        dureeService.ajouterDuree(36);
    }
    
    private static void ajouterDuree(ArrayList<Integer> listeDurees, int duree) {
        listeDurees.add(duree);
    }

    private static Taux afficherEtSelectTaux(){
        List<Taux> tauxList = tauxService.recupererTaux();
        tauxList.sort((t1, t2) -> motifService.getNom(t1.getIdMotif()).compareTo(motifService.getNom(t2.getIdMotif())));

        int index = 0;
        for (Taux taux : tauxList) {
            int dureeEnMois = dureeService.getDureeEnMois(taux.getIdDuree());
            System.out.println(++index +". "+taux.getValeur()+"% sur "+dureeEnMois+" mois pour "+motifService.getNom(taux.getIdMotif()));
        }

        System.out.print("Veuillez saisir l'id du taux annuel : ");
        while (true) {
            int choixId = sc.nextInt();
            if (choixId >= 1 && choixId < tauxList.size()) {
                return tauxList.get(choixId-1);
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
                LocalDate dateChoisi = LocalDate.parse("01/"+dateStr,
                        DateTimeFormatter.ofPattern("d/M/uuuu").withResolverStyle(ResolverStyle.STRICT)
                );
                LocalDate today = LocalDate.now();

                if (today.isAfter(dateChoisi)){
                    System.out.println("La date choisi doit être antérieur ou égale à la date d'aujourd'hui");
                }else {
                    return dateChoisi;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Format de date non valide. Veuillez entrer une date au format MM/yyyy.");
            }
        }
    }

    public static Double choisirMontant(){
        while (true) {
                Double choixMontant = sc.nextDouble();
            if (choixMontant > 0) {
                return choixMontant;
            } else {
                System.out.println("Choix du montant non valide. Veuillez saisir un montant supérieur à 0.");
            }
        }
    }
    public static void printArrayRemboursement(long pretId) {
        System.out.println("Date            | Capital rembourse    | Part des interets");
        System.out.println("----------------+----------------------+--------------------");
        AtomicReference<Double> CapitalRembourse= new AtomicReference<>((double) 0);
        mensualiteService.recupererMensualitesById(pretId).forEach(
                mensualite -> {
                    CapitalRembourse.set((double)Math.round(CapitalRembourse.get() + mensualite.getPartInteretsRembourses()*100)/100);
                    System.out.println(String.format(
                            "%-15s %-22s %-15s",
                            mensualite.getDatePrelevement(),
                            "| "+CapitalRembourse,
                            "| "+mensualite.getPartCapitalRembourse())
                    );
                }
        );
    }
}