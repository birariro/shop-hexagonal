package com.challenge.shop_hexagonal.delivery.adapter.out.persistence;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.challenge.shop_hexagonal.order.adapter.out.persistence.OrderEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tb_delivery")
public class DeliveryEntity {

    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private OrderEntity order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING) //enum 을 사용할때는 반드시 string 저장으로 설정
    private DeliveryStatus status;
}