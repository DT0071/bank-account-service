package com.example.techolution.accountservice.service;

import com.example.techolution.accountservice.payload.AccountDto;

import java.util.List;

public interface AccountService {

    AccountDto createAccount (AccountDto accountDto) ;

    AccountDto updateAccount (AccountDto accountDto, Long accountNumber ) ;

    List<AccountDto> getAllAccounts(int pageNo, int pageSize);

    List<AccountDto> searchAccounts(String query);

}
