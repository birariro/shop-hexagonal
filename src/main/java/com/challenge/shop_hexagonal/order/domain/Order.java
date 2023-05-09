package com.challenge.shop_hexagonal.order.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

public class Order {

	private Order.Id id;
	private List<OrderLine> orderLines;

	@Getter
	public class Id {
		private  String value;

	}
}
