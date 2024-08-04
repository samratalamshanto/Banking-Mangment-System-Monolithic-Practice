package com.application.banking_system_monolithic.service.account;

import com.application.banking_system_monolithic.dto.CommonResponse;
import com.application.banking_system_monolithic.dto.TransactionDto;
import com.application.banking_system_monolithic.entity.account.AccountDetails;
import com.application.banking_system_monolithic.entity.transaction.TransactionDetails;
import com.application.banking_system_monolithic.entity.user.User;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {
    void createAccount(User user);

    CommonResponse debitOperation(TransactionDto dto);

    CommonResponse creditOperation(TransactionDto dto);

    TransactionDetails saveTransaction(TransactionDto dto, AccountDetails accountDetails, AccountDetails accountDetailsFrom);
}
