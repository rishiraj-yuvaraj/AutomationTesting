package inventoryTests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.RetryAnalyserImplementation;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;

@Listeners(genericUtilities.ListenersImplementation.class)
public class AddLowestPriceProductToCartTest extends BaseClass {

	@Test(groups={"SmokeSuite","RegressionSuite"})
	public void AddLowestPriceProductToCartTest() throws Throwable {
		//Read Test Data from Excel
		String SORTOPTION = fUtil.readDataFromExcel("Sheet1", 4,2);
		String PRODUCTNAME = fUtil.readDataFromExcel("Sheet1", 4,3);

		InventoryPage ip=new InventoryPage(driver);
		String pAddedToCart = ip.clickOnLowestPriceProduct(driver, PRODUCTNAME, SORTOPTION);

		InventoryItemPage iip = new InventoryItemPage(driver);
		iip.clickOnAddToCart();

		ip.clickOnCartContainer();

		CartPage cp = new CartPage(driver);
		String pInCart = cp.getproductName();

		//Assertion
		Assert.assertEquals(pInCart, pAddedToCart);
		//Assert.assertTrue(pInCart.equals(pInCart)); we can use either line 38 or 39
		System.out.println(pInCart);
	}
	
	@Test(retryAnalyzer = genericUtilities.RetryAnalyserImplementation.class)
	public void sample() {
		//Assert.fail();
		System.out.println("This should not get printed");
	}
}
