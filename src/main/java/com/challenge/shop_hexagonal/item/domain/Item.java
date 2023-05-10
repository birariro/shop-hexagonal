package com.challenge.shop_hexagonal.item.domain;

import lombok.Getter;
import lombok.Value;

@Getter
public abstract class Item {

	private ItemId id;
	private String name;
	private ItemType type;
	private int price;
	private int stockQuantity;

	protected Item(ItemId id, String name, ItemType type, int price, int stockQuantity) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}

	@Value(staticConstructor = "of")
	public static class ItemId{
		private final Long value;
	}
}
