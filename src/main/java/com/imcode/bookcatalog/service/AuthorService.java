package com.imcode.bookcatalog.service;

import com.imcode.bookcatalog.dto.request.AuthorCreateRequestDTO;

public interface AuthorService {

	void saveAuthor(AuthorCreateRequestDTO dto);

}
