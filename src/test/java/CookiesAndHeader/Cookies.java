package CookiesAndHeader;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.matcher.RestAssuredMatchers.*;
public class Cookies {

	
	 //  1. test cookie  
	
	//@Test
    void testcookie() 
	{
        
       
         given()
            

            .when()
            
                .get("https://www.google.com/")
                
         .then()
         
         
        .cookie("AEC","AVh_V2j3Nj3MVxpssQZTil8LyWKGiP3s0GFuKDs9iZDOJRcVVhKYjJN-m8U")
           .log().all();

           
    }
    
    // 2. Test single cookie 
    
    @Test
    
    void singlecookie() 
	{
        
       
        Response res= given()
            

            .when()
            
                .get("https://www.google.com/");
         
           // get cookie info
        
        // String cookie_value  = res.getCookie("AEC");
         
        // System.out.println("cookie value is = " +cookie_value);
         
         
         // // 3. Test All cookie 
         
         Map<String, String>   cookies_values =  res.getCookies();
         
        // System.out.println("All cookies key = " +cookies_values.keySet());
         
         for(String key : cookies_values.keySet())
         {
        	 String cookie_val=res.getCookie(key);
        	 System.out.println(key+ "   "  +cookie_val);
        	 
         }
         
    }
    
    
      
  

}
