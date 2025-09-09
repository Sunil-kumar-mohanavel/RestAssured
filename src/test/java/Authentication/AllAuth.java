package Authentication;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


         public class AllAuth {
	
	
           //@Test(priority=1)
	
              void basicauth() 
	          {
        
		 
       
           given()
            
           .auth().basic("postman", "password")

            .when()
            
                .get("https://postman-echo.com/basic-auth")

            .then()
                .statusCode(200)
                
                .body("authenticated", equalTo(true))
           
                .log().all();

    }

           
           

           //@Test(priority=2)
	
              void digestcauth() 
	          {
        
		 
       
           given()
            
           .auth().digest("postman", "password")

            .when()
            
                .get("https://postman-echo.com/basic-auth")

            .then()
                .statusCode(200)
                
                .body("authenticated", equalTo(true))
           
                .log().all();

    }

           
           
          // @Test(priority=3)
       	
           void preemptiveauth() 
	          {
     
		 
    
        given()
         
        .auth().preemptive().basic("postman", "password")

         .when()
         
             .get("https://postman-echo.com/basic-auth")

         .then()
             .statusCode(200)
             
             .body("authenticated", equalTo(true))
        
             .log().all();

 }
           
           
           @Test(priority=4)
          	
           void bearerauth() 
	          {
     
		  String token ="";
    
        given()
         
          .headers("Authorization","Bearer " +token)

         .when()
         
             .get("")

         .then()
             .statusCode(200)
             
           
        
             .log().all();

 }

           
           
           @Test(priority=5)
         	
           void Oauth1() 
	          {
     
		 
    
        given()
         
  .auth().oauth("consumer key", "consumer secrat", "accsess token", "token secrat")

         .when()
         
             .get("url")

         .then()
             .statusCode(200)
             
           
        
             .log().all();

 }
           
           @Test(priority=6)
        	
           void Oauth2() 
	          {
     
		 
   
        given()
         
  .auth().oauth2("token")

         .when()
         
             .get("url")

         .then()
             .statusCode(200)
             
           
        
             .log().all();

 }
           
           
           @Test(priority=7)
       	
           void Apikey() 
	          {
     
		 
   
        given()
         
       .queryParam("Appid", "token")
       
       .pathParam("path", "data/2.5/forecast/daily")
       
       .queryParam("q", "france")
       
       .queryParam("units", "metric")
       
       
       

         .when()
         
             .get("https://openweathermap.org/{path}")

         .then()
             .statusCode(200)
             
           
        
             .log().all();

 }
           
          }