package com.bankguru.testcase;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.actions.HomePage;
import com.bankguru.actions.LoginPage;
import com.bankguru.actions.NewCustomer;
import com.bankguru.actions.RegisterPage;

import CommonPage.Commontestcase;

public class NewCustomerScript extends Commontestcase {
	WebDriver driver;
	LoginPage loginPage;
	RegisterPage registerPage;
	HomePage homePage;
	NewCustomer newCustomer;
	String email, emailLogin, passwordLogin;

	@Parameters({ "browser", "version", "url" })
	@BeforeClass
	public void beforeClass(String browser, String version, String url) {
		driver = openMultiBrowser(browser, version, url);

		email = "hoangxuan" + randomEmail() + "@gmail.com";
		// loginPage = new LoginPage(driver);
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
		verifyEqual(homePage.getWelcomString(), "Welcome To Manager's Page of Guru99 Bank");
	}

	@BeforeMethod
	public void beforeMethod() {
		newCustomer = homePage.clickMenuNewCustomer();
	}

	@Test
	public void TC_01() {
		newCustomer.pressKeyTabCustomerName(Keys.TAB);
		verifyEqual(newCustomer.getTexCustomorname(), "Customer name must not be blank");

	}

	@Test
	public void TC_02() {
		newCustomer.inputNumberCustomerName("1234");
		verifyEqual(newCustomer.getTexCustomorname(), "Numbers are not allowed");

	}

	@Test
	public void TC_03() {
		newCustomer.inputNumberCustomerName("name!@# ");
		verifyEqual(newCustomer.getTexCustomorname(), "Special characters are not allowed");

	}

	@Test
	public void TC_04() {
		newCustomer.pressKeyTabCustomerName(Keys.SPACE);
		verifyEqual(newCustomer.getTexCustomorname(), "First character can not have space");

	}

	@Test
	public void TC_05() {
		newCustomer.pressKeyTabAddress(Keys.TAB);
		verifyEqual(newCustomer.getTexAddress(), "Address Field must not be blank");
	}

	@Test
	public void TC_06() {
		newCustomer.pressKeyTabAddress(Keys.SPACE);
		verifyEqual(newCustomer.getTexAddress(), "First character can not have space");
	}

//	1) Do not enter a value in CITY Field 2) Press TAB and move to next Field
	@Test
	public void TC_08() {
		newCustomer.pressKeyTabCity(Keys.TAB);
		verifyEqual(newCustomer.getTexCity(), "City Field must not be blank");
	}

//	9) Enter numeric value in CITY Field 1234 city123
	@Test
	public void TC_09() {
		newCustomer.inputNumberCity("1234");
		verifyEqual(newCustomer.getTexCity(), "Numbers are not allowed");
	}

//	10) Enter Special Character In CITY Field : City!@#
	@Test
	public void TC_10() {
		newCustomer.inputNumberCity("City!@#");
		verifyEqual(newCustomer.getTexCity(), "Special characters are not allowed");
	}
//	11) Enter First character Blank space
	@Test
	public void TC_11() {
		newCustomer.pressKeyTabCity(Keys.SPACE);
		verifyEqual(newCustomer.getTexCity(), "First character can not have space");
//12 Verify State Field State cannot be empt1) Do not enter a value in STATE Field 2) Press TAB and move to next Field

	}
	@AfterClass
	public void afterClass() {
		closeBrowser();
	}
}
