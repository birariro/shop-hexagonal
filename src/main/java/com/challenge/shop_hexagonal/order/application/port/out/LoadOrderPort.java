package com.challenge.shop_hexagonal.order.application.port.out;

import java.util.List;
import java.util.Optional;

import com.challenge.shop_hexagonal.order.domain.Order;

public interface LoadOrderPort {
	List<Order> findAll();
	Optional<Order> findById(Order.Id id);
}
