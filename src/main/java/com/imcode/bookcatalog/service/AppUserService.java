package com.imcode.bookcatalog.service;

import com.imcode.bookcatalog.dto.request.RegisterRequestDTO;

public interface AppUserService {
	public void createNewUser(RegisterRequestDTO dto);
}
