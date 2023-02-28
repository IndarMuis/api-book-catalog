package com.imcode.bookcatalog.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/v1/home")
	public String homePage() {
		return "Home page";
	}

	@GetMapping("/v1/user")
	public String userPage() {
		return "User only page";
	}

	@GetMapping("/v1/admin")
	public String adminPage() {
		return "Admin only page";
	}

}
