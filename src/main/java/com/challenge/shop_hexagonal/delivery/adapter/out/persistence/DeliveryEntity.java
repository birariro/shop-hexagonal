package com.challenge.shop_hexagonal.delivery.adapter.out.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.challenge.shop_hexagonal.delivery.domain.DeliveryStatus;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tb_delivery")
class DeliveryEntity {

    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @Column(name = "order_id")
    private Long order;

    private String city;
    private String street;
    private String zipcode;

    private String status;
}