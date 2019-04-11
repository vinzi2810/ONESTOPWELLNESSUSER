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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//import com.service.AuthService;
//import com.pojo.addhospitalmodel;
import com.pojo.User;
import com.pojo.Appointment;
//import com.pojo.addhospitalmodel;
import com.service.AuthService;

@Component
@Controller
@RequestMapping("/user")
public class LoginController {
	
	 @Autowired
	    private AuthService authenticateService; 

	 @RequestMapping(value = "/AjaxCall", method = RequestMethod.GET)
	    public @ResponseBody String getDataFromAjax(@RequestParam("name")String username) {
		 System.out.println("In the /AjaxCall controller");
		 System.out.println("Name "+username);		 
		 //ModelAndView model = new ModelAndView();
		 //model.addObject("appointment", username);
		 //model.setViewName("result");
			//return model;
		 return "Vineetha";
	 }
	 

	
	    @RequestMapping(value = "/validateuser", method = RequestMethod.POST)
	    public ModelAndView validateUsr(@RequestParam("username")String username, @RequestParam("password")String password,RedirectAttributes redirectAttributes) {

	    	
	        System.out.println("Before saving in the database...");
	        
	        boolean isValid = authenticateService.findUser(username, password);
	    	
	         
	       
	        	if(isValid)
	        	{
	        		ModelAndView model = new ModelAndView();
	        		Appointment appointment = new Appointment();
	     			model.addObject("appointment", appointment);
	     			model.setViewName("test");
	     			return model;
	        		
	        		
	        		
	        		}
	        	
	        	else 
	        	{
	        		return new ModelAndView("index");
	        	}

	        	
	       }

	    
	    
	    
	    
}
