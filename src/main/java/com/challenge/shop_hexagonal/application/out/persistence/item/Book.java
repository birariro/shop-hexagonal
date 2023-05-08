package com.challenge.shop_hexagonal.application.out.persistence.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.challenge.shop_hexagonal.application.out.persistence.Item;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("B")
@Getter
@Setter
public class Book extends Item {
    private String author;
    private String isbn;
}