package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class SignInPage extends BaseClass {
	@FindBy(css = "#userid")
	WebElement txtEmail;

	@FindBy(css = "#signin-continue-btn")
	WebElement btnContinue;

	public SignInPage() {
		super();
		PageFactory.initElements(driver, this);
	}

	public String getPageTitle() {
		String title = driver.getTitle();
		return title;
	}

}
