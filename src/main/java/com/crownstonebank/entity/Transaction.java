package com.crownstonebank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Transaction {
    @Id
    private String transactionId;
    private String transactionFee;
    private String description;
    private String sender;
    private String receiver;
    private String status;
    private String transactionType;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
