package com.challenge.shop_hexagonal.item.adapter.out.persistence;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.challenge.shop_hexagonal.common.PersistenceAdapter;
import com.challenge.shop_hexagonal.item.application.port.out.LoadItemPort;
import com.challenge.shop_hexagonal.item.application.port.out.UpdateItemPort;
import com.challenge.shop_hexagonal.item.domain.Item;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
class ItemPersistenceAdapter implements LoadItemPort, UpdateItemPort {

	private final ItemEntityRepository itemEntityRepository;
	@Override
	public List<Item> findAll() {
		return itemEntityRepository.findAll().stream().map(ItemEntity::toDomain)
			.collect(Collectors.toList());
	}

	@Override
	public Optional<Item> findById(Item.ItemId id) {
		return itemEntityRepository.findById(id.getValue())
			.map(ItemEntity::toDomain);
	}

	@Override
	public void save(Item item) {
		ItemEntity itemEntity = ItemEntity.toEntity(item);
		itemEntityRepository.save(itemEntity);
	}
}
