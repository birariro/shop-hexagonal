package com.challenge.shop_hexagonal.order.application.port.in;

import java.util.List;

public interface CreateOrderUseCase {
	void create(CreateOrderCommand command);
}
