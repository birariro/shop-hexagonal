package com.challenge.shop_hexagonal.member.application.port.out;

import com.challenge.shop_hexagonal.member.domain.Member;

public interface UpdateMemberPort {

	void update(Member member);
}
