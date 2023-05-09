package com.challenge.shop_hexagonal.member.adapter.out.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.challenge.shop_hexagonal.delivery.adapter.out.persistence.Address;
import com.challenge.shop_hexagonal.order.adapter.out.persistence.OrderEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_member")
@Getter
@Setter
public class MemberEntity {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")//order 테이블에있는 member 필드가 나의 주체이다.
    private List<OrderEntity> orders = new ArrayList<>();
}