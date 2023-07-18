package com.example.techolution.accountservice.exception;

import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Data
public class AccountNotFoundException extends RuntimeException{
    private String accountName;
    private String fieldName;
    private Long fieldValue;

    public AccountNotFoundException(String accountName, String fieldName, Long fieldValue) {
        super(String.format("%s not found with %s : %s",accountName,fieldName,fieldValue));
        this.accountName = accountName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

}
