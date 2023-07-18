package com.example.techolution.accountservice.service;

import com.example.techolution.accountservice.entity.Account;
import com.example.techolution.accountservice.exception.AccountNotFoundException;
import com.example.techolution.accountservice.payload.AccountDto;
import com.example.techolution.accountservice.repository.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTests {

    @Autowired
    private AccountService accountService;

    @MockBean
    private AccountRepository accountRepository;

    @MockBean
    private Page page;

    @MockBean
    private Page<Account> accountPage;

    @Test
    public void createAccount() {
        Account account = new Account();
        account.setAccountNumber(35656546767L);
        account.setAccountName("Divyansh");
        account.setDob("23-09-98");
        account.setAge(25);
        account.setEmail("test@gmail.com");
        account.setGender("male");
        account.setTelephone("995510928");

        AccountDto accountDto = new AccountDto();
        accountDto.setAccountNumber(35656546767L);
        accountDto.setAccountName("Divyansh");
        accountDto.setDob("23-09-98");
        accountDto.setAge(25);
        accountDto.setEmail("test@gmail.com");
        accountDto.setGender("male");
        accountDto.setTelephone("995510928");

        Mockito.when(accountRepository.save(account)).thenReturn(account);
        assert(accountService.createAccount(accountDto)).equals(accountDto);
    }

    @Test
    public void updateAccount() {
        Account account = new Account();
        account.setAccountNumber(35656546767L);
        account.setAccountName("Divyansh");
        account.setDob("23-09-98");
        account.setAge(25);
        account.setEmail("test@gmail.com");
        account.setGender("male");
        account.setTelephone("995510928");

        AccountDto accountDto = new AccountDto();
        accountDto.setAccountNumber(35656546767L);
        accountDto.setAccountName("Divyansh");
        accountDto.setDob("23-09-98");
        accountDto.setAge(25);
        accountDto.setEmail("test@gmail.com");
        accountDto.setGender("male");
        accountDto.setTelephone("995510928");

        Mockito.when(accountRepository.save(account)).thenReturn(account);
        assertThrows(AccountNotFoundException.class,
                ()->{
                    accountService.updateAccount(accountDto,1L);
                });
    }


    @Test
    public void searchAccounts() {
        Account account = new Account();
        account.setAccountNumber(35656546767L);
        account.setAccountName("Divyansh");
        account.setDob("23-09-98");
        account.setAge(25);
        account.setEmail("test@gmail.com");
        account.setGender("male");
        account.setTelephone("995510928");

        AccountDto accountDto = new AccountDto();
        accountDto.setAccountNumber(35656546767L);
        accountDto.setAccountName("Divyansh");
        accountDto.setDob("23-09-98");
        accountDto.setAge(25);
        accountDto.setEmail("test@gmail.com");
        accountDto.setGender("male");
        accountDto.setTelephone("995510928");

        Pageable pageable = PageRequest.of(0, 1);
        //Mockito.when(accountRepository.findAll()).thenReturn((pageable));
        accountService.searchAccounts("Divyansh");

    }


}
