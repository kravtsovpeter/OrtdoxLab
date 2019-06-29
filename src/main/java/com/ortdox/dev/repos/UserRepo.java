package com.ortdox.dev.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ortdox.dev.domain.User;

/**
 * DAO репозиторий для пользователей
 * @author Kravtsov
 *
 */
public interface UserRepo extends JpaRepository<User, Long> {
	
	/** Поиск по полю username */
	User findByUsername(String username);
}
