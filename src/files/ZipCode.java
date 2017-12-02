package files;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.beust.testng.TestNG;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ZipCode{
	
	@DataProvider(name = "zipcodes")
	public String[][] createZipCodeTestData() {
	        
	  return new String[][] {
	    {"us","90210","Beverly Hills"},
	    {"us","12345","Schenectady"}
	  };
	}
	
	@Test(dataProvider = "zipcodes")
	public void aZipCodeTest(String country, String zipcode, String city) {
	        
	  given().
	    pathParam("country",country).
	    pathParam("zipcode",zipcode).
	  when().
	    get("http://api.zippopotam.us/{country}/{zipcode}").
	  then().
	    assertThat().
	    body("places.'place name'[0]",equalTo(city));
	}
	
	//Stand alone test without using data provider
	/*@Test
	public void checkHeaderData() {
	        
	  given().
	    pathParam("country","us").
	    pathParam("zipcode","90210").
	  when().
	    get("http://api.zippopotam.us/{country}/{zipcode}").
	  then().
	    assertThat().
	    statusCode(200).
	  and().
	    contentType(ContentType.JSON);
	}*/
	
	//authentication test
	@Test
	public void checkBasicAuthentication() {

	  given().
	    auth().
	    preemptive().
	    basic("username","password").
	  when().
	    get("http://mysecureapi.com/basicauth").
	  then().
	    assertThat().
	    body("authentication_result",equalTo("Success"));
	}
}
