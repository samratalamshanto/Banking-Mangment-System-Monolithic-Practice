package com.application.banking_system_monolithic.repo.transaction;

import com.application.banking_system_monolithic.entity.transaction.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepo extends JpaRepository<TransactionDetails, Long> {
    List<TransactionDetails> findAllByAccountNumberOrderByCreatedDTDesc(String accountNumber);
}
