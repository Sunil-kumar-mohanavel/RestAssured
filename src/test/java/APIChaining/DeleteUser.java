package APIChaining;
import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class DeleteUser {

	
	@Test
	void deleteUser(ITestContext context) 
	{
	    String bearerToken = "763af209df3117d9ea1018b192f25cc3e82eaf90a1ed6892990918d1f0e85be2";

	    //int id = (int) context.getAttribute("userid");

	    int id = (int) context.getSuite().getAttribute("userid"); // SUITE level 
	    
	    given()
	    
	        .headers("Authorization", "Bearer " + bearerToken)
	        .pathParam("id", id)
	        
	    .when()
	    
	        .delete("https://gorest.co.in/public/v2/users/{id}")
	        
	        
	    .then()
	    
	        .statusCode(204)
	        .log().all();
	}

}
