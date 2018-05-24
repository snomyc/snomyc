package com.snomyc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	
//	@Autowired
//    private StringRedisTemplate stringRedisTemplate;
	
    @RequestMapping("/hello")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "hello";
    }

//    @RequestMapping(value = "/redis/string", method = RequestMethod.GET)
//    public void insertString() {
//        stringRedisTemplate.opsForValue().set("TOKEN-yc", "123456");
//    }

}
