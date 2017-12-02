

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import files.payLoad;
import files.resources;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class basics13 {
	
	Properties prop = new Properties();
	@BeforeTest
	public void getData() throws IOException{
		
		FileInputStream fis = new FileInputStream("C:\\WorkSpace\\Demo\\src\\files\\env.properties");
		//prop.get()
		prop.load(fis);
		
	}
	@Test
	public void AddandDeletePlace(){
		
		/*String body = "{" +
				  "\"location\": {" +
				  "\"lat\": -33.8669710," +
				    "\"lng\": 151.1958750" +
				 " }, " +
				 "\"accuracy\": 50," +
				  "\"name\": \"Google Shoes!\"," +
				  "\"phone_number\": \"(02) 9374 4000\"," +
				  "\"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\"," +
				 " \"types\": [\"shoe_store\"]," +
				  "\"website\": \"http://www.google.com.au/\"," +
				 "\"language\": \"en-AU\"" +
				"}" ;
	*/
	// Task 1 - Grab the response...
    RestAssured.baseURI = prop.getProperty("HOST");	
	//Response res 
	Response response =	given()
		.queryParam("key",prop.getProperty("KEY"))
		.body(payLoad.getPostData())
		.when()
		.post(resources.placePostData())
		.then()
		.assertThat().statusCode(200).log().all()
		.and().contentType(ContentType.JSON).and()
		.body("status", equalTo("OK"))
		.extract().response();
	
	System.out.println("The content type is: " + response.contentType());
	System.out.println("The place id is: " +response.path("place_id"));
	System.out.println("The status code is: " + response.statusCode());
	System.out.println("The response time is: " + response.getTime());
	System.out.println("The response body is: " + response.getBody());
	System.out.println("The response string is: " + response.asString());
	System.out.println("The xmlpath is: " + response.xmlPath());
	
		
		//.response();
		
	//String responsebody = res.asString();
	//System.out.println(responsebody);
	
	// Task 2- Grab the place ID from the response...
	
	//JsonPath js = new JsonPath(responsebody);
	//String placeid = js.get("place_id");
	//System.out.println(placeid);
	
	// Task 3 - place the place id in the Delete request...
	
	      /*   given()
			.queryParam("key","AIzaSyAW35xUNj5KL9Md1Y1O4vbnfiViyQdL2Uc")
			.body("{" +
			 "\"place_id\": \"" +response +"\"" + 
           //  "\"place_id\": \"" + placeid +"\"" + 
					"}")
			.when()
			.post("/maps/api/place/delete/json")
			.then()
			.assertThat().statusCode(200)
			.and().contentType(ContentType.JSON).and()
			.body("status", equalTo("OK"));*/
 
	
	}

}
