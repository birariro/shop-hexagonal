package com.challenge.shop_hexagonal.member.adapter.out.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.challenge.shop_hexagonal.member.domain.Address;
import com.challenge.shop_hexagonal.member.domain.Member;
import com.challenge.shop_hexagonal.member.domain.Name;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_member")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class MemberEntity {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    private String city;
    private String street;
    private String zipcode;

    public Member toDomain(){

        return Member.withId(
            Member.MemberId.of(this.id),
            Name.of(name),
            Address.of(this.city,
                this.street,
                this.zipcode)
        );
    }

    public static MemberEntity toEntity(Member member){
        return new MemberEntity(
            member.getId() == null ? null : member.getId().getValue(),
            member.getName().getValue(),
            member.getAddress().getCity(),
            member.getAddress().getStreet(),
            member.getAddress().getZipcode()
        );
    }

}