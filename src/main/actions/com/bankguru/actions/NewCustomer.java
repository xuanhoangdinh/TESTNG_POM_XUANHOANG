package com.bankguru.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.bankguru.ui.NewCustomerUI;

import CommonPage.commonFunction;

public class NewCustomer extends commonFunction {

	public NewCustomer(WebDriver driver) {
		super(driver);
	}

	public void pressKeyTabCustomerName(Keys key) {
		waitVisible(NewCustomerUI.CUSTOMER_NAME_TXT);
		inputKeys(NewCustomerUI.CUSTOMER_NAME_TXT, key);
	}

	public void inputNumberCustomerName(String value) {
		waitVisible(NewCustomerUI.CUSTOMER_NAME_TXT);
		input(NewCustomerUI.CUSTOMER_NAME_TXT, value);
	}

	public String getTexCustomorname() {
		waitVisible(NewCustomerUI.CUSTOMER_NAME_MSG);
		return getText(NewCustomerUI.CUSTOMER_NAME_MSG);
	}

	public void pressKeyTabAddress(Keys key) {
		waitVisible(NewCustomerUI.ADDRESS_TXT);
		inputKeys(NewCustomerUI.ADDRESS_TXT, key);
	}

	public void pressKeySpaceAddress(Keys key) {
		waitVisible(NewCustomerUI.ADDRESS_TXT);
		inputKeys(NewCustomerUI.ADDRESS_TXT, key);
	}

	public String getTexAddress() {
		waitVisible(NewCustomerUI.ADDRESS_MSG);
		return getText(NewCustomerUI.ADDRESS_MSG);
	}

	public void pressKeyTabCity(Keys key) {
		waitVisible(NewCustomerUI.CITY_TXT);
		inputKeys(NewCustomerUI.CITY_TXT, key);
	}

	public String getTexCity() {
		waitVisible(NewCustomerUI.CITY_MSG);
		return getText(NewCustomerUI.CITY_MSG);
	}

	public void inputNumberCity(String value) {
		waitVisible(NewCustomerUI.CITY_TXT);
		input(NewCustomerUI.CITY_TXT, value);
	}

	public void pressKeyState(Keys key) {
		waitVisible(NewCustomerUI.STATE_TXT);
		inputKeys(NewCustomerUI.STATE_TXT, key);
	}

	public String getTexState() {
		waitVisible(NewCustomerUI.STATE_MSG);
		return getText(NewCustomerUI.STATE_MSG);
	}

	public void inputNumberState(String value) {
		waitVisible(NewCustomerUI.STATE_TXT);
		input(NewCustomerUI.STATE_TXT, value);
	}
	public void pressKeyDateOfBirth(Keys key) {
		waitVisible(NewCustomerUI.DOB_DATEPICKER);
		inputKeys(NewCustomerUI.DOB_DATEPICKER, key);
	}

	public String getTexDateOfBirth() {
		waitVisible(NewCustomerUI.DOB_DATEPICKER_MSG);
		return getText(NewCustomerUI.DOB_DATEPICKER_MSG);
	}

	public void inputDateOfBirth(String value) {
		waitVisible(NewCustomerUI.DOB_DATEPICKER);
		input(NewCustomerUI.DOB_DATEPICKER, value);
	}
}