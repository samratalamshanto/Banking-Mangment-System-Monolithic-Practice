package com.application.banking_system_monolithic.enums.transaction;

import lombok.Getter;

@Getter
public enum TransactionType {
    Withdraw,
    Debit,
    Credit;

    public static TransactionType getValue(String value) {
        if (value.equals("Debit")) {
            return TransactionType.Debit;
        } else if (value.equals("Credit")) {
            return TransactionType.Credit;
        } else if (value.equals("Withdraw")) {
            return TransactionType.Withdraw;
        } else {
            return null;
        }
    }
}
