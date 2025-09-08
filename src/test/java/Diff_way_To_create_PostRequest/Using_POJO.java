package Diff_way_To_create_PostRequest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;



import org.testng.annotations.Test;

public class Using_POJO {

    // 3. POJO
    
    @Test(priority = 1)
    void usingPOJO() {
        
       Data_For_POJO data = new Data_For_POJO();
       
       data.setName("james");
       data.setLocation("germany");
       data.setPhone("12345");
        
        String coursearr[] = { "c", "c++" };
       
        data.setCourses(coursearr);

         given()
                .contentType("application/json")
                .body(data)

            .when()
                .post("http://localhost:3000/students")

            .then()
                .statusCode(201)
                .body("name", equalTo("james"))
                .body("location", equalTo("germany"))
                .body("phone", equalTo("12345"))
                .body("courses[0]", equalTo("c"))
                .body("courses[1]", equalTo("c++"))
                 .log().all();
            
    }

    @Test(priority = 2)
    void del() {
        given()

        .when()
            .delete("http://localhost:3000/students/b33c")

        .then()
            .statusCode(200)
            .log().all();
    }

}
