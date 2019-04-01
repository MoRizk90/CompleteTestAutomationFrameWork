package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends pageBase{

	
	public RegisterPage(WebDriver driverToBeUsedByPaseBaseObj) {
		super(driverToBeUsedByPaseBaseObj);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath= "//h1[contains(text(),'Register')]")
	public WebElement registerTitle;

}
