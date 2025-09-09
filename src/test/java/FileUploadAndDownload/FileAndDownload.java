package FileUploadAndDownload;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.annotations.Test;

import static io.restassured.matcher.RestAssuredMatchers.*;

public class FileAndDownload {

	
	
	
    //@Test(priority=1)
	
    void singlefileupload() 
	{
        File filepath = new File("path of the file"); 
        
        
         given()
         
         .multiPart("file", filepath )
         .contentType("multipart/form-data")
            
         

            .when()
                .get("https://localhost8080/uploadfile")

            .then()
                .statusCode(200)
                .body("filename", equalTo("file.txt"))
                
                .log().all();
                
}
    
    
         @Test(priority=2)
	
          void multiplefileupload() 
	{
        File filepath1 = new File("path of the file - 1"); 
        
        File filepath2 = new File("path of the file - 2"); 
        
         given()
         
         .multiPart("files", filepath1)
         .multiPart("files", filepath2)
         .contentType("multipart/form-data")
            
         

            .when()
                .get("https://localhost8080/uploadMultipleFile")

            .then()
                .statusCode(200)
                .body("[0].filename", equalTo("file1.txt"))
                .body("[1].filename", equalTo("file2.txt"))
                .log().all();
                
}
         
         
         
         @Test(priority=3)
     	
         void multiplefileupload2() 
	{
       File filepath1 = new File("path of the file - 1"); 
       
       File filepath2 = new File("path of the file - 2"); 
       
       File filearr[]= {filepath1,filepath2};
       
        given()
        
        .multiPart("files", filearr)
        
        .contentType("multipart/form-data")
           
        

           .when()
               .get("https://localhost8080/uploadMultipleFile")

           .then()
               .statusCode(200)
               .body("[0].filename", equalTo("file1.txt"))
               .body("[1].filename", equalTo("file2.txt"))
               .log().all();
               
}
         
         @Test
     	
         void filedownload() 
	{
       
       
        given()
        
        

           .when()
               .get("https://localhost8080/DownloadFile/file.txt")

           .then()
               .statusCode(200)
               
               .log().all();
               
}

}