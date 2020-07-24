package com.form.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class HelloWorldController {
	
	@RequestMapping("/showForm")
	public String showForm() {
		
		return "helloworld-form";
	}
	
	
	//recieve data from form
	@RequestMapping(value ="/processForm",method = RequestMethod.POST)
	public String processForm(HttpServletRequest   request,Model model, @RequestParam("age") int age) {
		//get param by name
		String name = request.getParameter("name");
		//assign to model
		model.addAttribute("name", name);
		
		//get variable via param binding
		model.addAttribute("age", age);

		//model attribute accessible on next view
		return "helloword";
	}

}
