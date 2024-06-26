package by.vladsimonenko.bankapplication.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "t_cards")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = {"transactions","account"})
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String number;

    private String date;

    private String cvv;

    private BigDecimal balance;

    @OneToMany
    @JoinTable(
            name = "t_cards_transactions",
            joinColumns = @JoinColumn(name = "card_id"),
            inverseJoinColumns = @JoinColumn(name = "transaction_id")
    )
    private List<BankTransaction> transactions;

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    private BigDecimal monthLimit;

    private Timestamp dateOfSettingLimit;

    private Boolean limitExceeded;

}
