package com.example.AccountingLedger.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "transactions")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Transaction {

    //for transaction id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 15)
    private String type;
    @Column(nullable = false)
    private BigDecimal amount;
    @Column(nullable = false, length = 255)
    private String description;
    @Column(nullable = false)
    private Date date;
    @Column(nullable = false)
    private Time time;

}
