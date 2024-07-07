package com.ntdquan.fast_food_ecommerce_backend.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntdquan.fast_food_ecommerce_backend.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
}
