package com.challenge.shop_hexagonal.item.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.challenge.shop_hexagonal.item.application.port.in.LoadItemUseCase;
import com.challenge.shop_hexagonal.item.application.port.out.LoadItemPort;
import com.challenge.shop_hexagonal.item.domain.Item;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
class ItemService implements LoadItemUseCase {

	private final LoadItemPort loadItemPort;
	@Override
	public List<Item> items() {
		return loadItemPort.findAll();
	}

	@Override
	public Item item(Long id) {
		return loadItemPort.findById(Item.ItemId.of(id))
			.orElseThrow(() -> new IllegalArgumentException());
	}
}
