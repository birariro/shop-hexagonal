package com.challenge.shop_hexagonal.member.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@Getter
@AllArgsConstructor
public class Member {

	private MemberId id;
	private Name name;
	private Address address;

	public static Member withoutId(Name name, Address address){
		return new Member(null, name, address);
	}
	public static Member withId(MemberId id, Name name, Address address){
		return new Member(id, name, address);
	}

	@Value(staticConstructor = "of")
	public static class MemberId{
		private final Long value;
	}
}
