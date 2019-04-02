package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.*;

import pages.HomePage;
import pages.RegisterPage;

public class RegisterationTestCase extends TestBase {
	HomePage home_page_obj;
	RegisterPage reg_page_obj;
	Faker fakeObj = new Faker();
	Da
	/*
	 * ana kont b7awel eny b7awel eny AGENERATE DATE nbest3mal el faker lib
	 * 
	 * 
	 */
	

	
	@Test
	public void open_registeration_page() {
		home_page_obj = new HomePage(testBaseDriver);
		home_page_obj.click_on_reg_link();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.master-wrapper-page:nth-child(6) div.master-wrapper-content div.master-column-wrapper div.center-1 div.page.registration-page div.page-title > h1:nth-child(1)")));
		System.out.println(testBaseDriver.getCurrentUrl());
		Assert.assertTrue(testBaseDriver.getCurrentUrl().contains("register"));
		fakeObj.
	}
	
	
	
	
}
