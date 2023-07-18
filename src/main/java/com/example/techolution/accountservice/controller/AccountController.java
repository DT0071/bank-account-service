package com.example.techolution.accountservice.controller;

import com.example.techolution.accountservice.payload.AccountDto;
import com.example.techolution.accountservice.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    @PutMapping("/{accountNumber}")
    public ResponseEntity<AccountDto> updateAccount(@RequestBody AccountDto accountDto, @PathVariable(name = "accountNumber") Long accountNumber) {
        return new ResponseEntity<>(accountService.updateAccount(accountDto, accountNumber), HttpStatus.CREATED);
    }

    @GetMapping
    public List<AccountDto> getAllAccounts(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false ) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false ) int pageSize
    ) {
        return accountService.getAllAccounts(pageNo, pageSize);
    }

    // Search API to query accounts based on account number or account name
    @GetMapping("/search")
    public ResponseEntity<List<AccountDto>> searchAccounts(
            @RequestParam("query") String query
    ) {
        return ResponseEntity.ok(accountService.searchAccounts(query));
    }

}
