package pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class pageBase {

	protected static WebDriver pageBaseDriver;
	Actions action;
	

	public pageBase(WebDriver driverToBeUsedByPaseBaseObj) {
		PageFactory.initElements(driverToBeUsedByPaseBaseObj, this);
		action = new Actions(driverToBeUsedByPaseBaseObj);
	}

	public boolean verifyBrokenLinks(String urlLinkUnderTest) {
		try {
			URL theUrlUnderTest = new URL(urlLinkUnderTest);

			//Test the connection on the url

			HttpURLConnection http_conn = (HttpURLConnection) theUrlUnderTest.openConnection();
			http_conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			http_conn.setConnectTimeout(5000);
			http_conn.setRequestMethod("GET");
			http_conn.connect();


			//Check the response code

			if (http_conn.getResponseCode() == 200) {
				System.out.println(urlLinkUnderTest + "-" + http_conn.getResponseCode());
				return false;

			}else if (http_conn.getResponseCode() != 200) {
				System.out.println(urlLinkUnderTest + "-" + http_conn.getResponseCode());
				return true;
			}

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public void hover(WebElement targetElem) {
		action.moveToElement(targetElem).build().perform();		
	}
	
	public void click(WebElement target_elem) {
		target_elem.click();
	}
}
