package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//import com.service.AuthService;
//import com.pojo.addhospitalmodel;
import com.pojo.User;
//import com.pojo.addhospitalmodel;
import com.service.RegistrationService;


@Component
@Controller
@RequestMapping("/newuser")

public class RegisterController {
	
	
	 @Autowired
	 private RegistrationService registrationService; 
	 
	  @RequestMapping(value = "/redirectregisteruser")
		 public String redirecttoregisteruser()
		 {
		
		     
		     return "redirect:registerlink2";
		 }
		 
	  @RequestMapping(value = "/registerlink2")
		    public ModelAndView dashboard2(ModelAndView model)
		    {
		    User userObj= new User();
			model.addObject("userObj", userObj);
			model.setViewName("registerlink");
			return model;
		        
		    }
	 

		@RequestMapping(value = "/RegisterUser", method = RequestMethod.POST)
		public String saveEmployee(@ModelAttribute User userObj) {
			
			
			
			registrationService.addUser(userObj);
			
			return "redirect:/newuser/redirectregisteruser";

			 
			 
		}

	

}
