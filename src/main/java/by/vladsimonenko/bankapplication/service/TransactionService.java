package by.vladsimonenko.bankapplication.service;

import by.vladsimonenko.bankapplication.model.BankTransaction;
import java.util.List;

public interface TransactionService {

    List<BankTransaction> findAllByCardId(Integer cardId);
}
