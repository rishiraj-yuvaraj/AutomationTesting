package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	@FindBy(className= "inventory_details_name")
	private WebElement itemInfo;
	
	@FindBy(id="checkout")
	private WebElement checkOutBtn;
	
	//constructor
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//getters
	public WebElement getItemInfo() {
		return itemInfo;
	}

	public WebElement getCheckOutBtn() {
		return checkOutBtn;
	}
	
	//Business Library
	/**
	 * This method will capture the product Name
	 * @return
	 */
	public String getproductName() {
		return itemInfo.getText();
	}
	
	/**
	 * This method will click on checkout button
	 */
	public void checkOutBtn() {
		checkOutBtn.click();
	}
	
	
	
	
}
