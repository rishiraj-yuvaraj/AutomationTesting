package inventoryTests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.FileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;
import objectRepository.LoginPage;

@Listeners(genericUtilities.ListenersImplementation.class)
public class AddProductToCartTest extends BaseClass{

	@Test(groups={"SmokeSuite","RegressionSuite"})
	public void tc_001_AddProductToCartTest() throws Throwable 
	{
		//Read Test Data from Excel
		String PRODUCTNAME = fUtil.readDataFromExcel("Sheet1", 1, 2);
	
		InventoryPage ip=new InventoryPage(driver);
		String pAddedToCart = ip.clickOnAProduct(driver, PRODUCTNAME);
		
		InventoryItemPage iip = new InventoryItemPage(driver);
		iip.clickOnAddToCart();
		
		ip.clickOnCartContainer();
		
		CartPage cp = new CartPage(driver);
		String pInCart = cp.getproductName();
		
		Assert.assertEquals(pInCart, pAddedToCart);
		//Assert.assertTrue(pInCart.equals(pInCart)); we can use either line 38 or 39
		
//		if(pInCart.equals(pAddedToCart)) {
//			System.out.println("Test Case Pass");
//			System.out.println(pInCart);
//		}else {
//			System.out.println("Test Case Fail");
//		}
		
		//@Test - priority, invocation count, enabled = false, dependsOnMethods data provider
		
	}
}
