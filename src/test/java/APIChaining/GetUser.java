package APIChaining;
import static io.restassured.RestAssured.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetUser {

	
	
	
	@Test
	void getUser(ITestContext context) 
	
	
	
	{
	   // int id = (int) context.getAttribute("userid"); // TEST level
		
		int id = (int) context.getSuite().getAttribute("userid"); // SUITE level 
	    
String bearerToken = "763af209df3117d9ea1018b192f25cc3e82eaf90a1ed6892990918d1f0e85be2";

	    given()
	    
	        .headers("Authorization", "Bearer " + bearerToken)
	        .pathParam("id", id)
	        
	    .when()
	    
	        .get("https://gorest.co.in/public/v2/users/{id}")
	        
	    .then()
	    
	        .statusCode(200)
	        .log().all();
	}

}
