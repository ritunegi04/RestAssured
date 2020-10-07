package RestClient;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import payload.Payload1;

import org.hamcrest.Matchers;
import org.testng.Assert;

public class RestAssuredExample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Given -Input parameters
		//When - Request sent
		//then-validation
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		
		/*
		 * RestAssured.given().log().all().header("Content-Type",
		 * "application/json").queryParam("key ","qaclick123") .body("{ \r\n" + "\r\n" +
		 * "  \"location\": { \r\n" + "\r\n" + "    \"lat\": -38.383494, \r\n" + "\r\n"
		 * + "    \"lng\": 33.427362 \r\n" + "\r\n" + "  }, \r\n" + "\r\n" +
		 * "  \"accuracy\": 50, \r\n" + "\r\n" + "  \"name\": \"Frontline house\", \r\n"
		 * + "\r\n" + "  \"phone_number\": \"(+91) 983 893 3937\", \r\n" + "\r\n" +
		 * "  \"address\": \"29, side layout, cohen 09\", \r\n" + "\r\n" +
		 * "  \"types\": [ \r\n" + "\r\n" + "    \"shoe park\", \r\n" + "\r\n" +
		 * "    \"shop\" \r\n" + "\r\n" + "  ], \r\n" + "\r\n" +
		 * "  \"website\": \"http://google.com\", \r\n" + "\r\n" +
		 * "  \"language\": \"French-IN\" \r\n" + "\r\n" + "} ")
		 * .when().post("/maps/api/place/add/json")
		 * .then().log().all().assertThat().statusCode(200)
		 * .body("scope",Matchers.equalTo( "APP")) .header("Server",
		 * "Apache/2.4.18 (Ubuntu)");
		 * 
		 */
		
		//Passing json request body via java method
		
		String response=RestAssured.given().log().all().header("Content-Type", "application/json").queryParam("key ","qaclick123")
		.body(Payload1.getAddPlacePayload())
		.when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200)
		.body("scope",Matchers.equalTo( "APP"))
		.header("Server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
		
		//to parse json
		JsonPath jpath=HelperClass.convertStringToJson(response);
		String placeid=jpath.getString("place_id");
		//System.out.println(placeid);
		
		//Put API to update address as per the placeid
		RestAssured.given().log().all().header("Content-Type", "application/json").queryParam("key","qaclick123" )
		.body("{ \r\n" + 
				"\r\n" + 
				"\"place_id\":\""+placeid+"\", \r\n" + 
				"\r\n" + 
				"\"address\":\"70 Summer walk, USA\", \r\n" + 
				"\r\n" + 
				"\"key\":\"qaclick123\" \r\n" + 
				"\r\n" + 
				"} ")
		.when().put("/maps/api/place/update/json ")
		.then().log().all().assertThat().statusCode(200).body("msg", Matchers.equalTo("Address successfully updated"));
		
		
		//GET Place API to check the change
		String newAddress="70 Summer walk, USA";
	String response1=RestAssured.given().log().all().queryParam("place_id",placeid ).queryParam("key","qaclick123" )
		.when().get("/maps/api/place/get/json")
		.then().log().all().assertThat().statusCode(200).body("address",Matchers.equalTo("70 Summer walk, USA")).extract().response().asString();
	JsonPath jpath1=HelperClass.convertStringToJson(response1);
	String actualAddress=jpath1.getString("address");
	Assert.assertEquals(newAddress, actualAddress);
		
		
	}

}
