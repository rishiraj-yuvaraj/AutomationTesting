package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { //rule 1 - Create a seperate POM Class
	
	//Declaration
	//Rule 2 - Identify all WebElements using annotations
	@FindBy(id = "user-name") 
	private WebElement usernameEdt;
	
	//Auto Healing Process - if first locator is not able to identify the web element
	//automatically then @FindAll will shift to another locator for identifying the web element
	@FindAll({@FindBy(id="password"),@FindBy(name = "password")}) //Single WebElement with multiple locators - OR Operator
	private WebElement passwordEdt;
	
//	@FindBys({@FindBy(id="password"),@FindBy(name = "password")}) //Single WebElement with multiple locators - AND Operator
//	private WebElement password;

	
//	@FindBy(name = "password")
//	private WebElement passwordEdt;
	
	@FindBy(className= "submit-button")
	private WebElement loginBtn;
	
	//Rule 3 - Create a constructor to initialize webelements
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	//Rule 4 - Provide getters to Access the webelements
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	
	//Business Library - Generic Method - Related to Application -> purely optional and it will optimize the code

	/**
	 * This method will perform login operation
	 * @param username
	 * @param password
	 */
	public void LoginToApp(String username, String password) {
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
	
	
	
	
	
}
