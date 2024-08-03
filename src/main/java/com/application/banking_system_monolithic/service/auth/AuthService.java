package com.application.banking_system_monolithic.service.auth;

import com.application.banking_system_monolithic.dto.CommonResponse;
import com.application.banking_system_monolithic.payload.request.auth.SignUpRequest;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    CommonResponse registerUser(SignUpRequest signupReq);
}
