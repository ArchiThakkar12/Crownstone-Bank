package com.crownstonebank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Card {
    @Id
    private String cardId;
    private String cardNumber;
    private String cardHolderName;
    private String billiingAddress;
    private String balance;
    private int cvv;
    private int pin;
    private LocalDateTime issuedAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
