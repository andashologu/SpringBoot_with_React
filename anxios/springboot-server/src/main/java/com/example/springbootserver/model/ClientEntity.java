package com.example.springbootserver.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "client")
public class ClientEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String email;

    // getter, setters, contructors
}