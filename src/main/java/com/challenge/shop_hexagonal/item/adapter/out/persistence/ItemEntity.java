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

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tb_item")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    public ItemEntity(Long id, String name, String dtype, int price, int stockQuantity, String artist, String etc,
        String author, String isbn, String director, String actor) {
        this.id = id;
        this.name = name;
        this.dtype = dtype;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.artist = artist;
        this.etc = etc;
        this.author = author;
        this.isbn = isbn;
        this.director = director;
        this.actor = actor;
    }

    public Item toDomain(){

        if(this.dtype == "A"){
            return Album.withId(Item.ItemId.of(this.id), this.name, ItemType.columnToItemType(this.dtype), this.price, this.stockQuantity, this.artist, this.etc);
        }
        if(this.dtype == "B"){
            return Book.withId(Item.ItemId.of(this.id), this.name, ItemType.columnToItemType(this.dtype), this.price, this.stockQuantity, this.author, this.isbn);
        }

        return Movie.withId(Item.ItemId.of(this.id), this.name, ItemType.columnToItemType(this.dtype), this.price, this.stockQuantity, this.director, this.actor);
    }

    public static ItemEntity toEntity(Item item){

        if(item.getType() == ItemType.ALBUM){
            Album album = (Album)item;
            return new ItemEntity(
                album.getId() == null ? null : album.getId().getValue(),
                album.getName(),
                album.getType().toString(),
                album.getPrice(),
                album.getStockQuantity(),
                album.getArtist(),
                album.getEtc(),null,null,null,null
            );
        }
        if(item.getType() == ItemType.BOOK){

            Book book = (Book)item;
            return new ItemEntity(
                book.getId() == null ? null : book.getId().getValue(),
                book.getName(),
                book.getType().toString(),
                book.getPrice(),
                book.getStockQuantity(),
                null,
                null,
                book.getAuthor(),
                book.getIsbn(),null,null
            );
        }

        Movie movie = (Movie)item;
        return new ItemEntity(
            movie.getId() == null ? null : movie.getId().getValue(),
            movie.getName(),
            movie.getType().toString(),
            movie.getPrice(),
            movie.getStockQuantity(),
            null,
            null,
            null,
            null,
            movie.getDirector(),
            movie.getActor()
        );
    }
}