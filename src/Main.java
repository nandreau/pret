import business.Taux;
import service.ClientService;
import service.TauxService;
import service.impl.ClientServiceImpl;
import service.impl.TauxServiceImpl;

import java.time.LocalDate;

public class Main {
    private static final ClientService clientService = new ClientServiceImpl();
    private static final TauxService tauxService = new TauxServiceImpl();
    public static void main(String[] args) {
        ajouterJoueur();
        ajouterTaux();
    }

    private static void ajouterJoueur(){
        clientService.ajouterClient("Alex","pont");
        clientService.ajouterClient("jean","penot");
        clientService.ajouterClient("Alexis","Barrier");
        clientService.ajouterClient("Romain","Gojart");
        clientService.ajouterClient("Maxime","Compte");
        clientService.recupererClients().forEach(
                client -> System.out.println(client.getId()+". "+client.getPrenom()+" "+client.getNom())
        );
    }

    private static void ajouterTaux(){
        tauxService.ajouterTaux(1.0,12,"moto","véhicule a deux roues");
        /**clientService.recupererClients().forEach(
                client -> System.out.println(client.getId()+". "+client.getPrenom()+" "+client.getNom())
        );**/
    }
}