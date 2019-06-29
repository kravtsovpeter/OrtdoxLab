package com.ortdox.dev.domain;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 * Бизнес объект пользователь
 * @author Kravtsov
 */
@Entity
@Table(name="usr")
public class User {
	
	/** Идентификатор пользователя */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/** Имя пользователя */
	private String username;
	
	/** Пароль пользователя */
	private String password;
	
	/** Признак активности пользователя*/
	private boolean active;
	
	/** Роли пользователя */
	@ElementCollection(targetClass = Role.class, fetch=FetchType.EAGER)
	@CollectionTable(name="user_role", joinColumns=@JoinColumn(name="user_id"))
	@Enumerated(EnumType.STRING)
	private Set<Role> roles;

	/**
	 * @return Идентификатор пользователя
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Установить идентификатор пользователя
	 * @param id Идентификатор пользователя
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return Имя пользователя
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Установить имя пользователя
	 * @param userName Имя пользователя
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return Пароль пользователя
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Установить пароль пользователя
	 * @param password Пароль пользователя
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return Признак активности пользователя
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * Установить признак активности пользователя
	 * @param active Признак активности пользователя
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @return Роли пользователя
	 */
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * Установить роли пользователя
	 * @param roles Роли пользователя
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	} 
	
	
}
