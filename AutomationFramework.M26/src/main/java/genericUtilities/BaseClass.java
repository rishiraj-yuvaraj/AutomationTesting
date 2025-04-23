package genericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;
import objectRepository.LoginPage;

/**
 * This class consists of Basic configuration annotation of TestNG
 * @author ADMIN
 */
public class BaseClass {

	public FileUtility fUtil = new FileUtility();
	public JavaUtility jUtil = new JavaUtility();
	public SeleniumUtility sUtil = new SeleniumUtility();
	
	public WebDriver driver;
	
	//For Listeners
	public static WebDriver sdriver;
	
//	@BeforeSuite(groups={"SmokeSuite","RegressionSuite"})//this will give us an error, instead of this we can use alwaysRun=true
	@BeforeSuite(alwaysRun=true)
	public void bsConfig() {
		System.out.println("----DataBase Connection Successfull----");
	}
	
	//@Parameters("Browser")
	//@BeforeTest //this is completely optional, either we can use beforeClass or Before test -> To Run the particular test not all the classes
	@BeforeClass(alwaysRun = true) //either we can give groups= "SmokeSuite" or alwaysRun = true
	public void bcConfig(String pValue) throws Throwable {
		String URL = fUtil.readDataFromPropertyFile("url");
		
		//driver = new ChromeDriver();
		
		//For Cross Browser Testing - we will not use this frequently -> RunTime Polymorphism
//		if(pValue.equals("chrome")) {
//			driver=new ChromeDriver();
//		}else if(pValue.equals("edge")) {
//			driver = new EdgeDriver();
//		}else {
//			driver = new EdgeDriver();
//		}
		
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);
		
		driver.get(URL);
		System.out.println("----Browser Launch Successfull----");
		
		//For Listeners
		sdriver=driver;
	}
	
	@BeforeMethod(alwaysRun=true)
	public void bmConfig() throws Throwable {
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp(USERNAME, PASSWORD);
		
		System.out.println("----Login to App successfull----");		
	}
	
	@AfterMethod(alwaysRun=true)
	public void amConfig() {
		InventoryPage ip = new InventoryPage(driver);
		ip.logoutOfApp();
		
		System.out.println("----Logout of Application----");
	}
	
	@AfterTest
	//@AfterClass(alwaysRun=true)
	public void acConfig() {
		driver.quit();
		
		System.out.println("----Browser Closure Successfull----");
	}
	
	@AfterSuite(alwaysRun=true)
	public void asConfig() {
		System.out.println("----Database Closure Successfull----");
	}
	
	
	
}
