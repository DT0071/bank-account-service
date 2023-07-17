package com.example.techolution.accountservice.payload;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
public class AccountDto {

    private Long accountNumber;
    private String accountName;
    private String email;
    private String telephone;
    private String gender;
    private int age;
    private Date dob;
    private String Address;
}