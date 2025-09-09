package SchemaValidation;
import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;


import static io.restassured.RestAssured.*;

public class XMLSchemaValidation {
	
	 @Test(priority=1)
		
     void XMLschema() 
    {



        given()
    

              .when()
              
        .get("http://restapi.adequateshop.com/apiTraveler")

              .then()
       
         .assertThat().body(RestAssuredMatchers.matchesXsdInClasspath
           ("xml Schema.xsd"));
        

}

}
