package by.vladsimonenko.bankapplication.service;

import by.vladsimonenko.bankapplication.model.Client;

public interface ClientService {

    Client findById(Integer id);

    Client findByUsername(String username);

    Client update(Client client);

    void deleteById(Integer id);

}
