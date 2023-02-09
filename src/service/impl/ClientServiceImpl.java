package service.impl;

import business.Client;

import java.util.ArrayList;
import java.util.List;

import service.ClientService;

public class ClientServiceImpl implements ClientService {
    private static List<Client> clients = new ArrayList<>();

    @Override
    public Client ajouterClient(String nom, String prenom) {
        Client client = new Client(nom, prenom);
        clients.add(client);
        return client;
    }


    @Override
    public List<Client> recupererClients() {
        return clients;
    }

}
