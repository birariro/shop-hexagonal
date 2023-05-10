package com.challenge.shop_hexagonal.order.application.port.in;

import java.util.Map;

import javax.validation.constraints.NotNull;

import com.challenge.shop_hexagonal.common.SelfValidating;

import lombok.Value;

@Value
public class CreateOrderCommand extends SelfValidating<CreateOrderCommand> {

	@NotNull
	private final Long memberId;

	@NotNull
	private final Map<Long, Integer> itemWithCount;

	public CreateOrderCommand(Long memberId, Map<Long, Integer> itemWithCount) {
		this.memberId = memberId;
		this.itemWithCount = itemWithCount;
		this.validateSelf();
	}
}
