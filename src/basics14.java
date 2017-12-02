
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.path.json.JsonPath.*; // useful for using the from keyword


import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.testng.annotations.Test;

import files.payLoad;
import files.resources;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class basics14 {
	
	Properties prop = new Properties();
	//@BeforeTest
	public void getData() throws IOException{
		
		FileInputStream fis = new FileInputStream("C:\\WorkSpace\\Demo\\src\\files\\env.properties");
		//prop.get()
		prop.load(fis);
		
	}
	//@Test
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
	String res =	given()
		.queryParam("key",prop.getProperty("KEY"))
		.body(payLoad.getPostData())
		.when()
		.post(resources.placePostData())
		.then()
	    .assertThat().statusCode(200).log().all()
	   .and().contentType(ContentType.JSON).and()
	    .body("status", equalTo("OK"))
		 .extract().path("place_id");
	   System.out.println(res);
	

	
		
		//.response();
		
	//String responsebody = res.asString();
	//System.out.println(responsebody);
	
	// Task 2- Grab the place ID from the response...
	
	//JsonPath js = new JsonPath(responsebody);
	//String placeid = js.get("place_id");
	//System.out.println(placeid);
	
	// Task 3 - place the place id in the Delete request...
	
	         given()
			.queryParam("key","AIzaSyAW35xUNj5KL9Md1Y1O4vbnfiViyQdL2Uc")
			.body("{" +
			 "\"place_id\": \"" +res +"\"" + 
           //  "\"place_id\": \"" + placeid +"\"" + 
					"}")
			.when()
			.post("/maps/api/place/delete/json")
			.then()
			.assertThat().statusCode(200)
			.and().contentType(ContentType.JSON).and()
			.body("status", equalTo("OK"));
	}
    
	/*
	 * Extract details as String and fetching further details w/o using Json path
	 */
	
	//@Test
	 public void testjsonpath1(){
		String responseAsString = given().when()
		 .get("http://jsonplaceholder.typicode.com/photos")
		 .then().extract().asString();
		
		List<Integer> albumIds = from(responseAsString).get("id");
		System.out.println(albumIds.size());
	 }
	
	/*
	 * Extract details as String and fetching further details using Json path
	 */
	
	@Test
	 public void testjsonpath2(){
			String json = given().when()
			 .get("http://services.groupkt.com/country/get/all")
			 .then().extract().asString();
			
			JsonPath jsonPath = new JsonPath(json).setRoot("RestResponse.result");
			    List<String> list = jsonPath.get("name");
			    System.out.println(list.size());
			
		 }
	 /*
	 public void testconcept(){
		 
		
		 List<String> ls = from(response).getList("RestResponse.result.name");
		 System.out.println("ListSize: " + ls.size());
		 for(String country : ls ){
		 if(Country.equals("Solomon Islands")
		 System.out.println("Found my place");
		 }
		 
	 }
	 */
	 
	@Test
	public void testCookies(){
		Response response = given().when().get("http://jsonplaceholder.typicode.com/photos");
		Map<String, String> cookies = response.getCookies();

		for(Map.Entry<String, String> entry : cookies.entrySet()){
		System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		}
	
	@Test
	public void testdetailCookies(){
		Response response = given().when().get("http://jsonplaceholder.typicode.com/photos");
		Cookie a = response.getDetailedCookie("--cfduid");

       System.out.println("Detailed: " + a.hasExpiryDate());
       System.out.println("Detailed: " + a.getExpiryDate());
       System.out.println("Detailed: " + a.getValue());
       System.out.println("Detailed: " + a.hasValue());
		
		}
	
	@Test
	  public void testConnectRequest(){
		given().when().request("CONNECT", "https://api.fonts.com/rest/json/Accounts/").then().statusCode(400);
		
		}
	
	@Test
	public void testSetMultiCookiesInRequest(){
		given().cookies("key", "value1", "value2");

		//to set detailed cookie
		Cookie cookie = new Cookie.Builder("some_cookie", "some_value").setSecured(true).setComment("some comment").build();
		given().cookie(cookie).when().get("/cookie").then().assertThat().body(equalTo("x"));

		// set multiple cookies
		Cookie cookie1 = new Cookie.Builder("some_cookie", "some_value").setSecured(true).setComment("some comment").build();
		Cookie cookie2 = new Cookie.Builder("some_cookie", "some_value").setSecured(true).setComment("some comment").build();
		Cookies cookies = new Cookies(cookie1, cookie2);
		given().cookie(cookie).when().get("/cookie").then().assertThat().body(equalTo("x"));
		}
	
	/*
	 * body test verification
	 */
	@Test
	public void testbodyInResponse(){
		String responseString = get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/02/*").asString();
		given().get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/02/*").then().assertThat().body(equalTo(responseString));
		
	}

	@Test
	public void lambdaexp(){
		given().get("http://jsonplaceholder.typicode.com/photos/1").then()
		.body("thumbmailUrl", response -> equalTo("http://placehold.it/150/92c952"));
	}
	
} 
