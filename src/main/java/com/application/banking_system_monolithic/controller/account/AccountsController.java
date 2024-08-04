package com.application.banking_system_monolithic.controller.account;

import com.application.banking_system_monolithic.dto.CommonResponse;
import com.application.banking_system_monolithic.dto.TransactionDto;
import com.application.banking_system_monolithic.service.account.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/account")
@RequiredArgsConstructor
public class AccountsController {
    private final AccountService accountService;

    @PostMapping("/debit")
    public CommonResponse debitAccount(@RequestBody TransactionDto dto) {
        return accountService.debitOperation(dto);
    }

    @PostMapping("/credit")
    public CommonResponse creditAccount(@RequestBody TransactionDto dto) {
        return accountService.creditOperation(dto);
    }
}
