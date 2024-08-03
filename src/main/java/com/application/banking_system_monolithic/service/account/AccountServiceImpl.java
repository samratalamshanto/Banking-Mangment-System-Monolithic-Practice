package com.application.banking_system_monolithic.service.account;

import com.application.banking_system_monolithic.entity.account.AccountDetails;
import com.application.banking_system_monolithic.entity.user.User;
import com.application.banking_system_monolithic.repo.account.AccountRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {
    private final AccountRepo accountRepo;

    @Override
    public void createAccount(User user) {
        try {
            AccountDetails accountDetails = new AccountDetails();
            accountDetails.setAccountHolder(user);
            accountDetails.setBalance(0.0);
            accountRepo.save(accountDetails);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
