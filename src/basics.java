import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*; // for everything
//import static io.restassured.RestAssured.given; for just given method
import static org.hamcrest.Matchers.*;


public class basics {

	/*before given method you have to provide your baseurl
	 * given(): request headers, parameters, request cookies, body
	 * when(): get, post, put, delete
	 * then(): assertion to ensure we are getting the correct response
	 * extract(): 
	 * 
	 */
	
	@Test
	public void Test1(){
		
		RestAssured.baseURI = "https://maps.googleapis.com" ;
		given()
		.param("location", "-33.8670522,151.1957362")
		.param("radius", "500")
		.param("key", "AIzaSyCQPLJpzk2-RJX7g8HKpY8RSx03AqZp2tI")
		//.log().all()
		.when()
	    .get("maps/api/place/nearbysearch/json")
		.then()
		.assertThat().statusCode(200)
		.and().contentType(ContentType.JSON)
		.and().body("results[0].name", equalTo("Sydney"), "results[0].place_id", equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM"))
		//.and().body("results[0].place_id", equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM"))
		.and().header("server", "pablo");
		
		 
		
		//maps.googleapis.com/maps/api/place/radarsearch/output?parameters

	}
	
}
