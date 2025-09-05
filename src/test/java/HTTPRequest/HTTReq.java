package HTTPRequest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import static io.restassured.matcher.RestAssuredMatchers.*;

public class HTTReq {
	
	int id;

	 @Test (priority =1)
	 void getusers()
	 {
		 given()
		 
		 
		 .when()
		 
		 .get("https://reqres.in/api/users?page=2")
		 
		 
		 .then()
		 
		 .statusCode(200)
		 
		 .body("page", equalTo(2))
		 
		 .log().all();
		 
		 
	 }
	  
	 
	 
	 @Test (priority =2)
	 void createUser() {

	     HashMap data = new HashMap();
	     data.put("name", "restassured");
	     data.put("title", "postman");

	    id= given()
	         .contentType("application/json")
	         .body(data)

	     .when()
	         .post("https://reqres.in/api/users")
	         
	         .jsonPath().getInt("id");
	         

	    // .then()
	      //   .statusCode(201)
	       //  .log().all();
	 }

	 
	 
	 @Test (priority =3, dependsOnMethods =("createUser"))
	 void updateuser() {

	     HashMap data = new HashMap();
	     data.put("name", "api");
	     data.put("title", "test");

	    given()
	         .contentType("application/json")
	         .body(data)

	     .when()
	         .put("https://reqres.in/api/users/"+id)
	         
	         

	    .then()
	        .statusCode(200)
	        .log().all();
	 }


	 @Test (priority =4)
	 void deleteuser() {

	 

	    given()
	        

	     .when()
	         .put("https://reqres.in/api/users/"+id)
	         
	         

	    .then()
	        .statusCode(204)
	        .log().all();
	 }
    
}
