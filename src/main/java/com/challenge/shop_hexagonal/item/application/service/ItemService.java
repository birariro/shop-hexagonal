package com.challenge.shop_hexagonal.item.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.challenge.shop_hexagonal.item.application.port.in.LoadItemUseCase;
import com.challenge.shop_hexagonal.item.application.port.in.StockQuantityUseCase;
import com.challenge.shop_hexagonal.item.application.port.out.LoadItemPort;
import com.challenge.shop_hexagonal.item.application.port.out.UpdateItemPort;
import com.challenge.shop_hexagonal.item.domain.Item;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
class ItemService implements LoadItemUseCase, StockQuantityUseCase {

	private final LoadItemPort loadItemPort;
	private final UpdateItemPort updateItemPort;
	@Override
	public List<Item> items() {
		return loadItemPort.findAll();
	}

	@Override
	public Item item(Long id) {

		return loadItemPort.findById(Item.ItemId.of(id))
			.orElseThrow(() -> new IllegalArgumentException());
	}

	@Override
	public void down(Long itemId, int count) {

		Item item = loadItemPort.findById(Item.ItemId.of(itemId))
			.orElseThrow(() -> new IllegalArgumentException());

		item.downStockQuantity(count);
		updateItemPort.save(item);
	}
}
