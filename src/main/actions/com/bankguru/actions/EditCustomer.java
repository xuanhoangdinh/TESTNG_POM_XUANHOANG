package com.bankguru.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.bankguru.ui.EditCustomerUI;

import CommonPage.commonFunction;

public class EditCustomer extends commonFunction {

	public EditCustomer(WebDriver driver) {
		super(driver);
	}

	public void pressKeyTabCustomerId(Keys key) {
		waitVisible(EditCustomerUI.CUSTOMER_ID_TXT);
		inputKeys(EditCustomerUI.CUSTOMER_ID_TXT, key);
	}

	public void inputCustomerId(String value) {
		waitVisible(EditCustomerUI.CUSTOMER_ID_TXT);
		input(EditCustomerUI.CUSTOMER_ID_TXT, value);
	}

	public String getTexCustomerId() {
		waitVisible(EditCustomerUI.CUSTOMER_ID_MSG);
		return getText(EditCustomerUI.CUSTOMER_ID_MSG);
	}

	public EditCustomer clickSummit() {
		waitVisible(EditCustomerUI.SUMMIT_BTN);
		click(EditCustomerUI.SUMMIT_BTN);
		return PageFactory.initElements(driver, EditCustomer.class);
	}

}