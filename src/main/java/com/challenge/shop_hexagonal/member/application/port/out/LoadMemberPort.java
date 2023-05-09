package com.challenge.shop_hexagonal.member.application.port.out;

import java.util.List;
import java.util.Optional;

import com.challenge.shop_hexagonal.member.domain.Member;

public interface LoadMemberPort {
	Optional<Member> findById(Member.MemberId id);
	List<Member> findAll();
}
