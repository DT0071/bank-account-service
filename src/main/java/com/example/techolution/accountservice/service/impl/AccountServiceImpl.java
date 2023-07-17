package com.example.techolution.accountservice.service.impl;

import com.example.techolution.accountservice.entity.Account;
import com.example.techolution.accountservice.mapper.AccountMapper;
import com.example.techolution.accountservice.payload.AccountDto;
import com.example.techolution.accountservice.repository.AccountRepository;
import com.example.techolution.accountservice.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
