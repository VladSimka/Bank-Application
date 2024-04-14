package by.vladsimonenko.bankapplication.service.impl;

import by.vladsimonenko.bankapplication.model.BankTransaction;
import by.vladsimonenko.bankapplication.repository.TransactionRepository;
import by.vladsimonenko.bankapplication.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Override
    public List<BankTransaction> findAllByCardId(Integer cardId) {
        return transactionRepository.findAllByCardId(cardId);
    }


}
