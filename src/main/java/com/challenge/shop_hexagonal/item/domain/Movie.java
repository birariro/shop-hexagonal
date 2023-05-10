package com.challenge.shop_hexagonal.item.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class Movie extends Item {
	private String director;
	private String actor;

	private Movie(ItemId id, String name, ItemType type, int price, int stockQuantity, String director,
		String actor) {
		super(id, name, type, price, stockQuantity);
		this.director = director;
		this.actor = actor;
	}

	public static Movie withId(ItemId id, String name, ItemType type, int price, int stockQuantity, String director,
		String actor) {
		return new Movie(id, name, type, price, stockQuantity, director, actor);
	}
}
