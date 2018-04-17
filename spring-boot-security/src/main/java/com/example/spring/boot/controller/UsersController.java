package com.example.spring.boot.controller;

import com.example.spring.boot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller
public class UsersController {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	private final UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/users")
	// @PreAuthorize("hasAuthority('ADMIN')")
	public ModelAndView getUsersPage(Authentication authentication) {
		Object principal = authentication.getPrincipal();
		if (principal instanceof UserDetails) {
			UserDetails user = (UserDetails) principal;
			Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
			for (GrantedAuthority authority : authorities) {
				logger.debug("current user ROLE is: " + authority.getAuthority());
			}
		}
		return new ModelAndView("jsp/users", "users", userService.findAll());
	}

}