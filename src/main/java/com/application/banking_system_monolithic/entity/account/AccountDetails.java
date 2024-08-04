package com.application.banking_system_monolithic.entity.account;

import com.application.banking_system_monolithic.entity.CommonAttributes;
import com.application.banking_system_monolithic.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class AccountDetails extends CommonAttributes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountNumber;
    @OneToOne(cascade = CascadeType.ALL)
    private User accountHolder;
    private double balance;
}
