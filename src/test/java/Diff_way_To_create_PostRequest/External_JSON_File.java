package Diff_way_To_create_PostRequest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static io.restassured.matcher.RestAssuredMatchers.*;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class External_JSON_File {
	
    // 4 . External JSON File
    
    @Test(priority = 1)
    void usingJSONFile() throws FileNotFoundException {
        
       
    File file = new File(".\\External.json");
    
    FileReader fr = new FileReader(file);
    
    JSONTokener jt = new JSONTokener(fr);
    
    JSONObject data = new JSONObject(jt); 
    
    
    
    

         given()
                .contentType("application/json")
                .body(data.toString())

            .when()
                .post("http://localhost:3000/students")

            .then()
                .statusCode(201)
                .body("name", equalTo("john"))
                .body("location", equalTo("mexcio"))
                .body("phone", equalTo("12345"))
                .body("courses[0]", equalTo("c"))
                .body("courses[1]", equalTo("c++"))
                 .log().all();
            
    }

   @Test(priority = 2)
    void del() {
        given()

        .when()
            .delete("http://localhost:3000/students/4652")

        .then()
            .statusCode(200)
            .log().all();
    }

}
