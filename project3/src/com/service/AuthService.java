package com.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.pojo.User;
import com.service.AuthService;

public class AuthService {
	
	
	
	 private HibernateTemplate hibernateTemplate;
	  
	    private AuthService() { }

	    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
	        this.hibernateTemplate = hibernateTemplate;
	    }

		   

		public boolean findUser(String username, String password)
	    {
		
	        boolean isValidUser = false;
	      
	
	        String sqlQuery = "from User u where u.username=? and u.password=?";
	        
	        System.out.println("User entered data Username : " + username + " \n pwd "+password);
	        
	        try {
	        	
	        	
	            List<User> userObj = (List) hibernateTemplate.find(sqlQuery, username, password);
	            
	           
	      
	            if(userObj != null && userObj.size() > 0)
	            {
	                //log.info("Id= " + userObj.get(0)).getId() + ", Name= " + userObj.get(0).getName() + ", Password= " + userObj.get(0).getPassword());
	                isValidUser = true;
	            }
	           } 
	        catch(Exception e) 
	        {
	            isValidUser = false;
	           System.out.println("An error occurred while fetching the user details from the database");   
	        }
	        return isValidUser;
		}
	    
		
		


}
