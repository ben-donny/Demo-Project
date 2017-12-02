package files;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ReusableMethods {

	
	public static XmlPath rawToXml(Response r){
		
		String respon = r.asString();
		XmlPath x = new XmlPath(respon);
		return x;
		
		
	}
	
	
	public static JsonPath rawToJson(Response r){
		
		String respon = r.asString();
		JsonPath x = new JsonPath(respon);
		return x;
		
		
	}
	
	public static String getSessionKEY(){
		
		RestAssured.baseURI= "https://bendonny.atlassian.net" ;
		Response res=given().header("Content-Type", "application/json")
		.body("{ \"username\": \"bben7196@gmail.com\", \"password\": \"welcome1\" }")
		.when()
		.post("/rest/auth/1/session")
		.then().statusCode(200)
		.extract().response();
		
		  JsonPath js= ReusableMethods.rawToJson(res);
		   String sessionid =js.get(" session.value");
		   System.out.println(sessionid);
		   
		   return sessionid;
		
	}
	

}
