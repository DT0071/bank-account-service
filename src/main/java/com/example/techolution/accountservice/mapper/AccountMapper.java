package com.example.techolution.accountservice.mapper;

import com.example.techolution.accountservice.entity.Account;
import com.example.techolution.accountservice.payload.AccountDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper {

    AccountMapper MAPPER = Mappers.getMapper(AccountMapper.class);

    AccountDto entityToDto(Account entity);
    Account dtoToEntity(AccountDto dto);
}
