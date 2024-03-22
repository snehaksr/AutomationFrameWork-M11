package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {
	
	@Test
	
	public void hardAssert()
	{
		String s= "hi";
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		System.out.println("Step 4");
		
		//Assert.assertTrue(s.contains("i"));
		
		Assert.assertEquals(1, 1);
				
		System.out.println("Step 5");
		System.out.println("Step 6");
		
	}
	
	@Test
	
	public void softAssert()
	{
		SoftAssert sa = new SoftAssert();
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		
		sa.assertEquals(1, 2);
		
		sa.assertAll();// assertAll should declare end of the program. It will thought it as end of the program if we declare assertall
		//if assertAll not declare it wont show fail even if the Test step fails
		System.out.println("Step 4");
		System.out.println("Step 5");
		System.out.println("Step 6");
		
		
	}
	
}
