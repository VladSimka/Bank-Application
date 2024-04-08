package by.vladsimonenko.bankapplication.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "t_account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Long number;

    private BigDecimal balance;
}
