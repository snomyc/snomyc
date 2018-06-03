package com.snomyc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.snomyc.sys.user.service.UserService;

@Controller
@RequestMapping("/amazon")
public class AmazonController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/list";
	}
	
}
