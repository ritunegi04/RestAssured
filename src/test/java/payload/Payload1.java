package payload;

public class Payload1 {
	
	public static String getAddPlacePayload()
	{
		return "{ \r\n" + 
				"\r\n" + 
				"  \"location\": { \r\n" + 
				"\r\n" + 
				"    \"lat\": -38.383494, \r\n" + 
				"\r\n" + 
				"    \"lng\": 33.427362 \r\n" + 
				" }, \r\n" + 
				"\r\n" + 
				"  \"accuracy\": 50, \r\n" + 
				"\r\n" + 
				"  \"name\": \"Frontier Place\", \r\n" + 
				"\r\n" + 
				"  \"phone_number\": \"(+91) 983 893 3937\", \r\n" + 
				"\r\n" + 
				"  \"address\": \"29 street places\", \r\n" + 
				"\r\n" + 
				"  \"types\": [ \r\n" + 
				"\r\n" + 
				"    \"shoe park\", \r\n" + 
				"\r\n" + 
				"    \"shop\" \r\n" + 
				"\r\n" + 
				"  ], \r\n" + 
				"\r\n" + 
				"  \"website\": \"http://google.com\", \r\n" + 
				"\r\n" + 
				"  \"language\": \"French-IN\" \r\n" + 
				"\r\n" + 
				"} ";
	}
	
	public static String getAddPlacePayloadParameters(String placename,String address)
	{
		return "{ \r\n" + 
				"\r\n" + 
				"  \"location\": { \r\n" + 
				"\r\n" + 
				"    \"lat\": -38.383494, \r\n" + 
				"\r\n" + 
				"    \"lng\": 33.427362 \r\n" + 
				" }, \r\n" + 
				"\r\n" + 
				"  \"accuracy\": 50, \r\n" + 
				"\r\n" + 
				"  \"name\": \""+placename+"\", \r\n" + 
				"\r\n" + 
				"  \"phone_number\": \"(+91) 983 893 3937\", \r\n" + 
				"\r\n" + 
				"  \"address\": \""+address+"\", \r\n" + 
				"\r\n" + 
				"  \"types\": [ \r\n" + 
				"\r\n" + 
				"    \"shoe park\", \r\n" + 
				"\r\n" + 
				"    \"shop\" \r\n" + 
				"\r\n" + 
				"  ], \r\n" + 
				"\r\n" + 
				"  \"website\": \"http://google.com\", \r\n" + 
				"\r\n" + 
				"  \"language\": \"French-IN\" \r\n" + 
				"\r\n" + 
				"} ";
	}
	
	
	public static String returnCourseString()
	{
		return "{\r\n" + 
				"  \"dashboard\": {\r\n" + 
				"    \"purchaseAmount\": 910,\r\n" + 
				"    \"website\": \"rahulshettyacademy.com\"\r\n" + 
				"  },\r\n" + 
				"  \"courses\": [\r\n" + 
				"    {\r\n" + 
				"      \"title\": \"Selenium Python\",\r\n" + 
				"      \"price\": 50,\r\n" + 
				"      \"copies\": 6\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"title\": \"Cypress\",\r\n" + 
				"      \"price\": 40,\r\n" + 
				"      \"copies\": 4\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"title\": \"RPA\",\r\n" + 
				"      \"price\": 45,\r\n" + 
				"      \"copies\": 10\r\n" + 
				"    }\r\n" + 
				"  ]\r\n" + 
				"}";
	}
	}


