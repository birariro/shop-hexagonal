package com.challenge.shop_hexagonal.item.application.port.in;

public interface StockQuantityUseCase {

	void down(Long itemId, int count);
}
