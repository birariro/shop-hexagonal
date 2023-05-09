package com.challenge.shop_hexagonal.delivery.adapter.out.persistence;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
class Address {
    private String city;
    private String street;
    private String zipcode;
}