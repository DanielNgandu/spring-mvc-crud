package com.form.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.form.models.Employee;
import com.object.dao.EmployeeDao;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	//used to trim white spaces from form submissions
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
	StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
	dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("employeeReg", "employee", new Employee());
    }
 

	
	   @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	    public String submit(@Valid @ModelAttribute("employee")Employee employee, 
	      BindingResult result, ModelMap model) {
	        if (result.hasErrors()) {
	            return "employeeReg";
	        }
	        EmployeeDao employeeDao = new EmployeeDao();
	        Employee employee2 = new Employee(employee.getId(),employee.getFirst_name(), employee.getLast_name(), employee.getEmail());
	        employeeDao.saveEmployee(employee2);
	        List <Employee> employees = employeeDao.getEmployees();
	        employees.forEach(s-> System.out.println(s.getFirst_name()));
	        
	        model.addAttribute("id", employee.getId());
	        model.addAttribute("first_name", employee.getFirst_name());
	        model.addAttribute("last_name", employee.getLast_name());
	        model.addAttribute("email", employee.getEmail());

	        return "employeeView";
	    }
}
