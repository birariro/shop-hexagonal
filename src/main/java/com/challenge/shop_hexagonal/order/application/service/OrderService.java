package com.challenge.shop_hexagonal.order.application.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.challenge.shop_hexagonal.item.application.port.in.LoadItemUseCase;
import com.challenge.shop_hexagonal.order.application.port.in.CreateOrderCommand;
import com.challenge.shop_hexagonal.order.application.port.in.CreateOrderUseCase;
import com.challenge.shop_hexagonal.order.application.port.in.LoadOrderUseCase;
import com.challenge.shop_hexagonal.order.application.port.out.LoadOrderPort;
import com.challenge.shop_hexagonal.order.application.port.out.UpdateOrderPort;
import com.challenge.shop_hexagonal.order.domain.Order;
import com.challenge.shop_hexagonal.order.domain.OrderLine;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
class OrderService implements LoadOrderUseCase, CreateOrderUseCase {

	private final LoadItemUseCase loadItemUseCase;
	private final LoadOrderPort loadOrderPort;
	private final UpdateOrderPort updateOrderPort;

	@Override
	public List<Order> orders() {
		return loadOrderPort.findAll();
	}


	@Override
	public Order order(Long id) {
		return loadOrderPort.findById(Order.Id.of(id))
			.orElseThrow(() -> new IllegalArgumentException());
	}

	@Override
	public void create(CreateOrderCommand command) {

		List<OrderLine> orderLines = command.getItemWithCount().entrySet()
			.stream()
			.map(entry -> OrderLine.withoutId(
				entry.getKey(),
				entry.getValue(),
				loadItemUseCase.item(entry.getKey()).getPrice()))
			.collect(Collectors.toList());

		Order order = Order.withoutId(command.getMemberId(), null, orderLines);
		updateOrderPort.createOrder(order);

	}
}
