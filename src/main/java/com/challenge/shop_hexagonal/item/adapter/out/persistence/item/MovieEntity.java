package com.challenge.shop_hexagonal.item.adapter.out.persistence.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.challenge.shop_hexagonal.item.adapter.out.persistence.ItemEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("M")
@Getter
@Setter
public class MovieEntity extends ItemEntity {
    private String director;
    private String actor;
}