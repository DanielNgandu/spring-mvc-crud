package com.form.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//step 1: define controller 
@Controller
public class HomeController {
	
	//step 2: define controller method
    //return view 
	@RequestMapping("/")
	public String home() {
		//return view or page
		return "home";
	}

}
