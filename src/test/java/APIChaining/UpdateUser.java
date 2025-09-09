package APIChaining;
import static io.restassured.RestAssured.*;

import net.minidev.json.JSONObject;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class UpdateUser {

	
	
@Test
	
	void updateuser(ITestContext context)
	{
	
	Faker faker = new Faker();

	JSONObject data = new JSONObject();

	data.put("name", faker.name().fullName());
	data.put("gender", "Male");
	data.put("email", faker.internet().emailAddress());
	data.put("status", "active");

	String bearerToken = "763af209df3117d9ea1018b192f25cc3e82eaf90a1ed6892990918d1f0e85be2";
      
	  //int id = (int) context.getAttribute("userid");
	
	int id = (int) context.getSuite().getAttribute("userid"); // SUITE level 
	
	       given()
			
	    .headers("Authorization", "Bearer " + bearerToken)
	    .contentType("application/json")
	    .body(data.toString())
	    .pathParam("id", id)
	    
	.when()
	
	    .put("https://gorest.co.in/public/v2/users/{id}")
	    
	    
	    .then()
	    
	    .statusCode(200)
	    
	    .log().all();

   }

}
