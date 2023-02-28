package com.imcode.bookcatalog.controller;

import com.imcode.bookcatalog.dto.request.LoginRequestDTO;
import com.imcode.bookcatalog.dto.request.RegisterRequestDTO;
import com.imcode.bookcatalog.dto.response.APIResponseDTO;
import com.imcode.bookcatalog.security.jwt.JwtAuthGenerator;
import com.imcode.bookcatalog.service.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class AuthController {

	private final AppUserService appUserService;
	private final AuthenticationManager authenticationManager;
	private final JwtAuthGenerator jwtAuthGenerator;

	@PostMapping("/v1/auth/register")
	public ResponseEntity<APIResponseDTO<?>> register(@RequestBody RegisterRequestDTO dto) {
		appUserService.createNewUser(dto);

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword())
		);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		String token = jwtAuthGenerator.generateToken(authentication);

		APIResponseDTO<?> result = APIResponseDTO.builder()
				.code(HttpStatus.CREATED.value())
				.message("Register Berhasil")
				.token(token)
				.build();

		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}

	@PostMapping("/v1/auth/login")
	public ResponseEntity<APIResponseDTO<?>> login(@RequestBody LoginRequestDTO dto) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(dto.email(), dto.password())
		);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		String token = jwtAuthGenerator.generateToken(authentication);
		APIResponseDTO<?> result = APIResponseDTO.builder()
				.code(HttpStatus.OK.value())
				.message("Login berhasil")
				.token(token)
				.build();

		return new ResponseEntity<>(result, HttpStatus.OK);

	}

}
