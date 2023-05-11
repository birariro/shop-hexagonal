package com.challenge.shop_hexagonal.item.application.port.out;

import com.challenge.shop_hexagonal.item.domain.Item;

public interface UpdateItemPort {

	void save(Item item);
}
