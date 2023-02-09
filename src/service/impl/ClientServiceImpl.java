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
}
