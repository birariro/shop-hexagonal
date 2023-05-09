package com.challenge.shop_hexagonal.order.adapter.out.persistence;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.challenge.shop_hexagonal.delivery.adapter.out.persistence.DeliveryEntity;
import com.challenge.shop_hexagonal.member.adapter.out.persistence.MemberEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_order")
@Getter
@Setter
public class OrderEntity {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id") //FK 지정
    private MemberEntity member;

    @OneToMany(mappedBy = "order")
    private List<OrderItemEntity> orderItems = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "delivery_id")
    private DeliveryEntity delivery;

    private LocalDateTime orderDate; //주문시간

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}