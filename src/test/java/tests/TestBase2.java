package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase2 {
	public static String BaseUrl = "https://demo.nopcommerce.com";
	protected ThreadLocal<RemoteWebDriver> test_driver = null;
	
	@BeforeClass
	@Parameters(value= {"browser"})
	public void setUp(@Optional("chrome") String browser) throws MalformedURLException {
		test_driver = new ThreadLocal<RemoteWebDriver>();
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("BrowseName", browser);
		test_driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps));
		getDriver().navigate().to(BaseUrl);
	}
	
	public WebDriver getDriver() {
		return test_driver.get();
	}
	
	@AfterClass
	public void stopDriver() {
		getDriver().quit();
		test_driver.remove();
	}
}


