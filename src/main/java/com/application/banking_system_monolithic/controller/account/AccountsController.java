package com.application.banking_system_monolithic.controller.account;

import com.application.banking_system_monolithic.dto.CommonResponse;
import com.application.banking_system_monolithic.dto.TransactionDto;
import com.application.banking_system_monolithic.repo.transaction.TransactionRepo;
import com.application.banking_system_monolithic.service.account.AccountService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/account")
@RequiredArgsConstructor
public class AccountsController {
    private final AccountService accountService;
    private final TransactionRepo transactionRepo;

    @PostMapping("/debit")
    public CommonResponse debitAccount(@RequestBody TransactionDto dto, HttpServletRequest request) {
        return accountService.debitOperation(dto, request);
    }

    @PostMapping("/credit")
    public CommonResponse creditAccount(@RequestBody TransactionDto dto, HttpServletRequest request) {
        return accountService.creditOperation(dto, request);
    }


    @GetMapping("/get-all-transactions")
    public CommonResponse creditAccount(@RequestParam("accountNumber") String accountNumber, HttpServletRequest request) {
        return accountService.getTransactionDetails(accountNumber, request);
    }

    @GetMapping("/get-all-transactions-summary")
    public List<?> transactionSummary() {
        return transactionRepo.getDemo().stream().toList();
    }
}
