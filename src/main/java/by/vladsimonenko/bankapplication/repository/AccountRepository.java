package by.vladsimonenko.bankapplication.repository;

import by.vladsimonenko.bankapplication.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {
}
