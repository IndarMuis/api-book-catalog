package com.imcode.bookcatalog.repository;

import com.imcode.bookcatalog.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
