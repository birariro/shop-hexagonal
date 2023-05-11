package com.challenge.shop_hexagonal.order.domain;

import com.challenge.shop_hexagonal.config.event.BaseEvent;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class NewOrderEvent extends BaseEvent {
	private Order order;

	public NewOrderEvent(Order order) {
		this.order = order;
	}
}
