package com.example.techolution.accountservice.payload;

import lombok.Data;

@Data
public class AccountDto {

    private Long accountNumber;
    private String accountName;
    private String email;
    private String telephone;
    private String gender;
    private int age;
    private String dob;
    private String Address;
}
