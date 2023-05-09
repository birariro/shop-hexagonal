package com.challenge.shop_hexagonal.item.adapter.out.persistence.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.challenge.shop_hexagonal.item.adapter.out.persistence.ItemEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("B")
@Getter
@Setter
public class BookEntity extends ItemEntity {
    private String author;
    private String isbn;
}