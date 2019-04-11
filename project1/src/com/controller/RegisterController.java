package com.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.AuthService;
import com.service.RegistrationService;
import com.pojo.addhospitalmodel;
import com.pojo.loginmodel;
import com.pojo.userhospitalmodel;

import java.util.UUID;

import com.fasterxml.uuid.Generators;

@Component
@Controller
@RequestMapping("/newuser")

public class RegisterController {
	
	 @Autowired
	 private RegistrationService authenticateService; 
	 @Autowired
	 private AuthService authenticateService1; 
	
	 @RequestMapping(value = "/redirectregister")
	 public String redirecttoregister()
	 {
		 return "redirect:registerlink1";
	 }
	  @RequestMapping(value = "/registerlink1")
	    public String dashboard1()
	    {
	    	return "addhospitalrequest";
	    }
	  
	  
	  
	  @RequestMapping(value = "/redirectregisteruser")
		 public String redirecttoregisteruser()
		 {
			 return "redirect:registerlink2";
		 }
		  @RequestMapping(value = "/registerlink2")
		    public String dashboard2()
		    {
		    	return "registerlink";
		    }
	
	  @RequestMapping(value = "/register", method = RequestMethod.POST)
	  public String validateUsr(@RequestParam("username")String username, @RequestParam("password")String password, @RequestParam("email")String email, @RequestParam("contact")String contact,RedirectAttributes redirectAttributes) {

	    	
	        loginmodel userobj = new loginmodel();
	        userobj.setUserID(username);
	        userobj.setPassword(password);
	        userobj.setEmail(email);
	        userobj.setContactNumber(contact);
	        
	        boolean isValid = authenticateService.registerUser(userobj);
	    	
	        System.out.println("\n\nTo check data in register /n Email  :"+userobj.getEmail());
	        System.out.println("\n\n Contact  :"+userobj.getContactNumber());
	        System.out.println("\n\n Password  :"+userobj.getPassword());
	        System.out.println("\n\n UserId  :"+userobj.getUserID());
	        
	         
	        if(isValid) {
	        	System.out.println("After saving in the db...");
	        	return "index";
	        } else {
	        	
	        	return "redirect:registerlink1";
	        }
	 
	        
	    }
	  
	  
	   
	  @RequestMapping(value = "/addhospital", method = RequestMethod.POST)
	  public String addhospital(HttpServletRequest request , HttpServletResponse response) {

		     String username= request.getParameter("uid");
		     String email= request.getParameter("email");
		     String contact= request.getParameter("contact");
		     String hospitalname= request.getParameter("hospital_name");
		     String adr1= request.getParameter("addr1");
		     String adr2= request.getParameter("addr2");
		     String state= request.getParameter("stt");
		     String city= request.getParameter("hcity");
		     String pin= request.getParameter("pin");
		     String certifications= request.getParameter("certifications");
		     String success_op= request.getParameter("success_op");
		     String achieve = request.getParameter("achieve");
		     
		     int len = 6;
	         String password = authenticateService.generate_Password(len);
	         
	         
	        loginmodel log = new loginmodel();
	        log.setUserID(username);
	        log.setEmail(email);
	        log.setPassword(password);
	        String type = "UH";
	        log.setType(type);
	        log.setContactNumber(contact);
	       
	        
	        UUID uuid1 = Generators.timeBasedGenerator().generate();
			System.out.println("UUID : "+uuid1);
			String strUUID = uuid1.toString();
			System.out.println("UUID Version : "+uuid1.version());
			System.out.println("UUID Variant : "+uuid1.variant());

	        userhospitalmodel userhos = new userhospitalmodel();
	        userhos.setUserID(username);
	        userhos.setHosid(strUUID);
	        
	        
	        
	        
	        addhospitalmodel userobj = new addhospitalmodel();
	        userobj.setUniqueid(strUUID);
	        userobj.setName(hospitalname);
	        userobj.setAddress1(adr1);
	        userobj.setAddress2(adr2);
	        userobj.setState(state);
	        userobj.setCity(city);
	        userobj.setPin(pin);
	        userobj.setCertifications(certifications);
	        userobj.setSuccess(success_op);
	        int status = 0;
	        userobj.setStatus(status);
	        userobj.setOptional("NA");
	        userobj.setAchievements(achieve);
	        
	        System.out.println(username);
	        System.out.println(email);
	        System.out.println(contact);
	        System.out.println(uuid1);
	        System.out.println(hospitalname);
	        System.out.println(adr1);
	        System.out.println(adr2);
	        System.out.println(state);
	        System.out.println(city);
	        System.out.println(pin);
	        System.out.println(certifications);
	        System.out.println(success_op);
	        System.out.println(achieve);
	        
	        System.out.println("\n\nTo check data in email  :"+log.getEmail());
	        System.out.println("\n\nTo check data in email  :"+log.getContactNumber());
	        System.out.println("\n\nTo check data in email  :"+log.getPassword());
	        System.out.println("\n\nTo check data in email  :"+log.getUserID());
	        
	        boolean isvalid = authenticateService.registerhospital(log,userobj,userhos);
	        if(isvalid)
	        	{
	        	   return "index";
	        	}
	        else
	        	return "addhospitalrequest";
	       
	 
	        
	    }
	  
