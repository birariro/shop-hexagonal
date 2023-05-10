package com.challenge.shop_hexagonal.member.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.challenge.shop_hexagonal.member.application.port.in.RegisterMemberCommand;
import com.challenge.shop_hexagonal.member.application.port.in.RegisterMemberUseCase;
import com.challenge.shop_hexagonal.member.application.port.out.LoadMemberPort;
import com.challenge.shop_hexagonal.member.application.port.out.UpdateMemberPort;
import com.challenge.shop_hexagonal.member.domain.Member;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
class RegisterMemberService implements RegisterMemberUseCase {

	private final LoadMemberPort loadMemberPort;
	private final UpdateMemberPort updateMemberPort;
	@Override
	public void register(RegisterMemberCommand command) {

		Member member = Member.withoutId(command.getName(), command.getAddress());
		updateMemberPort.update(member);
	}
}
