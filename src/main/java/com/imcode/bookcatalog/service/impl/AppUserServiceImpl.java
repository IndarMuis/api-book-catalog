package com.imcode.bookcatalog.service.impl;

import com.imcode.bookcatalog.dto.request.RegisterRequestDTO;
import com.imcode.bookcatalog.entity.AppUser;
import com.imcode.bookcatalog.entity.Role;
import com.imcode.bookcatalog.repository.AppUserRepository;
import com.imcode.bookcatalog.repository.RoleRepository;
import com.imcode.bookcatalog.service.AppUserService;
import com.imcode.bookcatalog.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@AllArgsConstructor
@Service
public class AppUserServiceImpl implements UserDetailsService, AppUserService {

	private final AppUserRepository appUserRepository;
	private final PasswordEncoder passwordEncoder;
	private final RoleService roleService;
	private final RoleRepository roleRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser appUser = appUserRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(
				"email not found"));

		return new User(appUser.getUsername(), appUser.getPassword(), appUser.getAuthorities());
	}

	@Override
	public void createNewUser(RegisterRequestDTO dto) {
		if (appUserRepository.existsByEmail(dto.getEmail())) {
			throw new RuntimeException("email already in use");
		} else {
			AppUser appUser = new AppUser();

			Role role = roleRepository.findByName("USER").orElseThrow(() -> new RuntimeException("role name not " +
					"found"));

			appUser.setFirstName(dto.getFirstName());
			appUser.setLastName(dto.getLastName());
			appUser.setEmail(dto.getEmail());
			appUser.setPassword(passwordEncoder.encode(dto.getPassword()));
			appUser.setRoles(Collections.singletonList(role));

			appUserRepository.save(appUser);
		}
	}
}
