package com.application.banking_system_monolithic.repo.account;

import com.application.banking_system_monolithic.entity.account.AccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<AccountDetails, Long> {
}
