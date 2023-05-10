package com.challenge.shop_hexagonal.order.application.port.in;

import java.util.List;

import com.challenge.shop_hexagonal.order.domain.Order;

public interface LoadOrderUseCase {

	List<Order> orders();
	Order order(Long id);
}
