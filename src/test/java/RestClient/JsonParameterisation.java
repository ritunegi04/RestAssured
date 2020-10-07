package RestClient;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import payload.Payload1;

public class JsonParameterisation {

	@Test(dataProvider="AddPlaceDP")
	public void addPlace(String placeName,String address)
	{
		RestAssured.baseURI="https://rahulshettyacademy.com";
		RestAssured.given().queryParam("key", "qaclick123").header("Content-Type", "application/json").queryParam("key","qaclick123" )
		.body(Payload1.getAddPlacePayloadParameters(placeName,address))
		.when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200);
	}
	
	@Test
	public void staticJsonTest() throws IOException
	{
		RestAssured.baseURI="https://rahulshettyacademy.com";
		RestAssured.given().queryParam("key", "qaclick123").header("Content-Type", "application/json").queryParam("key","qaclick123" )
		.body(new String(Files.readAllBytes(Paths.get("C:\\Users\\Bliss\\Desktop\\docs\\important docs\\REST Assured and Rest Api\\AddPlaceJson.json"))))
		.when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200);
		
	}
	
	@DataProvider(name="AddPlaceDP")
	public Object[][] getAddPlaceData()
	{
		return new Object[][] {{"TestPlace1","Street Name 1"},{"TestPlace2","Street Name 2"},{"TestPlace3","Street Name 3"}};
	}
	
	
}
