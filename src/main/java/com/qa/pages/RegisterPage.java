package com.qa.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;

public class RegisterPage extends BaseClass {
	String error;
	Select selectItem;

	@FindBy(xpath = "//label[text()='Personal']")
	WebElement btnPersonal;
	@FindBy(xpath = "//label[text()='Business']")
	WebElement btnBusiness;
	@FindBy(id = "firstname")
	WebElement txtFirstName;
	@FindBy(id = "lastname")
	WebElement txtLastName;
	@FindBy(id = "Email")
	WebElement txtEmail;
	@FindBy(id = "password")
	WebElement txtPassword;
	@FindBy(css = "#google")
	WebElement btnGoogle;
	@FindBy(css = "#facebook")
	WebElement btnFB;
	@FindBy(css = "#apple")
	WebElement btnApple;
	@FindBy(css = "#businessName")
	WebElement businessName;
	@FindBy(css = "#businessEmail")
	WebElement businessEmail;
	@FindBy(css = "#bizPassword")
	WebElement businessPassword;
	@FindBy(css = "#businessCountry")
	WebElement businessCountry;
	@FindBy(css = "#businessCountry option")
	List<WebElement> countryList;
	@FindBy(css = "#firstname_err")
	WebElement errEmptyFirstName;
	@FindBy(css = "#lastname_err")
	WebElement errEmptyLastName;
	@FindBy(css = "#Email_err")
	WebElement errEmptyEmail;
	@FindBy(css = "#password_err")
	WebElement errPassword;
	@FindBy(css = "#businessName_err")
	WebElement errEmptyBusinessName;
	@FindBy(css = "#businessEmail_err")
	WebElement errEmptyBusinessEmail;
	@FindBy(css = "#bizPassword_err")
	WebElement errEmptyBusinessPassword;
	@FindBy(css = "#password_suggestion")
	WebElement txtPasswordSuggestion;
	@FindBy(css = "#EMAIL_REG_FORM_SUBMIT")
	WebElement btnSubmit;
	@FindBy(css = "#BUSINESS_REG_FORM_SUBMIT")
	WebElement btnBusinessSubmit;

	public RegisterPage() {
		super();
		PageFactory.initElements(driver, this);
	}

	public String getPageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public String checkEmptyFirstName(String f) {
		txtFirstName.sendKeys(f + Keys.TAB);
		error = errEmptyFirstName.getText();
		return error;
	}

	public String checkEmptyLastName(String l) {
		txtLastName.sendKeys(l + Keys.TAB);
		error = errEmptyLastName.getText();
		return error;
	}

	public String checkEmptyEmail(String e) {
		txtEmail.sendKeys(e + Keys.TAB);
		error = errEmptyEmail.getText();
		return error;
	}

	public String getPasswordSuggestion(String p) {
		txtPassword.click();
		txtPassword.sendKeys(p);
		error = txtPasswordSuggestion.getText();
		return error;
	}

	public String checkEmptyPassword(String p) {
		txtPassword.sendKeys(p);
		btnSubmit.click();
		error = errPassword.getText();
		return error;
	}

	public String checkEmptyBusinessName(String bn) {
		btnBusiness.click();
		businessName.sendKeys(bn + Keys.TAB);
		error = errEmptyBusinessName.getText();
		return error;
	}

	public String checkEmptyBusinessEmail(String be) {
		btnBusiness.click();
		businessEmail.sendKeys(be + Keys.TAB);
		error = errEmptyBusinessEmail.getText();
		return error;
	}

	public String checkEmptyBusinessPassword(String bp) {
		btnBusiness.click();
		businessPassword.sendKeys(bp);
		btnBusinessSubmit.click();
		error = errEmptyBusinessPassword.getText();
		return error;
	}

	public int checkCountryList() {
		btnBusiness.click();
		businessCountry.click();
		System.out.println("Total Country: " + countryList.size());
		for (WebElement e : countryList) {
			System.out.println("CountryName: " + e.getText());
		}
		return countryList.size();
	}

	public void changeCountry(String c) {
		btnBusiness.click();
		businessCountry.click();
		selectItem = new Select(businessCountry);
		selectItem.selectByVisibleText(c);
	}
}
