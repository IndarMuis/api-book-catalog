package com.imcode.bookcatalog.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "author")
public class Author extends AbstractBaseEntity{

	@Serial
	private static final long serialVersionUID = 5646239429392934290L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "birth_date")
	private LocalDate birthDate;

}
