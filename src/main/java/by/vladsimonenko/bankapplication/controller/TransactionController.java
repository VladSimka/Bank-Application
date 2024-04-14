package by.vladsimonenko.bankapplication.controller;


import by.vladsimonenko.bankapplication.dto.TransactionResponseDto;
import by.vladsimonenko.bankapplication.mapper.TransactionMapper;
import by.vladsimonenko.bankapplication.model.BankTransaction;
import by.vladsimonenko.bankapplication.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients/{clientId}/cards/{cardId}/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;
    private final TransactionMapper transactionMapper;


    @GetMapping
    public List<TransactionResponseDto> findAllTransactions(
            @PathVariable("clientId") Integer clientId,
            @PathVariable("cardId") Integer cardId) {

        List<BankTransaction> transactions = transactionService.findAllByCardId(cardId);

        return transactionMapper.toDto(transactions);
    }

}
