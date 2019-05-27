package tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.HandlingExcel;
import pages.HomePage;
import pages.RegisterPage;

public class LoginTestCases {
	private HomePage HomeObj;

	
	
	//Data provider to read the data from excel
	@DataProvider(name= "excelData")
	public Object[][] userRegisterData() throws IOException{
		HandlingExcel er = new HandlingExcel();
		return er.getExcelData();
	}

	@SuppressWarnings("static-access")
	@Test(dependsOnMethods = {"add_data_to_excel"}, priority = 2, dataProvider = "excelData") 
	private void login(String email, String password, String Last_name, String theDay, String TheMonth, String theYear, String email, String company, String testPassword) {
		reg_page_obj = new RegisterPage(testBaseDriver);
		reg_page_obj.registerNewUser(gender, first_name, Last_name, theDay, Integer.parseInt(TheMonth), theYear, email, company, testPassword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("register-continue")));
		assertTrue(reg_page_obj.registerationSuccessMsg.getText().contentEquals("Your registration completed"));
		home_page_obj.logout();
		home_page_obj.click_on_reg_link();
	}

}
