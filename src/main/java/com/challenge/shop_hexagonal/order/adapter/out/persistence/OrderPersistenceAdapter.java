package com.challenge.shop_hexagonal.order.adapter.out.persistence;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.challenge.shop_hexagonal.common.PersistenceAdapter;
import com.challenge.shop_hexagonal.order.application.port.out.LoadOrderPort;
import com.challenge.shop_hexagonal.order.application.port.out.UpdateOrderPort;
import com.challenge.shop_hexagonal.order.domain.Order;

import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class OrderPersistenceAdapter implements LoadOrderPort, UpdateOrderPort {

	private final OrderEntityRepository orderEntityRepository;

	@Override
	public List<Order> orders() {
		return orderEntityRepository.findAll()
			.stream()
			.map(OrderEntity::toDomain)
			.collect(Collectors.toList());
	}

	@Override
	public Optional<Order> order(Order.Id id) {
		return orderEntityRepository.findById(id.getValue())
			.map(OrderEntity::toDomain);
	}
}
