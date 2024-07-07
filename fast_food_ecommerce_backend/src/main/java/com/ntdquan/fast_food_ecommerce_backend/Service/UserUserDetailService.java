package com.ntdquan.fast_food_ecommerce_backend.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.ntdquan.fast_food_ecommerce_backend.Model.User;
import com.ntdquan.fast_food_ecommerce_backend.Model.UserUserDetails;
import com.ntdquan.fast_food_ecommerce_backend.Repository.UserRepository;

@Component
public class UserUserDetailService implements UserDetailsService {
	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = repository.findByUsername(username);
		return user.map(UserUserDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("user not found " + username));
	}
}
