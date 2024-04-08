package by.vladsimonenko.bankapplication.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_clients")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String username;

    private String password;

    @OneToMany
    @JoinTable(
            name = "t_clients_cards",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "card_id")
    )
    @Builder.Default
    private List<Card> cards = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

}
