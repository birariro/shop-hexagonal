package com.challenge.shop_hexagonal.item.application.port.out;

import java.util.List;
import java.util.Optional;

import com.challenge.shop_hexagonal.item.domain.Item;

public interface LoadItemPort {
	List<Item> findAll();
	Optional<Item> findById(Item.ItemId id);
}
