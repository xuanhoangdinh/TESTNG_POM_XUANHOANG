package com.bankguru.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.bankguru.ui.HomePageUI;

import CommonPage.commonFunction;

public class HomePage extends commonFunction {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public String getWelcomString() {
		waitVisible(HomePageUI.WELCOME_LBL);
		return getText(HomePageUI.WELCOME_LBL);

	}

	public NewCustomer clickMenuNewCustomer() {
		waitVisible(HomePageUI.NEWCUSTOMER_LINK);
		click(HomePageUI.NEWCUSTOMER_LINK);
		return PageFactory.initElements(driver, NewCustomer.class);

	}
	public EditCustomer clickMenuEditCustomer() {
		waitVisible(HomePageUI.EDITCUSTOMER_LINK);
		click(HomePageUI.EDITCUSTOMER_LINK);
		return PageFactory.initElements(driver, EditCustomer.class);

	}
}