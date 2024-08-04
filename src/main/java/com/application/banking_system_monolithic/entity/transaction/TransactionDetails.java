package com.application.banking_system_monolithic.entity.transaction;

import com.application.banking_system_monolithic.entity.CommonAttributes;
import com.application.banking_system_monolithic.entity.account.AccountDetails;
import com.application.banking_system_monolithic.enums.transaction.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transactions")
public class TransactionDetails extends CommonAttributes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String transactionNumber;
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    private double transactionAmount;
    @ManyToOne
    private AccountDetails transactionFromAccount;
    @ManyToOne
    private AccountDetails transactionToAccount;

}
