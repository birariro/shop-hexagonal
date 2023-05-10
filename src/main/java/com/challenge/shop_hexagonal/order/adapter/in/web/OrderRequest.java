package com.challenge.shop_hexagonal.order.adapter.in.web;

import java.util.List;

import lombok.Getter;

@Getter
public class OrderRequest {
	private Long memberId;
	private List<ItemWithCount> orders;

	@Getter
	public static class ItemWithCount{
		private Long itemId;
		private int count;
	}
}

