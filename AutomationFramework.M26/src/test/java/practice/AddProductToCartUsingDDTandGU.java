package practice;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtilities.FileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.InventoryPage;
import objectRepository.LoginPage;

public class AddProductToCartUsingDDTandGU { //GU -> Genaralizing Utility
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
		
		
		
		
//		FileInputStream fist = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
//		Workbook wb = WorkbookFactory.create(fist);
//		Sheet sheet = wb.getSheet("sheet 1");
//		Row row = sheet.getRow(0);
//		Cell cell = row.getCell(2);
//		String PRODUCTNAME = cell.getStringCellValue(); 
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get(URL);
		
//		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
//		driver.findElement(By.id("password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("login-button")).click();
		
		LoginPage lp = new LoginPage(driver);
//		lp.getUsernameEdt().sendKeys(USERNAME); // we are hiding the locator
//		lp.getPasswordEdt().sendKeys(PASSWORD);
//		lp.getLoginBtn().click();
		lp.LoginToApp(USERNAME, PASSWORD);
		
		WebElement proAddToCart = driver.findElement(By.xpath("//div[.='Sauce Labs Bolt T-Shirt']"));
		String proName = proAddToCart.getText();
		proAddToCart.click();
		driver.findElement(By.id("add-to-cart")).click();
		driver.findElement(By.id("shopping_cart_container")).click();
		
		//InventoryPage ip = new InventoryPage(driver);
		
		
		//Capture Screenshots for reference
		String screenshotname = "TC_001_"+jUtil.getSystemDateInFormat();
		String path = sUtil.captureScreenShot(driver, screenshotname);
		System.out.println(path);
		
		String pInCart = driver.findElement(By.className("inventory_item_name")).getText();
		
		if(proName.equals(pInCart)) {
			System.out.println("Test Case Pass");
		}else {
			System.out.println("Test Case Fail");
		}
		
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();
		driver.quit();
		
	}
}
