package com.service;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pojo.User;


public class RegistrationService {
	
	

	 private HibernateTemplate hibernateTemplate;
	  
	    private RegistrationService() { }

	    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
	        this.hibernateTemplate = hibernateTemplate;
	    }
	    
		public void addUser(User userObj) {
			//hibernateTemplate.save(userObj);
			Session session = hibernateTemplate.getSessionFactory().openSession();
			session.save(userObj);
			//session.getTransaction().commit();
			session.close();
			
			session = hibernateTemplate.getSessionFactory().openSession();
			
			int id = userObj.getId();
			Object o=session.load(User.class, id);			
			User userObj1 = (User)o;

			Transaction tx = session.beginTransaction();	

	        userObj1.setPassword("test");
	        
		
			tx.commit();
			
			
			
		
		}

	    
	    
	    

	  

}
