package com.qa.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.HomePage;
import com.qa.pages.SignInPage;

public class SignInPageTest extends BaseClass {
	HomePage homePage;
	SignInPage signInPage;
	Logger log = Logger.getLogger(SignInPageTest.class);
	String error;

	public SignInPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		log.info("\n***** test execution started *****");
		init();
		homePage = new HomePage();
		homePage.openBrowser();
		signInPage = homePage.openSignInPage();
		System.out.println("Before Method");
	}

	@AfterMethod
	public void exit() {
		close();
		System.out.println("After Method");
		log.info("\n***** test execution ended *****");
	}

	@Test
	public void checkPageTitle() {
		log.info("\n***** checking signin page title *****");
		String actual = signInPage.getPageTitle();
		String expected = excelReader.getCellData("DataSheet", "Title", 4);
		error = excelReader.getCellData("DataSheet", "FailureMessage", 2);
		Assert.assertEquals(actual, expected, error);
	}

}
