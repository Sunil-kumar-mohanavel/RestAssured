package APIChaining;
import static io.restassured.RestAssured.*;

import net.minidev.json.JSONObject;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;



public class CreateUser {

	@Test
	
	void createuser(ITestContext context)
	{
	
	Faker faker = new Faker();

	JSONObject data = new JSONObject();

	data.put("name", faker.name().fullName());
	data.put("gender", "Male");
	data.put("email", faker.internet().emailAddress());
	data.put("status", "inactive");

	String bearerToken = "763af209df3117d9ea1018b192f25cc3e82eaf90a1ed6892990918d1f0e85be2";

	int id = given()
			
	    .headers("Authorization", "Bearer " + bearerToken)
	    .contentType("application/json")
	    .body(data.toString())
	    
	.when()
	
	    .post("https://gorest.co.in/public/v2/users")
	    .jsonPath().getInt("id");

	System.out.println("Generated id is = " + id);
	
	
	context.setAttribute("userid", id);

   }

	
      }