package by.vladsimonenko.bankapplication.repository;

import by.vladsimonenko.bankapplication.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
