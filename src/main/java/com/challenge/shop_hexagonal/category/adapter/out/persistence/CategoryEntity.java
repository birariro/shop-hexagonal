package com.challenge.shop_hexagonal.category.adapter.out.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.challenge.shop_hexagonal.item.adapter.out.persistence.ItemEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tb_category")
class CategoryEntity {

    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "category")
    private List<CategoryItemEntity> items = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private CategoryEntity parent;

    @OneToMany(mappedBy = "parent")
    private List<CategoryEntity> child = new ArrayList<>();
}