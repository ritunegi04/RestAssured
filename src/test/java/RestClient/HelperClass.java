package RestClient;

import io.restassured.path.json.JsonPath;

public class HelperClass {
	public static JsonPath convertStringToJson(String str)
	{
		JsonPath jpath=new JsonPath(str);
		return jpath;
	}
}
