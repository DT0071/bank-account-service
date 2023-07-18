package com.example.techolution.accountservice.repository;

import com.example.techolution.accountservice.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findByAccountNumberOrAccountName(Long accountNumber, String accountName);
}
