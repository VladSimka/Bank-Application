package by.vladsimonenko.bankapplication.controller;

import by.vladsimonenko.bankapplication.dto.AccountResponseDto;
import by.vladsimonenko.bankapplication.mapper.AccountMapper;
import by.vladsimonenko.bankapplication.model.Account;
import by.vladsimonenko.bankapplication.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/clients/{clientId}/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;
    private final AccountMapper accountMapper;


    @GetMapping
    public AccountResponseDto findAccountByClientId(@PathVariable("clientId") Integer clientId) {
        Account account = accountService.findByClientId(clientId);

        return accountMapper.toDto(account);
    }

}
