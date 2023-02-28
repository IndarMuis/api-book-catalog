package com.imcode.bookcatalog.service;

import com.imcode.bookcatalog.dto.response.RoleResponseDTO;

public interface RoleService {

	public RoleResponseDTO findByName(String roleName);

}
