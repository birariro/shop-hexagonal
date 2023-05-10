package com.challenge.shop_hexagonal.item.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemEntityRepository extends JpaRepository<ItemEntity, Long> {
}
