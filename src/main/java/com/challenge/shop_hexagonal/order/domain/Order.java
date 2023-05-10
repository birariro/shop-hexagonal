package com.challenge.shop_hexagonal.order.domain;

import java.util.List;

import lombok.Getter;
import lombok.Value;

@Getter
public class Order {

	private Order.Id id;
	private Long memberId;
	private Long deliveryId;
	private OrderStatus status;
	private List<OrderLine> orderLines;


	private Order(Id id, Long memberId, Long deliveryId, OrderStatus status,
		List<OrderLine> orderLines) {
		this.id = id;
		this.memberId = memberId;
		this.deliveryId = deliveryId;
		this.status = status;
		this.orderLines = orderLines;
	}

	public static Order withId(Id id, Long memberId, Long deliveryId, OrderStatus status,
		List<OrderLine> orderLines){
		return new Order(id, memberId, deliveryId, status, orderLines);
	}
	public static Order withoutId(Long memberId, Long deliveryId, List<OrderLine> orderLines){
		return new Order(null, memberId, deliveryId, OrderStatus.ORDER, orderLines);
	}

	@Value(staticConstructor = "of")
	public static class Id {
		private final Long value;
	}
}
