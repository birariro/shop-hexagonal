package com.challenge.shop_hexagonal.order.application.port.out;

import com.challenge.shop_hexagonal.order.domain.Order;

public interface UpdateOrderPort {
	void createOrder(Order order);
}
