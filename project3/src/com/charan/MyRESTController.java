package com.charan;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.DoctorDetails;
import com.pojo.HospitalDetails;

@Controller
@RequestMapping(value = "/MyData")



public class MyRESTController {
	
	@RequestMapping(value="/doctorselection", method = RequestMethod.GET)
    public @ResponseBody List<DoctorDetails> getMyDoctors(@RequestParam String hosname)
             {
    System.out.println("In the controller.../time..GET");
    
    
    List <DoctorDetails> lstString = new ArrayList<DoctorDetails>();
         String Name = hosname;
         
         if(Name.equals("Apollo Hospital")||Name.equals("Baptist Hospital"))
        	 
         {
         
         lstString.add(new DoctorDetails("Vineetha", "Orthodontist"));
         lstString.add(new DoctorDetails("Muralidhar", "Opthalmologist"));
         lstString.add(new DoctorDetails("Chenchu", "ENT Specialist"));
         }
         
         
         return lstString;
    
    	
       // return new MyData(1234, "REST GET Call !!!");
    }
	@RequestMapping(value="/cardselection", method = RequestMethod.GET)
    public @ResponseBody String getMyCardData(
    		@RequestParam String carddata) {
    System.out.println(carddata);
    
    	String hospital = carddata;
return hospital;

    
    	
       // return new MyData(1234, "REST GET Call !!!");
    }
	
	@RequestMapping(value="/rowselection", method = RequestMethod.GET)
    public @ResponseBody String getMyRowData(
    		@RequestParam String rowdata) {
    System.out.println(rowdata);
    
    	String hospital = rowdata;
return hospital;

    
    	
       // return new MyData(1234, "REST GET Call !!!");
    }
	
	
	@RequestMapping(value="/t", method = RequestMethod.GET)
    public @ResponseBody List<HospitalDetails> getMyDatanew(@RequestParam String name)
             {
    System.out.println("In the controller.../time..GET");
    
         String Name = name;
         
         List <HospitalDetails> lstString = new ArrayList<HospitalDetails>();
         lstString.add(new HospitalDetails("Apollo Hospital", "Jayanagar"));
         lstString.add(new HospitalDetails("Baptist Hospital", "Yelahanka"));
         
         return lstString;
    
    	
       // return new MyData(1234, "REST GET Call !!!");
    }
 
	@RequestMapping(value="/{time}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<String> getMyData(
            @PathVariable long time) {
    System.out.println("In the controller.../time..GET");
    
         List<String> lst = new ArrayList<String>();
         lst.add("Charan");
         lst.add("lavanya tripathi...");
         
         return lst;
    
    	
       // return new MyData(1234, "REST GET Call !!!");
    }
    
    
   /* @RequestMapping(value="/new", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<String> getMyDatanew(
            @PathVariable long time) {
    System.out.println("In the controller.../time..GET");
    
         List<String> lst3 = new ArrayList<String>();
         lst3.add("Charasdfsdfxsdfn");
         lst3.add("lavanya trxgfxcfgipathi...");
         
         
         
         return lst3;
    
    	
       // return new MyData(1234, "REST GET Call !!!");
    }*/
 
    
    
    
    
    
    @RequestMapping(method=RequestMethod.PUT, produces = "application/json")
    public @ResponseBody MyData putMyData() {
 
        System.out.println("In the PUT Controller..");
    	return new MyData(System.currentTimeMillis(),"Vineetha, the intelligence of intelligent!!");
    }
    
    
   /* @RequestMapping(value ="/a", method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody String putMyDatanew() {
 
        System.out.println("In the PUT Controller..");
        String lst = "Vineetha new!";
    	return lst;
    }*/
    
    
    
    
    
    
    
    
 
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody MyData postMyData() {
 
 return new MyData(System.currentTimeMillis(),"Vineetha, the great artist!!");
 
 
    }
 
    
    
    
    
    
    @RequestMapping(value="/{time}", method = RequestMethod.DELETE, produces = "application/json")
    public @ResponseBody MyData deleteMyData(
            @PathVariable long time) {
    	
        return new MyData(time, "Vineetha");
    }
}