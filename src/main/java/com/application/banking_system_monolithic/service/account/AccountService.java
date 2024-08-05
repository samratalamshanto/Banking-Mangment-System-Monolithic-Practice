package com.application.banking_system_monolithic.service.account;

import com.application.banking_system_monolithic.dto.CommonResponse;
import com.application.banking_system_monolithic.dto.TransactionDto;
import com.application.banking_system_monolithic.entity.account.AccountDetails;
import com.application.banking_system_monolithic.entity.transaction.TransactionDetails;
import com.application.banking_system_monolithic.entity.user.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {
    void createAccount(User user);

    CommonResponse debitOperation(TransactionDto dto, HttpServletRequest request);

    CommonResponse creditOperation(TransactionDto dto, HttpServletRequest request);

    List<TransactionDetails> saveTransaction(TransactionDto dto, AccountDetails fromAccountDetails, AccountDetails toAccountDetails, HttpServletRequest request);

    CommonResponse getTransactionDetails(String accountNumber, HttpServletRequest request);
}
