package com.application.banking_system_monolithic.service.account;

import com.application.banking_system_monolithic.dto.CommonResponse;
import com.application.banking_system_monolithic.dto.TransactionDto;
import com.application.banking_system_monolithic.entity.account.AccountDetails;
import com.application.banking_system_monolithic.entity.transaction.TransactionDetails;
import com.application.banking_system_monolithic.entity.user.User;
import com.application.banking_system_monolithic.enums.transaction.TransactionType;
import com.application.banking_system_monolithic.repo.account.AccountRepo;
import com.application.banking_system_monolithic.repo.transaction.TransactionRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {
    private final AccountRepo accountRepo;
    private final TransactionRepo transactionRepo;
    @Autowired
    @Lazy
    AccountService accountService;

    @Override
    public void createAccount(User user) {
        try {
            AccountDetails accountDetails = new AccountDetails();
            accountDetails.setAccountHolder(user);
            accountDetails.setBalance(0.0);
            accountDetails.setAccountNumber(getAccountNumber(user));
            accountRepo.save(accountDetails);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ)
    public CommonResponse debitOperation(TransactionDto dto) {
        CommonResponse response = new CommonResponse(400, false, "Data not found.", null);
        if (!ObjectUtils.isEmpty(dto.getAccountNumberTo()) && !ObjectUtils.isEmpty(dto.getAccountNumberFrom())) {
            Optional<AccountDetails> accountDetailsTo = accountRepo.findByAccountNumber(dto.getAccountNumberTo());
            Optional<AccountDetails> accountDetailsFrom = accountRepo.findByAccountNumber(dto.getAccountNumberFrom());
            List<AccountDetails> list = new ArrayList<>();
            if (accountDetailsTo.isPresent() && accountDetailsFrom.isPresent()) {
                if (accountDetailsFrom.get().getBalance() >= dto.getAmount()) {
                    accountDetailsTo.get().setBalance(accountDetailsTo.get().getBalance() + dto.getAmount());
                    accountDetailsFrom.get().setBalance(accountDetailsFrom.get().getBalance() - dto.getAmount());
                    list.add(accountDetailsFrom.get());
                    list.add(accountDetailsTo.get());
                    accountRepo.saveAll(list);
                    accountService.saveTransaction(dto, accountDetailsTo.get(), accountDetailsFrom.get());
                    return new CommonResponse(200, true, "Successfully Debited", null);
                } else {
                    response.setMessage("Insufficient Balance");
                }
            } else {
                response.setMessage("Invalid Accounts");
            }
        }
        return response;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ)
    public CommonResponse creditOperation(TransactionDto dto) {
        CommonResponse response = new CommonResponse(400, false, "Data not found.", null);

        if (!ObjectUtils.isEmpty(dto.getAccountNumberTo())) {
            Optional<AccountDetails> accountDetails = accountRepo.findByAccountNumber(dto.getAccountNumberTo());
            if (accountDetails.isPresent()) {
                accountDetails.get().setBalance(accountDetails.get().getBalance() + dto.getAmount());
                accountRepo.save(accountDetails.get());
                accountService.saveTransaction(dto, accountDetails.get(), null);
                return new CommonResponse(200, true, "Successfully Credited", null);
            }
        } else {
            response.setMessage("Account Number Not Found");
        }
        return response;
    }


    public TransactionDetails saveTransaction(TransactionDto dto, AccountDetails accountDetailsTo, AccountDetails accountDetailsFrom) {
        TransactionDetails transactionDetails = new TransactionDetails();
        transactionDetails.setTransactionNumber(getTransactionNumber());
        transactionDetails.setTransactionType(TransactionType.getValue(dto.getTransactionType()));
        transactionDetails.setTransactionAmount(dto.getAmount());
        transactionDetails.setTransactionToAccount(accountDetailsTo);
        if (!ObjectUtils.isEmpty(accountDetailsFrom)) {
            transactionDetails.setTransactionFromAccount(accountDetailsFrom);
        }
        transactionDetails = transactionRepo.save(transactionDetails);
        return transactionDetails;
    }

    private String getTransactionNumber() {
        String txNum = "T";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        txNum = txNum + LocalDateTime.now().format(formatter);
        return txNum;
    }

    private String getAccountNumber(User user) {
        String accountNumber = "A-0000000000";
        String userId = user.getId().toString();
        int userIdLen = userId.length(), fullLen = accountNumber.length();
        accountNumber = new String(accountNumber.substring(0, fullLen - userIdLen) + userId);
        return accountNumber;
    }
}
