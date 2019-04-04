package CommonPage;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;

public class Commontestcase {
	WebDriver driver;

	public WebDriver openMultiBrowser(String browser, String version, String url) {
    	if (browser.equals("chrome")) {
			ChromeDriverManager.getInstance().version(version).setup();
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
		} else if (browser.equals("firefox")) {
			FirefoxDriverManager.getInstance().version(version).setup();
			driver = new FirefoxDriver();
			driver.get(url);
			driver.manage().window().maximize();
		}
		return driver;
	}

	public String randomEmail() {
		Random rand = new Random();
		int n = rand.nextInt(9999999);
		return String.valueOf(n);
	}

	public void verifyEqual(String actual, String expected) {
		Assert.assertEquals(actual, expected);
	}

	public void closeBrowser() {
		driver.quit();
	}
}