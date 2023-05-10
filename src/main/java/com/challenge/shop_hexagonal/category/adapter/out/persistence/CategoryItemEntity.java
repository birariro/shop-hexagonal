package com.challenge.shop_hexagonal.category.adapter.out.persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tb_category_item")
@IdClass(CategoryItemEntity.CategoryItemId.class)
public class CategoryItemEntity {

	@Id
	@ManyToOne
	@JoinColumn(name = "category_id")
	private CategoryEntity category;

	@Id
	private Long item;

	public class CategoryItemId implements Serializable {
		private Long category;
		private Long item;
	}
}
