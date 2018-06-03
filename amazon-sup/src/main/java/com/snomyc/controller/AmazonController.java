package com.snomyc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.snomyc.sys.amazon.service.AmazonService;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
@RequestMapping("/amazon")
public class AmazonController {
	
	@Autowired
	private AmazonService amazonService;
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/list";
	}
	
}
