package pages;

import java.nio.file.WatchEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends pageBase{

	public ProductsPage(WebDriver driverToBeUsedByPaseBaseObj) {
		super(driverToBeUsedByPaseBaseObj);
	}
	
	//This part is for the desktops products
	@FindBy(xpath = "//div[@class='item-box']/div[@data-productid='1']/div[@class='details']/div[@class='add-info']/div[@class='buttons']/input[@value='Add to cart']")
	WebElement buildYourOwnComputer_add_to_cart;
	
	@FindBy(xpath = "//div[@class='item-box']/div[@data-productid='2']/div[@class='details']/div[@class='add-info']/div[@class='buttons']/input[@value='Add to cart']")
	WebElement DigitalStorm_add_to_cart;
	
	@FindBy(xpath = "//div[@class='item-box']/div[@data-productid='3']/div[@class='details']/div[@class='add-info']/div[@class='buttons']/input[@value='Add to cart']")
	WebElement lenovo_idea_center_add_to_cart;
	
	@FindBy(id = "add-to-cart-button-1")
	WebElement desktop_add_to_cart;
	
	@FindBy(id = "product_attribute_3_6")
	WebElement HDD320GB;
	
	//Add to cart assertion
	@FindBy(xpath = "//p[@class='content']")
	private WebElement add_to_cart_notification;
	
	
	//Desktop Operation
	public void add_build_your_own_computer_to_the_cart() {
		click(buildYourOwnComputer_add_to_cart);
		
	}
	
	public void build_your_computer_to_checkout() {
		click(HDD320GB);
		click(desktop_add_to_cart);
	}
	
	public WebElement get_the_cart_notification() {
		return add_to_cart_notification;
	}

}
