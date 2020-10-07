package RestClient;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;
import payload.Payload1;

public class CourseAPITest {
	
	public static void main(String[] arg)
	{
		//parsing nested json
		
		JsonPath jpath=new JsonPath(Payload1.returnCourseString());
		
		//return number of courses
		int noOfCourses=jpath.getInt("courses.size()");
		System.out.println(noOfCourses);
		
		//get purchaseAmount
		int purchaseAmount=jpath.getInt("dashboard.purchaseAmount");
		System.out.println(purchaseAmount);
		
		//get Title of first course
		String firstCourseTitle=jpath.getString("courses[0].title");
		System.out.println(firstCourseTitle);
		
		//get all course title and their respective prices
		for (int i=0;i<noOfCourses;i++)
		{
			String courseTitle=jpath.getString("courses["+i+"].title");
			int coursePrice=jpath.getInt("courses["+i+"].price");
			System.out.println(courseTitle + " "+coursePrice );
			
		}
		
		//Check that sum of purchaseAmount for each course is equal to total purchase amount
		
		int totalpurchaseAmount=0;
		for (int i=0;i<noOfCourses;i++)
		{
			int courseCopies=jpath.get("courses["+i+"].copies");
			int coursePrice=jpath.getInt("courses["+i+"].price");
			totalpurchaseAmount=totalpurchaseAmount+(courseCopies*coursePrice);
		}
		Assert.assertEquals(totalpurchaseAmount,purchaseAmount);
		}
		
	}


