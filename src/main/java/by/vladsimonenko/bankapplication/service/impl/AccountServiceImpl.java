package by.vladsimonenko.bankapplication.service.impl;

import by.vladsimonenko.bankapplication.exception.ResourceNotFoundException;
import by.vladsimonenko.bankapplication.model.Account;
import by.vladsimonenko.bankapplication.repository.AccountRepository;
import by.vladsimonenko.bankapplication.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;


    @Override
    @Transactional
    public Account create(Integer clientId) {
        //TODO
        return null;
    }

    @Override
    public Account findByClientId(Integer clientId) {
        return accountRepository.findByClientId(clientId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Account with client id %d not found".formatted(clientId)
                ));
    }
}
