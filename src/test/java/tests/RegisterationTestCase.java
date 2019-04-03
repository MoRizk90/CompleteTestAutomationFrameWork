package tests;

import static org.testng.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.DateAndTime;
import com.github.javafaker.Faker;

import pages.HomePage;
import pages.RegisterPage;

public class RegisterationTestCase extends TestBase {
	HomePage home_page_obj;
	RegisterPage reg_page_obj;
	Faker fakeObj = new Faker();





	@Test
	public void open_registeration_page() {
		home_page_obj = new HomePage(testBaseDriver);
		home_page_obj.click_on_reg_link();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.master-wrapper-page:nth-child(6) div.master-wrapper-content div.master-column-wrapper div.center-1 div.page.registration-page div.page-title > h1:nth-child(1)")));
		System.out.println(testBaseDriver.getCurrentUrl());
		Assert.assertTrue(testBaseDriver.getCurrentUrl().contains("register"));
	}

	@SuppressWarnings("static-access")
	@Test(dependsOnMethods = {"open_registeration_page"})
	private void RegisterNewUserWithCorrectcredential() {
		reg_page_obj = new RegisterPage(testBaseDriver);
		String gender = "male" ;
		String first_name = fakeObj.name().firstName();
		String Last_name  = fakeObj.name().lastName();
		Date theDate = fakeObj.date().future(10, TimeUnit.DAYS);
		Calendar newCal =  Calendar.getInstance();
		newCal.setTime(theDate);
		String theDay = Integer.toString(newCal.get(newCal.DATE));
		int TheMonth = newCal.get(newCal.MONTH);
		String theYear = Integer.toString(newCal.get(newCal.YEAR));
		String email = fakeObj.internet().emailAddress();
		String company = fakeObj.company().name();
		String testPassword = fakeObj.internet().password();
		reg_page_obj.registerNewUser(gender, first_name, Last_name, theDay, TheMonth, theYear, email, company, testPassword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("register-continue")));
		assertTrue(reg_page_obj.registerationSuccessMsg.getText().contentEquals("Your registration completed"));
	}




}
