package com.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.service.IUserDetailsService;

@RestController
public class CommandController {

	@Autowired
	IUserDetailsService userService;
	
	@RequestMapping(value = "/add")
	public void insert() {
		userService.insertUtente("root", "root");
	}
}
