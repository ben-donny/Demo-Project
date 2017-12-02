import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*; // for everything
//import static io.restassured.RestAssured.given; for just given method
import static org.hamcrest.Matchers.*;

public class basics6 {
	
	Properties prop=new Properties();
	@BeforeTest
	public void getData() throws IOException
	{
		
		FileInputStream fis=new FileInputStream("C:\\WorkSpace\\Demo\\src\\files\\env.properties");
		prop.load(fis);
		
		//prop.get("HOST");
	}
	@Test
	public void JiraAPICreateIssue()
	{
		//Creating Issue/Defect
		
		RestAssured.baseURI= "https://bendonny.atlassian.net" ;
	Response res = given().header("Content-Type", "application/json")
		.header("Cookie", "session=" + ReusableMethods.getSessionKEY())
		.body("{"+
			    "\"fields\": {"+
			       "\"project\":{"+
			          "\"key\": \"AP\""+
			       "},"+
			       "\"summary\": \"Issue 7 for adding comment\","+
			       "\"description\": \"Creating my second bug\","+
			       "\"issuetype\": {"+
			          "\"name\": \"Bug\""+
			       "}"+
			   "}}")
			   .when()
			   .post("/rest/api/2/issue").then().statusCode(201)
			   .extract().response();
		  
			   JsonPath js= ReusableMethods.rawToJson(res);
		      String id=js.get("id");
		      System.out.println(id);
		
				
		
		
		
		}
}
