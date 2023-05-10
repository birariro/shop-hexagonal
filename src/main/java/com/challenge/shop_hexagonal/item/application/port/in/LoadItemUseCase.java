package com.challenge.shop_hexagonal.item.application.port.in;

import java.util.List;

import com.challenge.shop_hexagonal.item.domain.Item;

public interface LoadItemUseCase {

	List<Item> items();
	Item item(Long id);
}
