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

	public void downStockQuantity(int downCount){

		if(this.stockQuantity - downCount >= 0){
			this.stockQuantity -= downCount;
			return;
		}
		throw new IllegalArgumentException();
	}

	@Value(staticConstructor = "of")
	public static class ItemId{
		private final Long value;
	}
}
