import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import org.testng.annotations.Test;


public class basics4 {
	
	@Test
	public void postDate() throws IOException{
		String postdata = GenerateStringFromResource("C:\\WorkSpace\\Demo\\postdata.xml");
		RestAssured.baseURI = "https://maps.googleapis.com";
		
		Response res = given()
		// where u have ? they are query parameter...		
		.queryParam("key","AIzaSyCQPLJpzk2-RJX7g8HKpY8RSx03AqZp2tI")
		.body(postdata)
	.when()
	.post("/maps/api/place/add/xml")
	.then()
	.assertThat().statusCode(200)
	.and().contentType(ContentType.XML)
	.extract().response();
		
		XmlPath x = ReusableMethods.rawToXml(res);
	    System.out.println(x.get("PlaceAddResponse.place_id"));
		
		// to get response and handle it...
		//String respon = res.asString();
	//	System.out.println(respon);

	//	XmlPath x = new XmlPath(respon);
		// String placeresponse = x.get("PlaceAddResponse.place_id");
		 //System.out.println(placeresponse);
		// System.out.println(x.get("PlaceAddResponse.place_id"));
		
		// create a place response(place id)
		// delete place = (Request - place id)
	
	}
	
	public static String GenerateStringFromResource(String path)throws IOException{
		
		return new String(Files.readAllBytes(Paths.get(path)));
		
		
	}
	
}



