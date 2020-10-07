package RestClient;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

public class JiraAPIs {
	
	@Test
	public void addCommentAPI()
	
	{
		RestAssured.baseURI="http://localhost:8080";
		SessionFilter session=new SessionFilter();
		String response=RestAssured.given().header("Content-Type", "application/json").body("{ \"username\": \"Ritu04\", \"password\": \"Passutir@20\" }")
		.filter(session)
				.when().post("rest/auth/1/session").then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath jpath=HelperClass.convertStringToJson(response);
		String sessionId=jpath.getString("session.value");
		System.out.println(sessionId);
		
		RestAssured.given().header("Content-Type", "application/json").body("{\r\n" + 
				"    \"body\": \"new comment\",\r\n" + 
				"    \"visibility\": {\r\n" + 
				"        \"type\": \"role\",\r\n" + 
				"        \"value\": \"Administrators\"\r\n" + 
				"    }\r\n" + 
				"}").
		pathParam("key", "10001")
		.filter(session)
		.when().post("rest/api/2/issue/{key}/comment").then().assertThat().statusCode(201);
		
		//Add Attachment API
		
		RestAssured.given().header("Content-Type", "multipart/form-data").header("X-Atlassian-Token","no-check")
		.multiPart("file",new File("C:\\Users\\Bliss\\Desktop\\docs\\important docs\\REST Assured and Rest Api\\Info.txt")).
		pathParam("key", "10001")
		.filter(session)
		.when().post("/rest/api/2/issue/{key}/attachments").then().assertThat().statusCode(200);
		
		
		//GET API
		
		RestAssured.given().header("Content-Type", "application/json").
		pathParam("key", "10001")
		.filter(session).queryParam("fields", "comment")
		.when().get("/rest/api/2/issue/{key}").then().log().all().assertThat().statusCode(200);
		
	}

}
