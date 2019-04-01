package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
	protected static WebDriver testBaseDriver; //This driver will be used to capture the element
	protected static WebDriverWait wait;
	String osType; //This variable will store the system type
	String DriverPath;

	@BeforeSuite
	public void startDriver() {
		//Check the system type
		osType = System.getProperty("os.name").toLowerCase(); 
		if (osType.contains("win")){
			//Operating system is based on Windows
			DriverPath= System.getProperty("user.dir") + "/drivers/win/chromedriver.exe";
		}
		else if (osType.contains("nix") || osType.contains("aix") || osType.contains("nux")){
			//Operating system is based on Linux/Unix/*AIX
			DriverPath= System.getProperty("user.dir") + "/drivers/nix/chromedriver";
		}
		System.setProperty("webdriver.chrome.driver", DriverPath);
		testBaseDriver = new ChromeDriver();
		testBaseDriver.manage().window().maximize();
		testBaseDriver.navigate().to("https://demo.nopcommerce.com/");
		wait = new WebDriverWait(testBaseDriver, 30);
	}
	
	public void go_back() {
		testBaseDriver.navigate().back();
		
	}
	
	
	
	
	@AfterSuite
	public void killDriver() {
		testBaseDriver.quit();
		
	}




}
