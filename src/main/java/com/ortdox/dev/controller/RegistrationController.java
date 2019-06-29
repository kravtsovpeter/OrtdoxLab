package com.ortdox.dev.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ortdox.dev.domain.Role;
import com.ortdox.dev.domain.User;
import com.ortdox.dev.repos.UserRepo;

@Controller
public class RegistrationController {
	
	@Autowired
	private UserRepo userRepo;
	
	/**
	 * Вызов отображения страницы регистрации
	 * @return Отображаемая страница
	 */
	@GetMapping("/registration")
	public String registration() {
		return "registration";
	}
	
	/**
	 * Вызов сервиса регистрации пользователя
	 * @param user Пользователь
	 * @param model Модель параметров
	 * @return Отображаемая страница(редирект на страницу входа)
	 */
	@PostMapping("/registration")
	public String addUser(User user, Map<String, Object> model) {
		
		User userFromDb = userRepo.findByUsername(user.getUsername());
		if (userFromDb != null) {
			model.put("message", "Пользователь с именем " + user.getUsername() + " существует");
			return "registration";
		}
		
		user.setActive(true);
		user.setRoles(Collections.singleton(Role.USER));
		userRepo.save(user);
		return "redirect:/login";
	}

}
