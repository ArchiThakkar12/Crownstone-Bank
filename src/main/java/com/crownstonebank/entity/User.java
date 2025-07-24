package com.crownstonebank.entity;

import com.crownstonebank.dto.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userId;

    private String firstName;
    private String lastName;

    private String email;
    private String password;
    private long phoneNumber;
    private String tag;
    private Gender gender;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Date dob;

    @ManyToMany
    private List<String> roles;

}
