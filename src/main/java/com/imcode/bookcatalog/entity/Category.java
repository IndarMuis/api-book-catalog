package com.imcode.bookcatalog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "category")
public class Category {

	@Id
	@Column(name = "code", nullable = false, unique = true)
	private String code;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "description")
	private String description;

}
