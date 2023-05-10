package com.challenge.shop_hexagonal.item.domain;

import lombok.Getter;

@Getter
public class Book extends Item {
	private String author;
	private String isbn;

	private Book(ItemId id, String name, ItemType type, int price, int stockQuantity, String author, String isbn) {
		super(id, name, type, price, stockQuantity);
		this.author = author;
		this.isbn = isbn;
	}

	public static Book withId(ItemId id, String name, ItemType type, int price, int stockQuantity, String author, String isbn){
		return new Book(id, name, type, price, stockQuantity, author, isbn);
	}
}
