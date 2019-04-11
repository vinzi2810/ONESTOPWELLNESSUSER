package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.service.AuthService;
import com.pojo.addhospitalmodel;
import com.pojo.loginmodel;

@Component
@Controller
@RequestMapping("/user")
public class LoginController {

	 @Autowired
	    private AuthService authenticateService; 
	 
 
	
	    @RequestMapping(value = "/validateuser", method = RequestMethod.POST)
	    public ModelAndView validateUsr(@RequestParam("username")String username, @RequestParam("password")String password,RedirectAttributes redirectAttributes) {

	    	
	        System.out.println("Before saving in the database...");
	        
	        boolean isValid = authenticateService.findUser(username, password);
	    	String type = authenticateService.findUsertype(username, password);
	        System.out.println("Type in second :"  + type);
	         
	       
	        	if(isValid && type.equalsIgnoreCase("A"))
	        	{
	       
	        	List<addhospitalmodel> hospitallist=new ArrayList<addhospitalmodel>(); 
	        	hospitallist = authenticateService.listhospitals();
	        	/*for (addhospitalmodel obj : hospitallist)
	            {
	        		System.out.println("Hospital Id :" + obj.getId());
	               System.out.println("Hospital Name :" + obj.getName());
	               System.out.println("Hospital Name :" + obj.getStatus());
	                        
	            }*/
	        	List<addhospitalmodel> hospitallist1=new ArrayList<addhospitalmodel>(); 
	        	hospitallist1 = authenticateService.listhospitals1();
	              ModelAndView mv = new ModelAndView();
	              mv.setViewName("dashboard");
	              mv.addObject("list",hospitallist);
	              mv.addObject("list1",hospitallist1);
	             
	              return mv;
	        	}
	        	else if (isValid && type.equalsIgnoreCase("RH"))
	        	{
	        		
	        		
	        		return new ModelAndView("hospitaladmin");
	        	}
	        	else if (isValid && type.equalsIgnoreCase("UH"))
	        	{
	        		return new ModelAndView("hospitaladminr");
	        	}
	        	else if (isValid && type.equalsIgnoreCase("U"))
	        	{
	        		return new ModelAndView("hospitaladmin");
	        	}
	        	else 
	        	{
	        		return new ModelAndView("index");
	        	}

	        	
	       
	        
	    }
/*	   
        @RequestMapping(value = "/dashboard1")
	    public String dashboard1()
	    {
	    	return "dashboard";
	    }
	    @RequestMapping(value = "/index1")
	    public String index1()
	    {
	    	return "index";
	    }
*/
	
}
