package com.ntdquan.fast_food_ecommerce_backend.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ntdquan.fast_food_ecommerce_backend.DTO.JwtResponse;
import com.ntdquan.fast_food_ecommerce_backend.DTO.RefreshTokenRequest;
import com.ntdquan.fast_food_ecommerce_backend.Model.AuthenticationResponse;
import com.ntdquan.fast_food_ecommerce_backend.Model.User;
import com.ntdquan.fast_food_ecommerce_backend.Repository.UserRepository;
import com.ntdquan.fast_food_ecommerce_backend.Service.AuthenticationService;
import com.ntdquan.fast_food_ecommerce_backend.Service.JwtService;

import io.jsonwebtoken.ExpiredJwtException;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/auth")
public class AuthController {
	private final AuthenticationService authService;
	private final JwtService jwtService;
	
	public AuthController(AuthenticationService authService, JwtService jwtService) {
		super();
		this.authService = authService;
		this.jwtService = jwtService;
	}
	
	@PostMapping("/login")
	public ResponseEntity<JwtResponse> register(@RequestBody User request) {
		return ResponseEntity.ok(authService.authenticate(request));
	}
	
	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> login(@RequestBody User request) {
		return ResponseEntity.ok(authService.customerRegister(request));
	}
	
	@PostMapping("/refreshToken")
	public ResponseEntity<JwtResponse> responseToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
		return ResponseEntity.ok(authService.refreshToken(refreshTokenRequest));
	}
	
	@PostMapping("/logout")
	public ResponseEntity<Void> logout(@RequestHeader("Authorization") String token) {
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        String username = null;
        try {
            username = jwtService.extractUsername(token);
        } catch (ExpiredJwtException e) {
            username = e.getClaims().getSubject();
        }
        authService.logoutUser(username);
        return ResponseEntity.ok().build();
	}
	
}
