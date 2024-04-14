package by.vladsimonenko.bankapplication.repository;

import by.vladsimonenko.bankapplication.model.BankTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepository extends JpaRepository<BankTransaction, Integer> {


    @Modifying
    @Query(value = """
            INSERT INTO t_cards_transactions (card_id, transaction_id) 
            VALUES (:cardId, :transactionId)
            """, nativeQuery = true)
    void connectTransactionToCard(@Param("transactionId") Integer transactionId, @Param("cardId") Integer cardId);


    @Query(value = """
            SELECT * FROM t_transactions t
            JOIN t_cards_transactions ct ON ct.transaction_id = t.id 
            WHERE ct.card_id = :cardId
            """, nativeQuery = true)
    List<BankTransaction> findAllByCardId(@Param("cardId") Integer cardId);
}
