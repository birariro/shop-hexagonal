package com.challenge.shop_hexagonal.item.adapter.out.persistence;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.challenge.shop_hexagonal.item.domain.Album;
import com.challenge.shop_hexagonal.item.domain.Book;
import com.challenge.shop_hexagonal.item.domain.Item;
import com.challenge.shop_hexagonal.item.domain.ItemType;
import com.challenge.shop_hexagonal.item.domain.Movie;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tb_item")
public class ItemEntity {
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;

    @Column(name = "dtype", nullable = false)
    private String dtype;

    private int price;
    private int stockQuantity;
    private String artist;
    private String etc;
    private String author;
    private String isbn;
    private String director;
    private String actor;


    public Item toDomain(){

        if(this.dtype == "A"){
            return Album.withId(Item.ItemId.of(this.id), this.name, ItemType.columnToItemType(this.dtype), this.price, this.stockQuantity, this.artist, this.etc);
        }
        if(this.dtype == "B"){
            return Book.withId(Item.ItemId.of(this.id), this.name, ItemType.columnToItemType(this.dtype), this.price, this.stockQuantity, this.author, this.isbn);
        }

        return Movie.withId(Item.ItemId.of(this.id), this.name, ItemType.columnToItemType(this.dtype), this.price, this.stockQuantity, this.director, this.actor);
    }
}