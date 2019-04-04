package com.bankguru.testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.actions.HomePage;
import com.bankguru.actions.LoginPage;
import com.bankguru.actions.RegisterPage;

import CommonPage.Commontestcase;

public class LogInScript extends Commontestcase {
	WebDriver driver;
	LoginPage loginPage;
	RegisterPage registerPage;
	HomePage homePage;
	String email, emailLogin, passwordLogin;

	@Parameters({ "browser", "version", "url" })
	@BeforeClass
	public void beforeClass(String browser, String version, String url) {
		driver = openMultiBrowser(browser, version, url);

		email = "hoangxuan" + randomEmail() + "@gmail.com";
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		registerPage = loginPage.clickHereLink();
		registerPage.inputEmailRegister(email);
		registerPage.clickSumit();
		emailLogin = registerPage.getUsername();
		passwordLogin = registerPage.getPasswork();
		loginPage = registerPage.navigateToLoginPage("http://demo.guru99.com/V4/");
		loginPage.iputUsename(emailLogin);
		loginPage.iputPassword(passwordLogin);
		homePage = loginPage.clickLogin();
		homePage = new HomePage(driver);
		verifyEqual(homePage.getWelcomString(), "Welcome To Manager's Page of Guru99 Bank");

	}

	@Test
	public void TC_01() {

		// loginPage = new LoginPage(driver);

	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}
}

