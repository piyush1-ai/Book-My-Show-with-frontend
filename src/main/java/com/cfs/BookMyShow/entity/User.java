package com.cfs.BookMyShow.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "users")
@Getter // getter and setters are automatically generated
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder // allows you to create objects in a readable, flexible way, especially when dealing with classes that have many fields
public class User {

    @Id // primaryKey
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // For  autoIncrement of ID
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String phone;

    private LocalDateTime createdAt;

    @PrePersist //It marks a method in your entity class to be executed before the entity is persisted (inserted) into the database.
    //    This is especially useful when you want to initialize default values or set timestamps automatically before saving a new record.
    protected void onCreate(){
        this.createdAt = LocalDateTime.now();
    }



}
