import service.ClientService;
import service.impl.ClientServiceImpl;
import java.time.LocalDate;

public class Main {
    private static final ClientService clientService = new ClientServiceImpl();

    public static void main(String[] args) {
        clientService.ajouterClient("Alex","pont");
        //System.out.println(clientService.recupererClients());
        clientService.recupererClients().forEach(
                client -> System.out.println(client.getPrenom()+client.getNom())
        );
    }
}