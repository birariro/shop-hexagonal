package com.challenge.shop_hexagonal.item.application.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.challenge.shop_hexagonal.item.application.port.out.LoadItemPort;
import com.challenge.shop_hexagonal.item.application.port.out.UpdateItemPort;
import com.challenge.shop_hexagonal.item.domain.Item;
import com.challenge.shop_hexagonal.order.domain.NewOrderEvent;
import com.challenge.shop_hexagonal.order.domain.OrderLine;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
class StockQuantityService {

	private final LoadItemPort loadItemPort;
	private final UpdateItemPort updateItemPort;

	@EventListener(NewOrderEvent.class)
	public void downStockQuantity(NewOrderEvent newOrderEvent){
		List<OrderLine> orderLines = newOrderEvent.getOrder().getOrderLines();

		orderLines.stream().collect(Collectors.toMap(OrderLine::getItemId, OrderLine::getCount))
			.entrySet().forEach(
				entry -> {
					Item item = loadItemPort.findById(Item.ItemId.of(entry.getKey()))
						.orElseThrow(() -> new IllegalArgumentException());
					item.downStockQuantity(entry.getValue());
				}
			);
	}
}