	  @RequestMapping(value = "/accept/{id}", method = RequestMethod.GET)
	  public ModelAndView accepthospital(@PathVariable("id") int id,Model model)
	  {
		 System.out.println("id :" + id); 
	
		 List<addhospitalmodel> list=new ArrayList<addhospitalmodel>(); 
		 list = authenticateService1.listhospitalsbyid(id);
	     
		for (addhospitalmodel obj : list)
         {
     		System.out.println("Hospital Id :" + obj.getId());
            System.out.println("Hospital Name :" + obj.getName());
            System.out.println("Hospital Status :" + obj.getStatus());
            System.out.println("Hospital unique id  :" + obj.getUniqueid());
            String uniqueid = obj.getUniqueid();
            String userid = authenticateService1.mapUserByHospitaluniqueid(uniqueid);
            boolean update1 = authenticateService.accepthos(id,userid);     
         }
		
	    List<addhospitalmodel> hospitallist=new ArrayList<addhospitalmodel>(); 
     	hospitallist = authenticateService1.listhospitals();
     	/*for (addhospitalmodel obj : hospitallist)
         {
     		System.out.println("Hospital Id :" + obj.getId());
            System.out.println("Hospital Name :" + obj.getName());
            System.out.println("Hospital Name :" + obj.getStatus());
                     
         }*/
     	List<addhospitalmodel> hospitallist1=new ArrayList<addhospitalmodel>(); 
     	hospitallist1 = authenticateService1.listhospitals1();
           ModelAndView mv = new ModelAndView();
           mv.setViewName("dashboard");
           mv.addObject("list",hospitallist);
           mv.addObject("list1",hospitallist1);
          
           return mv;
		 
		
	  }
	  
	  
	  
	  
	  
	  @RequestMapping(value = "/ignore/{id}", method = RequestMethod.GET)
	  public ModelAndView ignorehospital(@PathVariable("id") int id,Model model)
	  {
		 System.out.println("id :" + id); 
		 
		 List<addhospitalmodel> list=new ArrayList<addhospitalmodel>(); 
		 list = authenticateService1.listhospitalsbyid(id);
	
		for (addhospitalmodel obj : list)
         {
     		System.out.println("Hospital Id :" + obj.getId());
            System.out.println("Hospital Name :" + obj.getName());
            System.out.println("Hospital Status :" + obj.getStatus());
            String uniqueid = obj.getUniqueid(); 
            
            String userid = authenticateService1.mapUserByHospitaluniqueid(uniqueid);
            boolean update1 = authenticateService.ignorehos(id,userid);
            
         }
	    List<addhospitalmodel> hospitallist=new ArrayList<addhospitalmodel>(); 
     	hospitallist = authenticateService1.listhospitals();
     	/*for (addhospitalmodel obj : hospitallist)
         {
     		System.out.println("Hospital Id :" + obj.getId());
            System.out.println("Hospital Name :" + obj.getName());
            System.out.println("Hospital Name :" + obj.getStatus());
                     
         }*/
     	List<addhospitalmodel> hospitallist1=new ArrayList<addhospitalmodel>(); 
     	hospitallist1 = authenticateService1.listhospitals1();
           ModelAndView mv = new ModelAndView();
           mv.setViewName("dashboard");
           mv.addObject("list",hospitallist);
           mv.addObject("list1",hospitallist1);
          
           return mv;
		 
		
	  }
	  
	  
	  
	  
}
