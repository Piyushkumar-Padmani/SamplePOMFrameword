package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;

public class HomePage extends BaseClass {
	@FindBy(linkText = "My eBay")
	WebElement myEbay;
	@FindBy(css = "#gh-ul-nav li a")
	List<WebElement> myEbayList;
	@FindBy(id = "gh-ac")
	WebElement txtSearch;
	@FindBy(css = "#ui-id-1 li a")
	List<WebElement> searchList;
	@FindBy(css = "#gh-cat option")
	List<WebElement> catList;
	@FindBy(id = "gh-cat")
	WebElement catDropDown;
	@FindBy(xpath = "//td[@class='gf-legal']/a")
	List<WebElement> footerList;
	@FindBy(linkText = "Sign in")
	WebElement btnSignIn;
	@FindBy(linkText = "register")
	WebElement btnRegister;

	public HomePage() {
		super();
		PageFactory.initElements(driver, this);
	}

	public void openBrowser() {
		String url = propertiesReader.getProperty("url");
		driver.get(url);
	}

	public String getPageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public int getMyEbayList() {
		Actions builder = new Actions(driver);
		builder.moveToElement(myEbay).build().perform();
		return myEbayList.size();
	}

	public int search(String s) {
		txtSearch.sendKeys(s);
		return searchList.size();
	}

	public int selectCategoty(String c) {
		catDropDown.click();
		Select item = new Select(catDropDown);
		item.selectByVisibleText(c);

		return catList.size();
	}

	public int getFooterList() {
		return footerList.size();
	}

	public SignInPage openSignInPage() {
		btnSignIn.click();
		return new SignInPage();
	}

	public RegisterPage openRegistrationPage() {
		btnRegister.click();
		return new RegisterPage();
	}

}
