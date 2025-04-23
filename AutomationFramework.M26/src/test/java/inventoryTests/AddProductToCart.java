package inventoryTests;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtilities.FileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;
import objectRepository.LoginPage;

public class AddProductToCart {

public static void main(String[] args) throws Throwable {
		
		//Create Object of All required Utiltity classes
		FileUtility fUtil = new FileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		JavaUtility jUtil = new JavaUtility();
		
		//Read Common Data from property file
		String URL = fUtil.readDataFromPropertyFile("url");
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		
		//Read Test Data from Excel
		String PRODUCTNAME = fUtil.readDataFromExcel("Sheet1", 1, 2);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get(URL);

		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp(USERNAME, PASSWORD);
		
		InventoryPage ip=new InventoryPage(driver);
		String pAddedToCart = ip.clickOnAProduct(driver, PRODUCTNAME);
		
		InventoryItemPage iip = new InventoryItemPage(driver);
		iip.clickOnAddToCart();
		
		ip.clickOnCartContainer();
		
		CartPage cp = new CartPage(driver);
		String pInCart = cp.getproductName();
		
		System.out.println("Product Name from Excel: " + PRODUCTNAME);
		System.out.println("Product Added to Cart: " + pAddedToCart);
		System.out.println("Product in Cart: " + pInCart);
		
		if(pInCart.equals(pAddedToCart)) {
			System.out.println("Test Case Pass");
			System.out.println(pInCart);
		}else {
			System.out.println("Test Case Fail");
		}
		
		ip.logoutOfApp();
		
	}
}
