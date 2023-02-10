package service;

import business.Client;

import java.util.List;

public interface ClientService {

    Client ajouterClient(String nom, String prenom);

    List<Client> recupererClients();

    String getNomEtPrenomClient(long id);
}
