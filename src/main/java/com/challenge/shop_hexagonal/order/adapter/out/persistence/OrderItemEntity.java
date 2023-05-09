package com.challenge.shop_hexagonal.order.adapter.out.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.challenge.shop_hexagonal.item.adapter.out.persistence.ItemEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_order_item")
@Getter
@Setter
public class OrderItemEntity {
    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private ItemEntity item;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    private int orderPrice; //주문 가격
    private int count; // 주문 수량
}