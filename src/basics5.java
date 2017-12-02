import org.testng.annotations.Test;

import files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*; // for everything
//import static io.restassured.RestAssured.given; for just given method
import static org.hamcrest.Matchers.*;


public class basics5 {

	/*before given method you have to provide your baseurl
	 * given(): request headers, parameters, request cookies, body
	 * when(): get, post, put, delete
	 * then(): assertion to ensure we are getting the correct response
	 * extract(): 
	 * 
	 */
	
	@Test
	public void Test1(){
		// BaseURL or Host
	RestAssured.baseURI = "https://maps.googleapis.com" ;
	
    Response resp =	given()
		.param("location", "-33.8670522,151.1957362")
		.param("radius", "500")
		.param("key", "AIzaSyCQPLJpzk2-RJX7g8HKpY8RSx03AqZp2tI")
		.log().all()
		.when()
		.get("maps/api/place/nearbysearch/json")
		.then()
		.assertThat().statusCode(200)
		.and().contentType(ContentType.JSON)
		.and().body("results[0].name", equalTo("Sydney"))
		.and().body("results[0].place_id", equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM"))
		.and().header("server", "pablo")
		.extract().response();
       JsonPath js = ReusableMethods.rawToJson(resp);
        int count = js.get("results.size()");
        for(int i = 0; i<count; i++)
        {
        	System.out.println(js.get("results["+i+"].name"));	
    			
        }
        
		 
		System.out.println(count);
		//maps.googleapis.com/maps/api/place/radarsearch/output?parameters
		
		

	}

}
