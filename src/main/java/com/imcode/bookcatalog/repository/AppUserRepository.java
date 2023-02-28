package com.imcode.bookcatalog.repository;

import com.imcode.bookcatalog.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {

	public Optional<AppUser> findByEmail(String email);

	public boolean existsByEmail(String email);

}
