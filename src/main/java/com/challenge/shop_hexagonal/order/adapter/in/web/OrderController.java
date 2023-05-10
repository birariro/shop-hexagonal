package com.challenge.shop_hexagonal.order.adapter.in.web;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.shop_hexagonal.order.application.port.in.CreateOrderCommand;
import com.challenge.shop_hexagonal.order.application.port.in.CreateOrderUseCase;
import com.challenge.shop_hexagonal.order.application.port.in.LoadOrderUseCase;
import com.challenge.shop_hexagonal.order.domain.Order;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OrderController {

	private final LoadOrderUseCase loadOrderUseCase;
	private final CreateOrderUseCase createOrderUseCase;

	@PostMapping("/order")
	public ResponseEntity order(@RequestBody OrderRequest orderRequest){

		Map<Long, Integer> collect = orderRequest.getOrders().stream()
			.collect(Collectors.toMap(OrderRequest.ItemWithCount::getItemId, OrderRequest.ItemWithCount::getCount));

		CreateOrderCommand createOrderCommand = new CreateOrderCommand(orderRequest.getMemberId(), collect);
		createOrderUseCase.create(createOrderCommand);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/order")
	public ResponseEntity findAllOrder(){

		List<Order> orders = loadOrderUseCase.orders();
		return ResponseEntity.ok().body(orders);
	}

	@GetMapping("/order/{id}")
	public ResponseEntity findOrder(@PathVariable("id") Long id){

		Order order = loadOrderUseCase.order(id);
		return ResponseEntity.ok().body(order);
	}
}
