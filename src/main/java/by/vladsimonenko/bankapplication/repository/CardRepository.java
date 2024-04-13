package by.vladsimonenko.bankapplication.repository;

import by.vladsimonenko.bankapplication.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Integer> {


    @Modifying
    @Query(value = """      
            INSERT INTO t_clients_cards (client_id, card_id) 
            VALUES (:clientId, :cardId)
                """, nativeQuery = true)
    void connectCardToClient(@Param("cardId") Integer cardId, @Param("clientId") Integer clientId);


    @Modifying
    @Query(value = """      
            UPDATE t_cards
            SET account_Id = (SELECT account_id FROM t_clients WHERE id = :clientId)
            WHERE id = :cardId
            """, nativeQuery = true)
    void connectCardToAccount(@Param("cardId") Integer cardId, @Param("clientId") Integer clientId);

    @Query(value = """
            SELECT * FROM t_cards c
            JOIN t_clients_cards cc ON cc.card_id = c.id
            WHERE cc.client_id = :clientId
            """, nativeQuery = true)
    List<Card> findAllCardsByClientId(@Param("clientId") Integer clientId);
}
