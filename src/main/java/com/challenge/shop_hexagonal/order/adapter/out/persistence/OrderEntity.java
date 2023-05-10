package com.challenge.shop_hexagonal.order.adapter.out.persistence;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.challenge.shop_hexagonal.order.domain.Order;
import com.challenge.shop_hexagonal.order.domain.OrderLine;
import com.challenge.shop_hexagonal.order.domain.OrderStatus;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_order")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderEntity {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @Column(name = "member_id")
    private Long member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItemEntity> orderItems = new ArrayList<>();

    @Column(name = "delivery_id")
    private Long delivery;

    private LocalDateTime orderDate; //주문시간

    private String status;

    public OrderEntity(Long id, Long member,
        List<OrderItemEntity> orderItems, Long delivery, LocalDateTime orderDate, String status) {
        this.id = id;
        this.member = member;
        this.orderItems = orderItems;
        this.delivery = delivery;
        this.orderDate = orderDate;
        this.status = status;
    }

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

    public static OrderEntity toEntity(Order order){

        List<OrderItemEntity> orderItems = order.getOrderLines().stream().map(
            orderLine -> OrderItemEntity.toEntity(orderLine)
        ).collect(Collectors.toList());

        return new OrderEntity(
            order.getId() == null? null : order.getId().getValue(),
            order.getMemberId(),
            orderItems,
            order.getDeliveryId(),
            LocalDateTime.now(),
            order.getStatus().toString()
        );
    }
}