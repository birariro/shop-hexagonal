package com.challenge.shop_hexagonal.order.adapter.out.persistence;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.challenge.shop_hexagonal.order.domain.Order;
import com.challenge.shop_hexagonal.order.domain.OrderLine;
import com.challenge.shop_hexagonal.order.domain.OrderStatus;

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

    @Column(name = "member_id")
    private Long member;

    @OneToMany(mappedBy = "order")
    private List<OrderItemEntity> orderItems = new ArrayList<>();

    @Column(name = "delivery_id")
    private Long delivery;

    private LocalDateTime orderDate; //주문시간

    private String status;


    public Order toDomain(){

        List<OrderLine> orderLines = this.orderItems.stream()
            .map(OrderItemEntity::toDomain)
            .collect(Collectors.toList());

        return Order.withId(Order.Id.of(this.id)
            ,this.member
            ,this.delivery,
            OrderStatus.valueOf(this.status),
            orderLines);

    }
}