package CookiesAndHeader;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;



import org.testng.annotations.Test;



import static io.restassured.matcher.RestAssuredMatchers.*;
public class LoggingData {
	
	
	
	@Test
	
	void loggingdata()
	{
		
		given()
		
		.when()
		
		.get("https://www.google.com/")
		
		.then()
		
		//.log().all()
		
		//.log().cookies()
		
		//.log().body();
		
		.log().headers();
		
	}
     
}
