package com.imcode.bookcatalog.repository;

import com.imcode.bookcatalog.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
