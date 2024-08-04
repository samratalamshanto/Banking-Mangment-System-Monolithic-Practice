package com.application.banking_system_monolithic.dto;

import com.application.banking_system_monolithic.enums.transaction.TransactionType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {
    private String transactionType;
    private double amount;
    private String accountNumberFrom;
    @NotNull
    private String accountNumberTo;
}
