package com.challenge.shop_hexagonal.member.application.port.in;

import javax.validation.constraints.NotNull;

import com.challenge.shop_hexagonal.common.SelfValidating;
import com.challenge.shop_hexagonal.member.domain.Address;
import com.challenge.shop_hexagonal.member.domain.Name;

import lombok.Value;

@Value
public class RegisterMemberCommand extends SelfValidating<RegisterMemberCommand> {

	@NotNull
	private final Name name;

	@NotNull
	private final Address address;

	public RegisterMemberCommand(Name name, Address address) {
		this.name = name;
		this.address = address;
		this.validateSelf();
	}
}
