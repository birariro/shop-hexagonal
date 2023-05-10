package com.challenge.shop_hexagonal.item.adapter.in.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.shop_hexagonal.item.application.port.in.LoadItemUseCase;
import com.challenge.shop_hexagonal.item.domain.Item;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ItemController {
	private final LoadItemUseCase loadItemUseCase;

	@GetMapping("/item")
	public ResponseEntity getItems(){

		List<Item> items = loadItemUseCase.items();
		return ResponseEntity.ok().body(items);
	}
}
