package com.challenge.shop_hexagonal.member.domain;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value(staticConstructor = "of")
public class Name {
	private final String value;
}
