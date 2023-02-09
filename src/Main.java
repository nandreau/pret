import business.Taux;
import service.ClientService;
import service.TauxService;
import service.impl.ClientServiceImpl;
import service.impl.TauxServiceImpl;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
    private static final ClientService clientService = new ClientServiceImpl();
    private static final TauxService tauxService = new TauxServiceImpl();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
          System.out.println("Bienvenue sur prêt à la consommation");
          System.out.println("1. Voir tous les prêts triées par montant (du plus élevé au plus petit)");
          System.out.println("2. Voir tous les prêts triées par taux (du plus élevé au plus petit)");
          System.out.println("3. Voir la liste des prêts qui débutent entre deux dates données");
          System.out.println("4. Ajouter un prêt");
          System.out.println("5. Quitter");
          System.out.println("Faîtes votre choix :");
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
                ajouterJoueur();
                ajouterTaux();
  			  
            case 5:
              System.exit(0);
            default:
              System.out.println("Choix non valide. Veuillez réessayer.");
          }
        }

    }

    private static void ajouterJoueur(){
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Vous avez selectionnés : 4. Ajouter un prêt");
        clientService.ajouterClient("Alex","pont");
        clientService.ajouterClient("jean","penot");
        clientService.ajouterClient("Alexis","Barrier");
        clientService.ajouterClient("Romain","Gojart");
        clientService.ajouterClient("Maxime","Compte");
        clientService.recupererClients().forEach(
                client -> System.out.println(client.getId()+". "+client.getPrenom()+" "+client.getNom())
        );
    	System.out.println("Veuillez saisir l'id du client concerné :");
        int choice = sc.nextInt();
        
        switch(choice) {
        case 1:
          // code pour le choix 1 dans le sous-menu
        	clientService.ajouterClient("Alex","pont");
          break;
        case 2:
          // code pour le choix 2 dans le sous-menu
        	clientService.ajouterClient("jean","penot");
          break;
        case 3:
          // code pour le choix 3 dans le sous-menu
        	clientService.ajouterClient("Alexis","Barrier");
          break;
        case 4:
          // code pour le choix 4 dans le sous-menu
        	clientService.ajouterClient("Romain","Gojart");
          break;
        case 5:
          // code pour le choix 5 dans le sous-menu
        	clientService.ajouterClient("Maxime","Compte");
          break;
        default:
          System.out.println("Choix non valide. Veuillez saisir un nombre entre 1 et 5.");
      }
    }

    private static void ajouterTaux(){
        tauxService.ajouterTaux(1.0,12,"moto","véhicule a deux roues");
        /**clientService.recupererClients().forEach(
                client -> System.out.println(client.getId()+". "+client.getPrenom()+" "+client.getNom())
        );**/
    }
}