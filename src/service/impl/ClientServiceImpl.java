package service.impl;

import business.Client;

import java.util.ArrayList;
import java.util.List;

import service.ClientService;

public class ClientServiceImpl implements ClientService {
    private static List<Client> clientsList = new ArrayList<>();

    @Override
    public Client ajouterClient(String nom, String prenom) {
        Client client = new Client(nom, prenom);
        clientsList.add(client);
        return client;
    }

    @Override
    public List<Client> recupererClients() {
        return clientsList;
    }

    /**
     * On créé une fonction pour retourner le nom et prenom du client avec son id
     * De plus on ne va pas parcour la liste mais on va utiliser des méthodes de flux
     * pour parcourir la liste, ce qui peut être plus efficace que de parcourir la liste manuellement.
     */
    @Override
    public String getNomEtPrenomClient(long id) {
        return clientsList.stream()
                .filter(client -> client.getId() == id)
                .map(client -> client.getPrenom() + " " + client.getNom())
                .findFirst()
                .orElse("Introuvable");
    }

}
