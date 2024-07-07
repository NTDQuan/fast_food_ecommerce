package com.ntdquan.fast_food_ecommerce_backend.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ntdquan.fast_food_ecommerce_backend.DTO.JwtResponse;
import com.ntdquan.fast_food_ecommerce_backend.DTO.RefreshTokenRequest;
import com.ntdquan.fast_food_ecommerce_backend.Model.AuthenticationResponse;
import com.ntdquan.fast_food_ecommerce_backend.Model.User;
import com.ntdquan.fast_food_ecommerce_backend.Service.AuthenticationService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/auth")
public class AuthController {
	private final AuthenticationService authService;
	
	public AuthController(AuthenticationService authService) {
		super();
		this.authService = authService;
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
}
