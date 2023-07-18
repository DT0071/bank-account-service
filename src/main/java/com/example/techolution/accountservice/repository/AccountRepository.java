package com.example.techolution.accountservice.repository;

import com.example.techolution.accountservice.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("SELECT p FROM Account p WHERE " +
            "p.accountNumber LIKE CONCAT('%',:query, '%')" +
            "Or p.accountName LIKE CONCAT('%', :query, '%')")
    List<Account> searchAccounts(String query);
}
