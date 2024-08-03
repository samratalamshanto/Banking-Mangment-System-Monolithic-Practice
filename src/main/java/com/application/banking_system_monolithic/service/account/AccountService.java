package com.application.banking_system_monolithic.service.account;

import com.application.banking_system_monolithic.entity.user.User;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {
    void createAccount(User user);
}
