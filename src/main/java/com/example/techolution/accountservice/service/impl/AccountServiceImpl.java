package com.example.techolution.accountservice.service.impl;

import com.example.techolution.accountservice.entity.Account;
import com.example.techolution.accountservice.exception.AccountNotFoundException;
import com.example.techolution.accountservice.mapper.AccountMapper;
import com.example.techolution.accountservice.payload.AccountDto;
import com.example.techolution.accountservice.repository.AccountRepository;
import com.example.techolution.accountservice.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;


    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.MAPPER.dtoToEntity(accountDto);
        return AccountMapper.MAPPER.entityToDto(accountRepository.save(account));
    }

    @Override
    public AccountDto updateAccount(AccountDto accountDto, Long accountNumber) {
        Account account = accountRepository.findById(accountNumber).orElseThrow(()-> new AccountNotFoundException("Account","Account Number",accountNumber));
        accountDto.setAccountNumber(accountNumber);
        return AccountMapper.MAPPER.entityToDto(accountRepository.save(AccountMapper.MAPPER.dtoToEntity(accountDto)));
    }

    @Override
    public List<AccountDto> getAllAccounts(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Account> accountPage = accountRepository.findAll(pageable);
        List<Account> accountList = accountPage.getContent();
        return accountList.stream().map(AccountMapper.MAPPER::entityToDto).collect(Collectors.toList());
    }

    @Override
    public List<AccountDto> searchAccounts(String query) {
        List<Account> accountList = accountRepository.searchAccounts(query);
        return accountList.stream().map(AccountMapper.MAPPER::entityToDto).collect(Collectors.toList());
    }

}
