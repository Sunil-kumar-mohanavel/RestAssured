package SchemaValidation;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.matcher.RestAssuredMatchers.*;

public class JSONShemaValidation {
	
         @Test(priority=1)
	
             void jsonschema() 
	        {
        
		
       
         given()
            
         

            .when()
                .get("http://localhost:3000/book")

            .then()
               
.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath
		("Store Json Schema.json"));
                

}
         
}
