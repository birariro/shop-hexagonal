package com.challenge.shop_hexagonal.item.adapter.out.persistence.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.challenge.shop_hexagonal.item.adapter.out.persistence.ItemEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("A")
@Getter
@Setter
public class AlbumEntity extends ItemEntity {

    private String artist;
    private String etc;
}