package com.challenge.shop_hexagonal.member.domain;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Value(staticConstructor = "of")
public class Address {
    private String city;
    private String street;
    private String zipcode;
}