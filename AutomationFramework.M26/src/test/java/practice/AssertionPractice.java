package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {

	
	//hard assert
	@Test
	public void sample() {
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		Assert.assertEquals(0, 1);
		
		System.out.println("Step 4");
		
		System.out.println("Step 5");
		
	}
	
	
	
	
	
	//soft assert -> we cannot trace the error in which line
	@Test
	public void sample1() {
		SoftAssert sa = new SoftAssert();
		
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		
		sa.assertEquals(0, 1); //fail
		
		System.out.println("Step 4");
		
		sa.assertTrue(false);//fail
		
		System.out.println("Step 5");
		
		sa.assertAll();//Log the Fail
	}
}
