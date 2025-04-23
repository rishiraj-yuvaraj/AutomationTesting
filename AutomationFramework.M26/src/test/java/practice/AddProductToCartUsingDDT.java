package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

public class AddProductToCartUsingDDT {
public static void main(String[] args) throws Throwable {
	
	//First method we used
	
//	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
//	Properties pro = new Properties();
//	pro.load(fis);
//	
//	String URL = pro.getProperty("url");
//	String USERNAME = pro.getProperty("username");
//	String PASSWORD = pro.getProperty("password");
	
	
//	FileInputStream fist = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
//	Workbook wb = WorkbookFactory.create(fist);
//	Sheet sheet = wb.getSheet("sheet 1");
//	Row row = sheet.getRow(0);
//	Cell cell = row.getCell(2);
//	String PRODUCTNAME = cell.getStringCellValue(); 
	
	// Right method implementing from here
	FileUtility fUtil = new FileUtility();
	SeleniumUtility sUtil = new SeleniumUtility();
	JavaUtility jUtil = new JavaUtility();
	
	String URL = fUtil.readDataFromPropertyFile("url");
	String USERNAME = fUtil.readDataFromPropertyFile("username");
	String PASSWORD = fUtil.readDataFromPropertyFile("password");
	
	String PRODUCTNAME = fUtil.readDataFromExcel("Sheet1", 1, 2);
	
	
	
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
	driver.get(URL);
	driver.findElement(By.id("user-name")).sendKeys(USERNAME);
	driver.findElement(By.id("password")).sendKeys(PASSWORD);
	driver.findElement(By.id("login-button")).click();
	
	
	WebElement proAddToCart = driver.findElement(By.xpath("//div[.='Sauce Labs Bolt T-Shirt']"));
	String proName = proAddToCart.getText();
	proAddToCart.click();
	
	driver.findElement(By.id("add-to-cart")).click();
	
	driver.findElement(By.id("shopping_cart_container")).click();
	
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
