package Diff_way_To_create_PostRequest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


import java.util.HashMap;

import org.testng.annotations.Test;

import static io.restassured.matcher.RestAssuredMatchers.*;



public class Using_Hashmap {
   

    // 1. HashMap
    
    @Test(priority = 1)
    void usingHashMap() {
        
        HashMap<String, Object> data = new HashMap<>();
        data.put("name", "jim");
        data.put("location", "france");
        data.put("phone", "12345");

        String coursearr[] = { "c", "c++" };
        data.put("courses", coursearr);

         given()
                .contentType("application/json")
                .body(data)

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
    void delHashMap() {
        given()

        .when()
            .delete("http://localhost:3000/students/688e")

        .then()
            .statusCode(200)
            .log().all();
    }
}
