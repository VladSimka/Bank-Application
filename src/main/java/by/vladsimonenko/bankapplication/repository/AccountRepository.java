package by.vladsimonenko.bankapplication.repository;

import by.vladsimonenko.bankapplication.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query(value = """
            SELECT a.* FROM t_accounts a
            INNER JOIN t_clients cl ON a.id = cl.account_id
            WHERE cl.id = :clientId
            """, nativeQuery = true)
    Optional<Account> findByClientId(@Param("clientId") Integer clientId);
}
