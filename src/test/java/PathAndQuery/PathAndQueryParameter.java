package PathAndQuery;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;


public class PathAndQueryParameter {

	
	@Test
    void pathquery() 
	{
        
       
         given()
            .pathParam("path", "users")
            .queryParam("page", 2)
                .queryParam("id", 5)

            .when()
                .get("https://reqres.in/api/{path}")

            .then()
                .statusCode(200)
                
                 .log().all();
            
    }

}
