package com.challenge.shop_hexagonal.member.adapter.out.persistence;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.challenge.shop_hexagonal.common.PersistenceAdapter;
import com.challenge.shop_hexagonal.member.application.port.out.LoadMemberPort;
import com.challenge.shop_hexagonal.member.application.port.out.UpdateMemberPort;
import com.challenge.shop_hexagonal.member.domain.Member;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class MemberPersistenceAdapter implements LoadMemberPort, UpdateMemberPort {

	private final MemberEntityRepository memberEntityRepository;
	@Override
	public void update(Member member) {

		MemberEntity memberEntity = MemberEntity.toEntity(member);
		memberEntityRepository.save(memberEntity);
	}

	@Override
	public Optional<Member> findById(Member.MemberId id) {
		return memberEntityRepository.findById(id.getValue())
			.map(MemberEntity::toDomain);
	}

	@Override
	public List<Member> findAll() {
		return memberEntityRepository.findAll()
			.stream().map(MemberEntity::toDomain)
			.collect(Collectors.toList());
	}
}
