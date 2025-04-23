package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddProductToCart {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
	driver.get("https://www.saucedemo.com/");
	driver.findElement(By.id("user-name")).sendKeys("standard_user");
	driver.findElement(By.id("password")).sendKeys("secret_sauce");
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
