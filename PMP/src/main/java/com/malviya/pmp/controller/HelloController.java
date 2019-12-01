package com.malviya.pmp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public void sayHello() {
		System.out.println("Hello Roopesh Malviya");
		System.out.println("Hello Roopesh ");
		
	}

}
