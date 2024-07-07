package com.ntdquan.fast_food_ecommerce_backend.Service;

import java.util.Optional;
import java.util.UUID;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntdquan.fast_food_ecommerce_backend.Model.RefreshToken;
import com.ntdquan.fast_food_ecommerce_backend.Repository.RefreshTokenRepository;
import com.ntdquan.fast_food_ecommerce_backend.Repository.UserRepository;


@Service
public class RefreshTokenService {
	@Autowired
	private RefreshTokenRepository refreshTokenRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public RefreshToken createRefreshToken(String username) {
		RefreshToken refreshToken = new RefreshToken();
		refreshToken.setUser(userRepository.findByUsername(username).get());
		refreshToken.setToken(UUID.randomUUID().toString());
		refreshToken.setExpiryDate(Instant.now().plusMillis(600000));
		return refreshTokenRepository.save(refreshToken);
	}
	
	public Optional<RefreshToken> findByToken(String token) {
		return refreshTokenRepository.findByToken(token);
	}
	
	public RefreshToken verifyExpiration(RefreshToken token) {
		if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
			refreshTokenRepository.delete(token);
			throw new RuntimeException(token.getToken() + " Refresh token was expired. Please make a new signin request");
		}
		return token;
	}
}
