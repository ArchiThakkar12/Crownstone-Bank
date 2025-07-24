package com.crownstonebank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Account {
    @Id
    private String accountId;
    private String accountNumber;
    private String accountHolderName;
    private String symbol;
    private String code;
    private String balance;
    private String label;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
