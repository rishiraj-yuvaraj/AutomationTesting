package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryItemPage {
	
	//Declaration
	@FindBy(id="add-to-cart")
	private WebElement addToCartBtn;
	
	@FindBy(className="inventory_details_price")
	private WebElement priceDetails;

	//constructor
	public InventoryItemPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getAddToCartBtn() {
		return addToCartBtn;
	}

	public WebElement getPriceDetails() {
		return priceDetails;
	}
	
	//Business Library
	
	/**
	 * This method will click on addToCart button
	 */
	public void clickOnAddToCart() {
		addToCartBtn.click();
	}
	
	/**
	 * This method will show the product price 
	 * @return
	 */
	public String priceDetails() {
		return priceDetails.getText();
	}
	
	
	
	
	
}
