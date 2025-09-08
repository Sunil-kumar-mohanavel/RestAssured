package Diff_way_To_create_PostRequest;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import net.minidev.json.JSONObject;
import static io.restassured.matcher.RestAssuredMatchers.*;

public class Using_Org_Json {
	
	

    // 2. Org.Json
    
    @Test(priority = 1)
    void usingOrgJson() {
        
    	JSONObject data = new JSONObject();
    	
        
        data.put("name", "jim");
        data.put("location", "france");
        data.put("phone", "12345");

        String coursearr[] = { "c", "c++" };
        data.put("courses", coursearr);

         given()
                .contentType("application/json")
                .body(data.toString())

            .when()
                .post("http://localhost:3000/students")

            .then()
                .statusCode(201)
                .body("name", equalTo("jim"))
                .body("location", equalTo("france"))
                .body("phone", equalTo("12345"))
                .body("courses[0]", equalTo("c"))
                .body("courses[1]", equalTo("c++"))
                .log().all();
             
                
    }

    @Test(priority = 2)
    void del() {
        given()

        .when()
            .delete("http://localhost:3000/students/5c62")

        .then()
            .statusCode(200)
            .log().all();
    }

}
