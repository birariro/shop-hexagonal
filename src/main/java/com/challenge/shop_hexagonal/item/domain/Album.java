package com.challenge.shop_hexagonal.item.domain;

import lombok.Getter;

@Getter
public class Album extends Item {
	private String artist;
	private String etc;

	private Album(ItemId id, String name, ItemType type, int price, int stockQuantity, String artist, String etc) {
		super(id, name, type, price, stockQuantity);
		this.artist = artist;
		this.etc = etc;
	}

	public static Album withId(ItemId id, String name, ItemType type, int price, int stockQuantity, String artist, String etc){
		return new Album(id, name, type, price, stockQuantity, artist, etc);
	}

}
