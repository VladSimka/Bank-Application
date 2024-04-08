package by.vladsimonenko.bankapplication.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "t_transactions")
public class BankTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Card from;

    @ManyToOne
    private Card to;

    private String currency;

    private Timestamp date;

    private BigDecimal amount;
}
