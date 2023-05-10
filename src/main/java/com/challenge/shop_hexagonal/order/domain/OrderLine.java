package com.challenge.shop_hexagonal.order.domain;

import lombok.Getter;
import lombok.Value;

@Getter
public class OrderLine {

	private OrderLine.Id id;

	private Long itemId;
	private int count;
	private int price;

	public OrderLine(Id id, Long itemId, int count, int price) {
		this.id = id;
		this.itemId = itemId;
		this.count = count;
		this.price = price;
	}

	public static OrderLine withId(Id id, Long itemId, int count, int price){
		return new OrderLine(id, itemId, count, price);
	}
	public static OrderLine withoutId(Long itemId, int count, int price){
		return new OrderLine(null, itemId, count, price);
	}

	public int getTotalPrice(){
		return count*price;
	}

	@Value(staticConstructor = "of")
	public static class Id {
		private final Long value;
	}
}
