package com.form.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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
		Employee employee2 = new Employee(employee.getFirst_name(), employee.getLast_name(), employee.getEmail());
		employeeDao.saveEmployee(employee2);
		//get employee object
		List <Employee> employees = employeeDao.getEmployees();
		//	        employees.forEach(s-> System.out.println(s.getFirst_name()));

		Employee employee3 = employeeDao.getEmployeesById(employee2.getId());
		System.out.println(employee3.getFirst_name());


		//get form data and update our confirmation page
		//	        model.addAttribute("id", employee.getId());
		model.addAttribute("first_name", employee.getFirst_name());
		model.addAttribute("last_name", employee.getLast_name());
		model.addAttribute("email", employee.getEmail());

		return "employeeView";
	}
	
	
	//view all employees
	@RequestMapping(value = "/view", method = RequestMethod.GET)	
	String viewAllEmployees (ModelMap model) {
		
		//get list from dao
		EmployeeDao employeeDao = new EmployeeDao();
		//get employee obj
		List<Employee> employeeList = employeeDao.getEmployees();
		//add list to model
		
		model.addAttribute("employeeList", employeeList);
		
		return "viewEmployees";
	}
	
	//edit employee
	@RequestMapping(value = "/editEmployee/{employeeId}", method = RequestMethod.GET)	
	String editEmployee (ModelMap model,@PathVariable("employeeId") String employeeId) {
		EmployeeDao employeeDao = new EmployeeDao();

		Employee employee = employeeDao.getEmployeesById(Long.valueOf(employeeId));
		model.addAttribute(employee);
		return "editEmployee";
	}
	
	
	//update employee 
	@RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
	String updateEmployee (@Valid @ModelAttribute("employee")Employee employee, 
			BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "employeeReg";
		}
		
		EmployeeDao employeeDao = new EmployeeDao();

		employeeDao.updateEmployee(employee);
		System.out.println("Updated!!");
		return "employeeView";
		
	}
	
	//delete employee
    @GetMapping("/deleteEmployee/{employeeId}")
    public String deleteEmployee(@PathVariable("employeeId") String employeeId, Model model) {
		EmployeeDao employeeDao = new EmployeeDao();

		Employee employee = employeeDao.getEmployeesById(Long.valueOf(employeeId));
        employeeDao.deleteEmployee(employee);

    	//get list from dao
        //get employee obj
		List<Employee> employeeList = employeeDao.getEmployees();
		//add list to model
		
		model.addAttribute("employeeList", employeeList);
		
		return "viewEmployees";
    }

}
