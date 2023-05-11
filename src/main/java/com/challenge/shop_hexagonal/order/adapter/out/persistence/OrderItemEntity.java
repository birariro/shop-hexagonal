package com.challenge.shop_hexagonal.order.adapter.out.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.challenge.shop_hexagonal.order.domain.Money;
import com.challenge.shop_hexagonal.order.domain.OrderLine;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_order_item")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderItemEntity {
    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @Column(name = "item_id")
    private Long item;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    private int orderPrice; //주문 가격
    private int count; // 주문 수량

    public OrderItemEntity(Long id, Long item,  int orderPrice, int count) {
        this.id = id;
        this.item = item;
        this.orderPrice = orderPrice;
        this.count = count;
    }

    public OrderLine toDomain(){
        return OrderLine.withId(OrderLine.Id.of(this.id), this.item, this.count, Money.of(this.orderPrice));
    }

    public static OrderItemEntity toEntity(OrderLine orderLine){

        return new OrderItemEntity(
            orderLine.getId() == null ? null : orderLine.getId().getValue(),
            orderLine.getItemId(),
            orderLine.getPrice().getValue(),
            orderLine.getCount()
        );
    }
}