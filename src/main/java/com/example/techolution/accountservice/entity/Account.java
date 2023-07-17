package com.example.techolution.accountservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Entity
@Table(name = "accounts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountNumber;

    @Column(name = "accountName", nullable = false)
    private String accountName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "telephone", nullable = false)
    private String telephone;
    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "dob", nullable = false)
    private String dob;

    @Column(name = "address", nullable = false)
    private String Address;

}
