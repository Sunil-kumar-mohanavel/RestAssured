package SerializationDeserialization;


import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class SerialDeserial {
	
       //  @Test(priority=1)
	
              void convertPOJOToJSON() throws JsonProcessingException 
	          {
           
        	  // created java object to POJO class
        	 
        	 
             StudentPOJO data = new StudentPOJO();
             
             data.setName("james");
             data.setLocation("germany");
             data.setPhone("12345");
              
              String coursearr[] = { "c", "c++" };
	   
             data.setCourses(coursearr);
        
             
             // convert JAVA OBJECT To JSON OBJECT  (serialization)             
             
             ObjectMapper map = new ObjectMapper();
             
         String jsondata = map.writerWithDefaultPrettyPrinter().writeValueAsString(map);
             
             System.out.println(jsondata);
                
	          }
         
         
         @Test(priority=2)
     	
         void convertJSONTOPOJO() throws JsonProcessingException 
         {
      
   	  
        	 String jsondata="{\r\n"
        			    + " \"name\" : \"jim\",\r\n"
        			    + " \"location\" : \"France\",\r\n"
        			    + " \"phone\" : \"12345\",\r\n"
        			    + " \"courses\" : [ \"C\", \"C++\" ]\r\n"
        			    + "}";

        			//convert json data To Pojo object
        	 
        			ObjectMapper Mapper = new ObjectMapper();

        			//convert json TO pojo
        			
StudentPOJO stupojo = Mapper.readValue(jsondata, StudentPOJO.class); 

        			System.out.println("Name: " + stupojo.getName());
        			System.out.println("Location: " + stupojo.getLocation());
        			System.out.println("Phone: " + stupojo.getPhone());
        			System.out.println("Course 1: " + stupojo.getCourses()[0]);
        			System.out.println("Course 2: " + stupojo.getCourses()[1]);

}
         
}
