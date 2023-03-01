package com.imcode.bookcatalog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Index;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Data
@MappedSuperclass
@Table(indexes = {@Index(name = "uk_secure_id", columnList = "secure_id")})
public class AbstractBaseEntity implements Serializable {

	@Serial
	private static final long serialVersionUID = 8011757603025998677L;

	@Column(name = "secure_id", nullable = false, unique = true)
	private String secureId = UUID.randomUUID().toString();

	@Column(name = "deleted", columnDefinition = "boolean default false")
	private boolean deleted;
}
