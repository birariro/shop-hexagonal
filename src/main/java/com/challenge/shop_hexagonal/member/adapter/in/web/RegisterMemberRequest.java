package com.challenge.shop_hexagonal.member.adapter.in.web;

import lombok.Getter;

@Getter
public class RegisterMemberRequest {
	private String name;
	private String city;
	private String street;
	private String zipcode;
}
