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
import com.pojo.Appointment;
//import com.pojo.addhospitalmodel;
//import com.service.RegistrationService;
import com.pojo.User;

@Component
@Controller
@RequestMapping("/appointment")

public class AppointmentController {
	
	  @RequestMapping(value = "/redirecttoslotselector", method = RequestMethod.POST)
		 public ModelAndView redirecttoregisteruser(ModelAndView model, @ModelAttribute Appointment appointment)
		 {
		
		  	System.out.println(appointment.getDate_selected().toString());
			model.addObject("appointment", appointment);
			model.setViewName("slotselector");
			return model;

		     
		 }
		 

	
	
	
	

}
