package by.vladsimonenko.bankapplication.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "t_card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Long number;

    private Timestamp date;

    private Integer cvv;

    @OneToMany
    @JoinTable(
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
