package ParsingResponseData;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.matcher.RestAssuredMatchers.*;
public class ResponseDataValidate {
	
	
	//@Test(priority=1)
    void testJson() 
	{
        
		// Approach - 1 
       
         given()
            
         .contentType("ContentType.JSON")

            .when()
                .get("http://localhost:3000/book")

            .then()
                .statusCode(200)
                .body("[0].title",equalTo("Sayings of the Century")); 
                
	} 
	
	
	//@Test (priority=2)
    void testJsonresponse() 
	{
		
		// Approach -2 
		
		
		 Response res = given()
				 
				 .contentType("ContentType.JSON")
				 
				 .when()
				 
				 .get("http://localhost:3000/book");
				 
			Assert.assertEquals( res.getStatusCode(), 200);
		 
			Assert.assertEquals( res.header("Content-Type"), "application/json");
			
			String s1 = res.jsonPath().get("[0].title").toString();
		 
		 Assert.assertEquals(s1, "Sayings of the Century");
		 
                 
            
    }
	
	
	
	 
	@Test (priority=3)
    void testJsonObject() 
	{
		
		// Approach - 3 - JSON Object Class 
		
		
		 Response res = given()
				 
				 .contentType("ContentType.JSON")
				 
				 .when()
				 
				 .get("http://localhost:3000/book");
				 
			// convert response to JSON object type
		 
		 JSONObject jo = new JSONObject(res.toString());
		 
		 // print all the books title
		 
		 
	/*	 for(int i=0; i<jo.getJSONArray("book").length(); i++)
		 {
			 
	String BooksTitle = jo.getJSONArray("book").getJSONObject(i).get("title").toString();
	
	System.out.println(BooksTitle);
		 }  */
		 
		 
		 // search for the title of the book - validation -1 
                 
            boolean status = false;
            
            for(int i=0; i<jo.getJSONArray("book").length(); i++)
   		 {
            	
String BooksTitle = jo.getJSONArray("book").getJSONObject(i).get("title").toString();

  if(BooksTitle.equals("Sayings of the Century"))
  {
	  status = true;
	  break;
  }

   		 
            
            Assert.assertEquals(status,true);
   		 
    }

       
	
	   // validate total price of the books - validation -2 
	
	
            double totalprice =0;
            
	  for(int i=0; i<jo.getJSONArray("book").length(); i++)
		 {
         	
String price = jo.getJSONArray("book").getJSONObject(i).get("price").toString();


	   totalprice = totalprice+Double.parseDouble(price);
		 }
	
	System.out.println("total price of books is = " +totalprice);
	
	Assert.assertEquals(totalprice, 53.92);
	}

}
