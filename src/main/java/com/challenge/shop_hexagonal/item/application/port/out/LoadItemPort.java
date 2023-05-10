package com.challenge.shop_hexagonal.item.application.port.out;

import java.util.List;

import com.challenge.shop_hexagonal.item.domain.Item;

public interface LoadItemPort {
	List<Item> findAll();
}
