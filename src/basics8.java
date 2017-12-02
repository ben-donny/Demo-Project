import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class basics8 {

	Properties prop=new Properties();
	@BeforeTest
	public void getData() throws IOException
	{
		
		FileInputStream fis=new FileInputStream("C:\\WorkSpace\\Demo\\src\\files\\env.properties");
		prop.load(fis);
		
		//prop.get("HOST");
	}
	@Test
	public void JiraAPICreateComment()
	{
		//Creating Issue/Defect
		
		RestAssured.baseURI= "https://bendonny.atlassian.net";
		
		Response res = given().header("Content-Type", "application/json").
		header("Cookie","JSESSIONID="+ReusableMethods.getSessionKEY()).
		pathParams("commentid", "10103")
		.body("{ \"body\": \"Inserting comment from the automation code\","+
    "\"visibility\": {"+
        "\"type\": \"role\","+
        "\"value\": \"Administrators\" }"+
"}").when().
		put("/rest/api/2/issue/10207/comment/{commentid}").then().statusCode(200).extract().response();
		   JsonPath js= ReusableMethods.rawToJson(res);
		   String id=js.get("id");
		   System.out.println(id);
		
			
		}
}


