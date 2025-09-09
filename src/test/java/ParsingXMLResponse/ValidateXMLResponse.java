package ParsingXMLResponse;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;



import static io.restassured.matcher.RestAssuredMatchers.*;

public class ValidateXMLResponse {
	
	/*@Test(priority=1)
	
    void testXML() 
	{
        
		// Approach - 1 
       
         given()
            
         

            .when()
                .get("http://restapi.adequateshop.com/api/Traveler?page=1")

            .then()
                .statusCode(200)
                
                .header("ContentType", "application/XML")
                
                .body("TravelerinformationResponse.page", equalTo(1))
                
                
    .body("TravelerinformationResponse.travlers.trvelerinformation[0].name"
    		,equalTo("restassured");
                
                
    		
    		// Approach - 2
    		
    		
    	Response res = 	given()
    		
    		.when()
    		
    		 .get("http://restapi.adequateshop.com/api/Traveler?page=1");
    		
    		Assert.assertEquals( res.getStatusCode(), 200);
		 
		Assert.assertEquals( res.header("Content-Type"), "application/XML");
		
		String pageno = res.xmlPath().get("TravelerinformationResponse.page").toString();
	 
	 Assert.assertEquals(pageno, "1");
	 
	 
String name = res.xmlPath().get("TravelerinformationResponse.travlers.trvelerinformation[0].name").toString();
	 
	 Assert.assertEquals(name, "restassured");
	     		
            
                
	}  */
	
	 
	            // Approach - 3
	
	
	@Test
	void testXMLResponseBody()
	{
	    Response res = given()

	    .when()
	        .get("http://restapi.adequateshop.com/api/Traveler?page=1");

	    XmlPath xml = new XmlPath(res.asString());

	    // Verify total number of travelers
	    
	    List<String> travelers = xml.getList("TravelerinformationResponse.travelers.Travelerinformation");
	    Assert.assertEquals(travelers.size(), 10);

	    // verify traveler name is present in response
	    
	    List<String> traveler_names = xml.getList("TravelerinformationResponse.travelers.Travelerinformation.name");

	    boolean status = false;
	    
	    
	    
	    for (String travelername : traveler_names)
	    {
	        if(travelername.equals("restassured")) 
	        
	        {
	            status = true;
	            break;
	        }
	    }
	    Assert.assertEquals(status, true);
	}

	

}
