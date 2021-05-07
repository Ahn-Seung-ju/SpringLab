package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	public HelloController() {
		System.out.println("HelloController Consturctor Call");
	}
	
	@RequestMapping("/Hello.action")
	public ModelAndView hello() {
		System.out.println("[hello.action method call");
		ModelAndView mv = new ModelAndView();
		mv.addObject("greeting", "HI");
		mv.setViewName("Hello");
		
		return mv;
	}
}
