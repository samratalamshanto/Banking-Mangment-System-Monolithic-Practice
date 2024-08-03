package com.application.banking_system_monolithic.service.user;

import com.application.banking_system_monolithic.dto.CommonResponse;
import com.application.banking_system_monolithic.entity.user.User;
import com.application.banking_system_monolithic.payload.request.auth.LoginRequest;
import com.application.banking_system_monolithic.payload.request.auth.SignUpRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User createUser(SignUpRequest signupReq);
    CommonResponse loginUser(LoginRequest loginRequest);
}
