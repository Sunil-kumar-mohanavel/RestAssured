package CookiesAndHeader;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.matcher.RestAssuredMatchers.*;
public class Header {

	
	

	 //  1. test header  
	
	//@Test
   void testheader() 
	{
       
      
        given()
           

           .when()
           
               .get("https://www.google.com/")
               
        .then()
        
         .header("Content-Type", "text/html; charset=ISO-8859-1")
         
         .and()
         
         .header("Server", "gws")
         
         .and()
         
         
         .header("Content-Encoding" , "gzip");
        
          
   }
   
   

	 //  2 . test single header  
	
	@Test
    void header() 
	{
     
    
     Response res = given()
         

         .when()
         
             .get("https://www.google.com/");
             
     // get single header info
     
   // String header_val  = res.header("Content-Type");
      
    // System.out.println("header value is = " +header_val);
      
      
      // 3. Test All header 
      
     Headers  ref=  res.getHeaders();
      
   
      
      for(io.restassured.http.Header val  : ref)
      {
     	
     	 System.out.println(val.getName()+ "   "  +val.getValue());
     	 
      } 
    
        
 }
	
}
