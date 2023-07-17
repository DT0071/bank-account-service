package com.example.techolution.accountservice.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Getter
public class AccountNotFoundException extends RuntimeException{
    private String accountName;
    private String fieldName;
    private String fieldValue;

    public AccountNotFoundException(String accountName, String fieldName, String fieldValue) {
        super(String.format("%s not found with %s : %s",accountName,fieldName,fieldValue));
        this.accountName = accountName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

}
