package by.vladsimonenko.bankapplication.service;

import by.vladsimonenko.bankapplication.model.Account;

public interface AccountService {

    Account create(Integer clientId);

    Account findByClientId(Integer clientId);
}
