package tests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.HandlingExcel;
import pages.HomePage;
import pages.LoginPage;

public class LoginTestCases extends TestBase{
	private HomePage HomeObj;
	private LoginPage loginObj;

	
	
	//Data provider to read the data from excel
	@DataProvider(name= "excelData")
	public Object[][] userRegisterData() throws IOException{
		HandlingExcel er = new HandlingExcel();
		return er.getExcelData();
	}

	@SuppressWarnings("static-access")
	@Test(dataProvider = "excelData") 
	private void login(String email,  String testPassword) {
		HomeObj = new HomePage(testBaseDriver);
		System.out.println("trying to click on the login link");
		HomeObj.clickOnLoginLink();
		loginObj.loginWithSuccssfullCredintials(email, testPassword);		
//		reg_page_obj.registerNewUser(gender, first_name, Last_name, theDay, Integer.parseInt(TheMonth), theYear, email, company, testPassword);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("register-continue")));
//		assertTrue(reg_page_obj.registerationSuccessMsg.getText().contentEquals("Your registration completed"));
//		home_page_obj.logout();
//		home_page_obj.click_on_reg_link();
	}

}
