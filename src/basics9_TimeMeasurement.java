import static io.restassured.matcher.ResponseAwareMatcherComposer.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;

public class basics9_TimeMeasurement {
	
	/***
	 response time measurement
	 please note time include HTTP round trip = rest assured processing time
	 by default rest assured return time is in milliseconds 
	*/

	
	@Test
	public void testResponseTime(){

		long t = given().get("http://jsonplaceholder.typicode.com/photos").time();
		System.out.println("Time(ms): " + t);
		}
	
	@Test
	public void testResponseTimeInUnit(){

		//long t = given().get("http://jsonplaceholder.typicode.com/photos").timeIn(TimeUnit.MILLISECONDS);
		long t = given().get("http://jsonplaceholder.typicode.com/photos").timeIn(TimeUnit.SECONDS);
		System.out.println("Time(ms): " + t);
		}
	
	@Test
	public void testResponseTimeAssertion(){
		
		given().get("http://jsonplaceholder.typicode.com/photos").then().time(lessThan(500L));
		
		}

}
