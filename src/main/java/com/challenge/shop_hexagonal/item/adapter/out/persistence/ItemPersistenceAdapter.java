package com.challenge.shop_hexagonal.item.adapter.out.persistence;

import java.util.List;
import java.util.stream.Collectors;

import com.challenge.shop_hexagonal.common.PersistenceAdapter;
import com.challenge.shop_hexagonal.item.application.port.out.LoadItemPort;
import com.challenge.shop_hexagonal.item.domain.Item;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class ItemPersistenceAdapter implements LoadItemPort {

	private final ItemEntityRepository itemEntityRepository;
	@Override
	public List<Item> findAll() {
		return itemEntityRepository.findAll().stream().map(ItemEntity::toDomain)
			.collect(Collectors.toList());
	}
}
