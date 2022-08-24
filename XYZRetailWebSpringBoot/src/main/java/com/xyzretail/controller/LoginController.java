package com.xyzretail.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xyzretail.bean.Customer;
import com.xyzretail.service.CustomerService;

@Controller
@Scope("session")
public class LoginController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/")
	public ModelAndView loginPageController() {
		return new ModelAndView("LoginPage","command",new Customer());
	}
	
	@RequestMapping("/login")
	public ModelAndView loginController(@ModelAttribute Customer customer, HttpSession session, @RequestParam("action") String action) {
		ModelAndView modelAndView=new ModelAndView();
		if(action.equals("Register")) {
			
			String message=null;
			if(customerService.addCustomer(customer)) {
				message="Registration successful !!";	
			}
			else {
				message="Invalid Registration!!";
			}
			modelAndView.addObject("message",message);
			modelAndView.addObject("command", new Customer());
			modelAndView.setViewName("LoginPage");
//			return modelAndView;
		}
		else if(action.equals("Login")) {
			if(customerService.validateCustomer(customer)) {
				modelAndView.addObject("customer", customer);  //user object added at request scope
				session.setAttribute("customer", customer);
				modelAndView.setViewName("index");
			}
			else {
				modelAndView.addObject("message", "Invalid Credentials ");
				modelAndView.addObject("command", customer);
				modelAndView.setViewName("LoginPage");
			}
			}
				
		
		return modelAndView;
		
	}
	

	@RequestMapping("/logout")
	 public ModelAndView logoutController(HttpSession session) {
		session.invalidate();
		return new ModelAndView("LoginPage","command",new Customer());
	}

}
