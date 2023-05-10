package com.challenge.shop_hexagonal.item.domain;

public enum ItemType {
	ALBUM, BOOK, MOVIE;

	public static ItemType columnToItemType(String column){
		if(column.equals("A")) return ItemType.ALBUM;
		if(column.equals("B")) return ItemType.BOOK;
		return ItemType.MOVIE;
	}
}
