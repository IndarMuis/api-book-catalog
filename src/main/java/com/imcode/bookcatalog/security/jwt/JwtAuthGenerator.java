package com.imcode.bookcatalog.security.jwt;

import io.jsonwebtoken.*;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class JwtAuthGenerator {

	private final Key key;

	public String generateToken(Authentication authentication) {
		Claims claims = Jwts.claims().setSubject(authentication.getName());
		claims.put("scopes", authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(
				Collectors.toList()));
		Date currentDate = new Date();
		Date expiredDate = new Date(currentDate.getTime() + 700000);

		Header jwtHeader = Jwts.header();
		jwtHeader.setType("JWT");

		return Jwts.builder()
				.setHeader((Map<String, Object>) jwtHeader)
				.setClaims(claims)
				.setIssuer("imcode.com")
				.setIssuedAt(currentDate)
				.setExpiration(expiredDate)
				.signWith(key, SignatureAlgorithm.HS256)
				.compact();
	}

	public String getEmailFromToken(String token) {
		Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
		return claims.getSubject();
	}

	public boolean validateToken(String token) {
		try {
			Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJwt(token);
			return true;
		} catch (Exception exc) {
			throw new BadCredentialsException("token invalid");
		}
	}

	public boolean isExpiredToken(String token) {
		return generateExpiredDateFromToken(token).before(new Date());
	}

	private Date generateExpiredDateFromToken(String token) {
		Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
		return claims.getExpiration();
	}

}
