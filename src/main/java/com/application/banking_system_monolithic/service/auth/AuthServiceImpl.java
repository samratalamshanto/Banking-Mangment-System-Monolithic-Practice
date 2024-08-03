package com.application.banking_system_monolithic.service.auth;

import com.application.banking_system_monolithic.dto.CommonResponse;
import com.application.banking_system_monolithic.entity.user.User;
import com.application.banking_system_monolithic.payload.request.auth.SignUpRequest;
import com.application.banking_system_monolithic.service.account.AccountService;
import com.application.banking_system_monolithic.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserService userService;
    private final AccountService accountService;

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public CommonResponse registerUser(SignUpRequest signupReq) {
        User user = userService.createUser(signupReq);
        accountService.createAccount(user);
        CommonResponse commonResponse = new CommonResponse(200, true, "Successfully Registered.", user);
        return commonResponse;
    }
}
