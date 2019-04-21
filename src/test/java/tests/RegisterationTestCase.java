package tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import data.HandlingExcel;
import pages.HomePage;
import pages.RegisterPage;

public class RegisterationTestCase extends TestBase {
	HomePage home_page_obj;
	RegisterPage reg_page_obj;
	Faker fakeObj = new Faker();



	@Test(enabled = false)
	public void open_registeration_page() {
		home_page_obj = new HomePage(testBaseDriver);
		home_page_obj.click_on_reg_link();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.master-wrapper-page:nth-child(6) div.master-wrapper-content div.master-column-wrapper div.center-1 div.page.registration-page div.page-title > h1:nth-child(1)")));
		System.out.println(testBaseDriver.getCurrentUrl());
		Assert.assertTrue(testBaseDriver.getCurrentUrl().contains("register"));
	}

	@SuppressWarnings("static-access")
	@Test(dependsOnMethods = {"open_registeration_page"}, priority = 1, enabled = false)
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
	
	@SuppressWarnings("static-access")
	@Test(priority = 1)
	public void add_data_to_excel() throws IOException {
		for (int i = 0; i < 6; i++) {
		String gender = "male" ;
		String first_name = fakeObj.name().firstName();
		String Last_name  = fakeObj.name().lastName();
		Date theDate = fakeObj.date().future(10, TimeUnit.DAYS);
		Calendar newCal =  Calendar.getInstance();
		newCal.setTime(theDate);
		String theDay = Integer.toString(newCal.get(newCal.DATE));
		String TheMonth = Integer.toString(newCal.get(newCal.MONTH));
		String theYear = Integer.toString(newCal.get(newCal.YEAR));
		String email = fakeObj.internet().emailAddress();
		String company = fakeObj.company().name();
		String testPassword = fakeObj.internet().password();
		HandlingExcel new_excel_handler = new HandlingExcel();
		new_excel_handler.Open_excel_sheet();
		new_excel_handler.write_data_into_excel(i+1, "1", gender, first_name, Last_name, theDay, TheMonth, theYear, email, company, testPassword);
		}
	}
	
	@DataProvider(name= "excelData")
	public Object[][] userRegisterData() throws IOException{
		HandlingExcel er = new HandlingExcel();
		return er.getExcelData();
	}
	
	@SuppressWarnings("static-access")
	@Test(dependsOnMethods = {"add_data_to_excel"}, priority = 2, dataProvider = "excelData") 
	private void RegisterNewUserWithCorrectCredentialWithExcel(String gender, String first_name, String Last_name, String theDay, String TheMonth, String theYear, String email, String company, String testPassword) {
		reg_page_obj = new RegisterPage(testBaseDriver);
		reg_page_obj.registerNewUser(gender, first_name, Last_name, theDay, Integer.parseInt(TheMonth), theYear, email, company, testPassword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("register-continue")));
		assertTrue(reg_page_obj.registerationSuccessMsg.getText().contentEquals("Your registration completed"));
	}





}
