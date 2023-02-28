package com.imcode.bookcatalog.service.impl;

import com.imcode.bookcatalog.dto.response.RoleResponseDTO;
import com.imcode.bookcatalog.entity.Role;
import com.imcode.bookcatalog.repository.RoleRepository;
import com.imcode.bookcatalog.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {

	private final RoleRepository roleRepository;

	@Override
	public RoleResponseDTO findByName(String roleName) {
		Role role = roleRepository.findByName(roleName).orElseThrow(() -> new RuntimeException("role name not found"));

		return RoleResponseDTO.builder()
				.roleName(role.getName())
				.build();
	}
}
