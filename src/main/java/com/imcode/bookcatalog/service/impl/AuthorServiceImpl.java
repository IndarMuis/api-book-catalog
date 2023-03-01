package com.imcode.bookcatalog.service.impl;

import com.imcode.bookcatalog.dto.request.AuthorCreateRequestDTO;
import com.imcode.bookcatalog.entity.Author;
import com.imcode.bookcatalog.repository.AuthorRepository;
import com.imcode.bookcatalog.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@AllArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {

	private final AuthorRepository authorRepository;

	@Transactional
	@Override
	public void saveAuthor(AuthorCreateRequestDTO dto) {
		Author author = new Author();
		author.setName(dto.authorName());
		author.setBirthDate(LocalDate.ofEpochDay(dto.birthDate()));

		authorRepository.save(author);
	}
}
