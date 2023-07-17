package com.example.techolution.accountservice.mapper;

import com.example.techolution.accountservice.entity.Account;
import com.example.techolution.accountservice.payload.AccountDto;
import org.mapstruct.Mapper;

@Mapper
public interface AccountMapper {

    AccountDto entityToDto(Account entity);
    Account dtoToEntity(AccountDto dto);
}
