package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductsPage;

public class AddToCartTestCases extends TestBase {
	HomePage HomePageObj;
	ProductsPage prdPageObj;
	
	@Test
	public void add_Desktop_to_cart() throws InterruptedException {
		HomePageObj = new HomePage(testBaseDriver);
		prdPageObj = new ProductsPage(testBaseDriver);
		HomePageObj.open_the_computers_dropdown_menu();
		HomePageObj.click_on_desktops_item();
		Assert.assertTrue(HomePageObj.deskTopPageTitle.getText().contains("Desktops"));

		prdPageObj.add_build_your_own_computer_to_the_cart();
		Thread.sleep(3000);
//		testBaseDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		Assert.assertTrue(testBaseDriver.getCurrentUrl().contentEquals("https://demo.nopcommerce.com/build-your-own-computer"));
		prdPageObj.build_your_computer_to_checkout();
		Thread.sleep(3000);
		Assert.assertTrue(prdPageObj.get_the_cart_notification().getText().contains("The product has been added to your "));
		
		
	}
	

}
