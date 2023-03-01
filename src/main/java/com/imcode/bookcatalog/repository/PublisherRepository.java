package com.imcode.bookcatalog.repository;

import com.imcode.bookcatalog.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
}
