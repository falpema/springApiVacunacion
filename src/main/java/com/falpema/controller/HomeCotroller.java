package com.falpema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeCotroller {
	@GetMapping("/")
	public String index() {
		return "index";
	}
}
