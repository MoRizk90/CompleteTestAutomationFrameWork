package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends pageBase{

	public HomePage(WebDriver driverToBeUsedByPaseBaseObj) {
		super(driverToBeUsedByPaseBaseObj);
	}

	@FindBy(xpath= "//a[@class='ico-register']")
	WebElement RegisterLink;

	@FindBy(xpath= "//a[@class='ico-login']")
	WebElement lognLink;

	@FindBy(xpath= "//span[@class='wishlist-label']")
	WebElement wishListLink;

	@FindBy(xpath= "//span[@class='cart-label']")
	WebElement ShoppingcartLink;

	@FindBy(xpath= "//img[contains(@alt,'demo')]")
	WebElement nopCommerceImageLink;

	@FindBy(xpath= "//input[@id='small-searchterms']")
	WebElement searchStoreTextBox;

	@FindBy(xpath= "//input[@value='Search']")
	WebElement searchBtn;

	@FindBy(xpath= "//ul[@class='top-menu']//a[contains(text(),'Computers')]")
	WebElement computersLink;

	@FindBy(xpath= "//ul[@class='top-menu']//a[contains(text(),'Electronics')]")
	WebElement electronicsLink;

	@FindBy(xpath= "//ul[@class='top-menu']//a[contains(text(),'Apparel')]")
	WebElement apparelLink;

	@FindBy(xpath= "//ul[@class='top-menu']//a[contains(text(),'Digital downloads')]")
	WebElement digitalDownloads;

	@FindBy(xpath= "//ul[@class='top-menu']//a[contains(text(),'Desktops')]")
	WebElement desktop;
	
	@FindBy(className = "ico-logout")
	WebElement logOut;
	
	
	
	@FindBy(tagName= "a")
	List<WebElement> links;
	
	//For Assertion
	@FindBy(xpath= "//h2[contains(text(),'Welcome to our store')]")
	public WebElement homePagTitle;
	
	//Web elements in the desktop's pages
	@FindBy(xpath = "//h1[contains(text(),'Desktops')]")
	public WebElement deskTopPageTitle;
	
	@FindBy(xpath = "//a[contains(text(),'Lenovo IdeaCentre 600 All-in-One PC')]")
	public WebElement deskTopItem;
	
	Integer badLinksCount = 0;

	@SuppressWarnings("null")
	public void verifyHomePageLink() {
		
		for (WebElement linkElem : links) {

			if (verifyBrokenLinks(linkElem.getAttribute("href"))) {
				System.out.print(linkElem.getAttribute("href") + " failed");
				System.out.print("\n");
				badLinksCount += 1;
				
			}
		}
		System.out.println(badLinksCount);
	}
	
	public void open_the_computers_dropdown_menu() {
		hover(computersLink);
	}
	public void click_on_desktops_item() {
		click(desktop);
	}
	public void click_on_reg_link() {
		click(RegisterLink);
		
	}
	public void clickOnLoginLink() {
		click(lognLink);
	}
	
	public void logout() {
		click(logOut);
		
	}



}
