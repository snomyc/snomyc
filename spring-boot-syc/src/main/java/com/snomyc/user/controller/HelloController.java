package com.snomyc.user.controller;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springfox.documentation.annotations.ApiIgnore;

@Controller
@ApiIgnore
public class HelloController {
	
//	@Autowired
//    private StringRedisTemplate stringRedisTemplate;
	@ApiIgnore
    @RequestMapping("/hello")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "hello";
    }
	@ApiIgnore
    @RequestMapping(value = "/redis")
    public String insertString() {
//        stringRedisTemplate.opsForValue().set("TOKEN-yc", "123456");
        return "hello";
    }

}
