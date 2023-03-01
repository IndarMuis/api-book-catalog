package com.imcode.bookcatalog.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity
@Table(name = "publisher")
public class Publisher implements Serializable {

	@Serial
	private static final long serialVersionUID = 6707145584240166840L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "publisher_generator")
	@SequenceGenerator(name = "publisher_generator", sequenceName = "publisher_id_seq")
	private Integer id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "company_name")
	private String companyName;
}
