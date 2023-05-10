package com.challenge.shop_hexagonal.delivery.domain;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

class Address {
    private String city;
    private String street;
    private String zipcode;
}