package com.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.pojo.addhospitalmodel;
import com.pojo.loginmodel;
import com.pojo.userhospitalmodel;
import com.service.AuthService;

public class AuthService {

	
	
	 private HibernateTemplate hibernateTemplate;
	    private static Logger log = Logger.getLogger(AuthService.class);
	 
	    private AuthService() { }
	 
	    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
	        this.hibernateTemplate = hibernateTemplate;
	    }
	 
	    @SuppressWarnings( { "unchecked", "deprecation" } )
	   

		public boolean findUser(String username, String password)
	    {
			// TODO Auto-generated method stub
	        boolean isValidUser = false;
	        //String sqlQuery = "from User where name='"+uname + "' and password='"+upwd+"'";
	        String uemail=username;
	        String sqlQuery = "from loginmodel u where u.UserID=? and u.Password=?";
	        
	        System.out.println("User entered data Username : " + username + " \n pwd "+password);
	        
	        try {
	        	
	        	
	            List<loginmodel> userObj = (List) hibernateTemplate.find(sqlQuery, username, password);
	            
	           
	      
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

		public List<addhospitalmodel> listhospitals() {
			// TODO Auto-generated method stub
			int status = 0;
			String sqlQuery = "from addhospitalmodel where status = ? ";
			List<addhospitalmodel> userObj = (List) hibernateTemplate.find(sqlQuery,status);
			
			
			return userObj;
		}

		public List<addhospitalmodel> listhospitals1() {
			// TODO Auto-generated method stub
			int status = 1;
			String sqlQuery = "from addhospitalmodel where status = ? ";
			List<addhospitalmodel> userObj = (List) hibernateTemplate.find(sqlQuery,status);
			
			
			return userObj;
		}

		public List<addhospitalmodel> listhospitalsbyid(int id) {
			// TODO Auto-generated method stub
			String sqlQuery = "from addhospitalmodel where hospital_id = ? ";
			List<addhospitalmodel> userObj = (List) hibernateTemplate.find(sqlQuery,id);
			
			return userObj;
		}



		public String findUsertype(String username, String password) {
			// TODO Auto-generated method stub
			 String sqlQuery = "from loginmodel u where u.UserID=? and u.Password=?";
		        
		       
		
		            List<loginmodel> userObj = (List) hibernateTemplate.find(sqlQuery, username, password);
		
		                for (loginmodel obj : userObj)
		                {
		                    System.out.println("login Type : "  +  obj.getType() );
		                    return obj.getType();      
		                }

		           
		           
			return null;
		}

		public String mapUserByHospitaluniqueid(String uniqueid) {
			// TODO Auto-generated method stub
			
			String sqlQuery = "from userhospitalmodel where hosid = ? ";
			List<userhospitalmodel> userObj = (List) hibernateTemplate.find(sqlQuery,uniqueid);
			 for (userhospitalmodel obj : userObj)
             {
                 System.out.println("User ID : "  +  obj.getUserID() );
                 return obj.getUserID() ;    
             }
			return null;
		}

		

		
	
	
	

	
	
	
	
}
