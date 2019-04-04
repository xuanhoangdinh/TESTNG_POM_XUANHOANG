package com.bankguru.testcase;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.actions.EditCustomer;
import com.bankguru.actions.HomePage;
import com.bankguru.actions.LoginPage;
import com.bankguru.actions.NewCustomer;
import com.bankguru.actions.RegisterPage;

import CommonPage.Commontestcase;

public class EditCustomerScript extends Commontestcase {
	WebDriver driver;
	LoginPage loginPage;
	RegisterPage registerPage;
	HomePage homePage;
	NewCustomer newCustomer;
	EditCustomer editCustomer;
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
		editCustomer = homePage.clickMenuEditCustomer();
	}

	@Test
	// 1.Verify Customer idCustomer id cannot b empty1) Do not enter a value in
	// Customer id Field2) Press TAB and move to next FieldAn error message
	// "CustomerID is required" must be shown
	
	public void TC_01() {
		editCustomer.pressKeyTabCustomerId(Keys.TAB);
		verifyEqual(editCustomer.getTexCustomerId(), "Customer ID is required");
	}

//	2.Customer id must be numeric1) Enter character value in Customer idField 1234Ac /cAcc123
//	An error messag "Characters are not allowed" must be shown
	@Test
	public void TC_02() {
		editCustomer.inputCustomerId("1234Ac");
		verifyEqual(editCustomer.getTexCustomerId(), "Characters are not allowed");
	}

	// 3.Customer id cannot have special character 1) Enter Special Character In
	// Customer id Field 123!@# !@# An error message "Special characters are not
	// allowed" must be shown
	@Test
	public void TC_03() {
		editCustomer.inputCustomerId("123!@#");
		verifyEqual(editCustomer.getTexCustomerId(), "Special characters are not allowed");
	}

//	4 Valid Customer Id
//	1) Enter valid Customer id
//	2) Submit xyz Edit Customer successfully
	@Test
	public void TC_04() {
		editCustomer.inputCustomerId("xyz");
		verifyEqual(editCustomer.getTexCustomerId(), "Characters are not allowed");
	}
//	5 Valid Customer Id
//	1) Enter valid Customer id
//	2) Submit 12345 Edit Customer successfully
	@Test
	public void TC_05() {
		editCustomer.inputCustomerId("12345");
		editCustomer.clickSummit();
	}
	@AfterClass
	public void afterClass() {
		closeBrowser();
	}
}
