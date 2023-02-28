package com.imcode.bookcatalog.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serial;

@Data
@Entity
public class Role implements GrantedAuthority {

	@Serial
	private static final long serialVersionUID = 2887575183212748249L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name", nullable = false, unique = true)
	private String name;

	@Override
	public String getAuthority() {
		return "ROLE_"+this.name;
	}
}
