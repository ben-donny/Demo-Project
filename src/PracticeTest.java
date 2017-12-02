import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PracticeTest {

	
	@Test
    public void makeSureThatGoogleIsUp() {
        given().when().get("https://www.bbc.co.uk/").then().statusCode(200);
    }
}
