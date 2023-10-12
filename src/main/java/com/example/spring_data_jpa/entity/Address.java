package com.example.spring_data_jpa.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String streetName;
    private String city;
    private String country;
    private String POBox;
}
