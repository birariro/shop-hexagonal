package com.challenge.shop_hexagonal.item.adapter.in.listener;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.challenge.shop_hexagonal.item.application.port.in.StockQuantityUseCase;
import com.challenge.shop_hexagonal.order.domain.NewOrderEvent;
import com.challenge.shop_hexagonal.order.domain.OrderLine;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ItemListener {

	private final StockQuantityUseCase stockQuantityUseCase;

	@EventListener(NewOrderEvent.class)
	public void downStockQuantity(NewOrderEvent newOrderEvent){

		List<OrderLine> orderLines = newOrderEvent.getOrder().getOrderLines();

		orderLines.stream().collect(Collectors.toMap(OrderLine::getItemId, OrderLine::getCount))
			.entrySet().forEach(
				entry -> {
					stockQuantityUseCase.down(entry.getKey(), entry.getValue());

				}
			);
	}
}
