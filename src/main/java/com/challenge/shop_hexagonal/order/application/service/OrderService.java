package com.challenge.shop_hexagonal.order.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.challenge.shop_hexagonal.order.application.port.in.LoadOrderUseCase;
import com.challenge.shop_hexagonal.order.application.port.out.LoadOrderPort;
import com.challenge.shop_hexagonal.order.application.port.out.UpdateOrderPort;
import com.challenge.shop_hexagonal.order.domain.Order;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
class OrderService implements LoadOrderUseCase {

	private final LoadOrderPort loadOrderPort;
	private final UpdateOrderPort updateOrderPort;

	@Override
	public List<Order> orders() {
		return loadOrderPort.orders();
	}

	@Override
	public Order order(Long id) {
		return loadOrderPort.order(Order.Id.of(id))
			.orElseThrow(() -> new IllegalArgumentException());
	}
}
