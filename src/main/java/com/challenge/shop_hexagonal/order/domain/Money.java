package com.challenge.shop_hexagonal.order.domain;

import lombok.Value;

@Value(staticConstructor = "of")
public class Money {

	public static Money ZERO = Money.of(0);

	private final int value;

	public Money multi(int operand){
		return new Money(this.value * operand);
	}
}
