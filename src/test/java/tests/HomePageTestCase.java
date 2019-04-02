package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.RegisterPage;

public class HomePageTestCase extends TestBase{
	HomePage HomeObj;
	RegisterPage RegObj;
	
	
	

	@Test
	public void opening_desktops_page() {
		HomeObj = new HomePage(testBaseDriver);
		HomeObj.open_the_computers_dropdown_menu();
		HomeObj.click_on_desktops_item();
		Assert.assertTrue(testBaseDriver.getCurrentUrl().contentEquals("https://demo.nopcommerce.com/desktops"));
		Assert.assertTrue(HomeObj.deskTopPageTitle.getText().contentEquals("Desktops"));
		Assert.assertTrue(HomeObj.deskTopItem.getText().contains("600 All-in-One PC"));
		go_back();
		Assert.assertTrue(HomeObj.homePagTitle.getText().contains("Welcome"));
	}
	
	@Test(dependsOnMethods = "opening_desktops_page")
	public void open_registeration_page() {
		HomeObj = new HomePage(testBaseDriver);
		HomeObj.click_on_reg_link();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.master-wrapper-page:nth-child(6) div.master-wrapper-content div.master-column-wrapper div.center-1 div.page.registration-page div.page-title > h1:nth-child(1)")));
		System.out.println(testBaseDriver.getCurrentUrl());
		Assert.assertTrue(testBaseDriver.getCurrentUrl().contains("register"));
	}

}
