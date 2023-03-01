package com.imcode.bookcatalog.repository;

import com.imcode.bookcatalog.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
