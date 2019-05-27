package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends pageBase{
	public LoginPage(WebDriver driverToBeUsedByPaseBaseObj) {
		super(driverToBeUsedByPaseBaseObj);
	}
	
	private HomePage homeObj;

	@FindBy(id= "Email")
	private WebElement emailTxtBox;

	@FindBy(id= "Password")
	private WebElement passwordTxtBox;

	@FindBy(className= "login-button")
	private WebElement loginButton;
	
	public void goTologinScreen() {
		
	}
	
	public void loginWithSuccssfullCredintials(String email) {
		
	}
	
	








}
