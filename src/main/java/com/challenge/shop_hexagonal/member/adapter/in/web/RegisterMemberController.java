package com.challenge.shop_hexagonal.member.adapter.in.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.shop_hexagonal.member.application.port.in.RegisterMemberCommand;
import com.challenge.shop_hexagonal.member.application.port.in.RegisterMemberUseCase;
import com.challenge.shop_hexagonal.member.domain.Address;
import com.challenge.shop_hexagonal.member.domain.Name;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RegisterMemberController {

	private final RegisterMemberUseCase registerMemberUseCase;
	@PostMapping("/member")
	public ResponseEntity registerMember(@RequestBody RegisterMemberRequest request){

		RegisterMemberCommand registerMemberCommand = new RegisterMemberCommand(
			Name.of(request.getName()),
			Address.of(
				request.getCity(),
				request.getStreet(),
				request.getZipcode()
			));

		registerMemberUseCase.register(registerMemberCommand);

		return ResponseEntity.ok().build();
	}
}
