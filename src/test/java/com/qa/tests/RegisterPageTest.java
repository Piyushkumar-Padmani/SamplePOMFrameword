package com.qa.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.HomePage;
import com.qa.pages.RegisterPage;

public class RegisterPageTest extends BaseClass {
	HomePage homePage;
	RegisterPage registerPage;
	String actualMsg;
	String expectedMsg;
	String error;
	Logger log = Logger.getLogger(RegisterPageTest.class);

	public RegisterPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		log.info("\n***** test execution started *****");
		init();
		homePage = new HomePage();
		homePage.openBrowser();
		registerPage = homePage.openRegistrationPage();
		System.out.println("Before Method");
	}

	@AfterMethod
	public void exit() {
		close();
		System.out.println("After Method");
		log.info("\n***** test execution ended *****");
	}

	@Test(priority = 1)
	public void checkPageTitle() {
		log.info("\n***** checking register page title *****");
		actualMsg = registerPage.getPageTitle();
		expectedMsg = excelReader.getCellData("DataSheet", "Title", 3);
		error = excelReader.getCellData("DataSheet", "FailureMessage", 2);
		Assert.assertEquals(actualMsg, expectedMsg, error);
	}

	@Test(priority = 2)
	public void createAccountWithEmptyFirstName() {
		log.info("\n***** checking createAccountWithEmptyFirstName *****");
		actualMsg = registerPage.checkEmptyFirstName("");
		expectedMsg = excelReader.getCellData("DataSheet", "SuggestionMsg", 2);
		error = excelReader.getCellData("DataSheet", "FailureMessage", 4);
		Assert.assertEquals(actualMsg, expectedMsg, error);
	}

	@Test(priority = 3)
	public void createAccountWithEmptyLastName() {
		log.info("\n***** checking createAccountWithEmptyLastName *****");
		actualMsg = registerPage.checkEmptyLastName("");
		expectedMsg = excelReader.getCellData("DataSheet", "SuggestionMsg", 3);
		error = excelReader.getCellData("DataSheet", "FailureMessage", 4);
		Assert.assertEquals(actualMsg, expectedMsg, error);
	}

	@Test(priority = 4)
	public void createAccountWithEmptyEmail() {
		log.info("\n***** checking createAccountWithEmptyEmail *****");
		actualMsg = registerPage.checkEmptyEmail("");
		expectedMsg = excelReader.getCellData("DataSheet", "SuggestionMsg", 4);
		error = excelReader.getCellData("DataSheet", "FailureMessage", 4);
		Assert.assertEquals(actualMsg, expectedMsg, error);
	}

	@Test(priority = 5)
	public void createAccountWithEmptyPassword() {
		log.info("\n***** checking createAccountWithEmptyPassword *****");
		actualMsg = registerPage.checkEmptyPassword("");
		expectedMsg = excelReader.getCellData("DataSheet", "SuggestionMsg", 5);
		error = excelReader.getCellData("DataSheet", "FailureMessage", 4);
		Assert.assertEquals(actualMsg, expectedMsg, error);
	}

	@Test(priority = 6)
	public void checkPasswordSuggestion() {
		log.info("\n***** checking checkPasswordSuggestion *****");
		actualMsg = registerPage.getPasswordSuggestion("");
		expectedMsg = excelReader.getCellData("DataSheet", "SuggestionMsg", 6);
		error = excelReader.getCellData("DataSheet", "FailureMessage", 4);
		Assert.assertEquals(actualMsg, expectedMsg, error);
	}

	@Test(priority = 7)
	public void createAccountWithEmptyBusinessName() {
		log.info("\n***** checking createAccountWithEmptyBusinessName *****");
		actualMsg = registerPage.checkEmptyBusinessName("");
		expectedMsg = excelReader.getCellData("DataSheet", "SuggestionMsg", 7);
		error = excelReader.getCellData("DataSheet", "FailureMessage", 4);
		Assert.assertEquals(actualMsg, expectedMsg, error);
	}

	@Test(priority = 8)
	public void createAccountWithEmptyBusinessEmail() {
		log.info("\n***** checking createAccountWithEmptyBusinessEmail *****");
		actualMsg = registerPage.checkEmptyBusinessEmail("");
		expectedMsg = excelReader.getCellData("DataSheet", "SuggestionMsg", 4);
		error = excelReader.getCellData("DataSheet", "FailureMessage", 4);
		Assert.assertEquals(actualMsg, expectedMsg, error);
	}

	@Test(priority = 9)
	public void createAccountWithEmptyBusinessPassword() {
		log.info("\n***** checking createAccountWithEmptyBusinessPassword *****");
		actualMsg = registerPage.checkEmptyBusinessPassword("");
		expectedMsg = excelReader.getCellData("DataSheet", "SuggestionMsg", 5);
		error = excelReader.getCellData("DataSheet", "FailureMessage", 4);
		Assert.assertEquals(actualMsg, expectedMsg, error);
	}

	@Test(priority = 10)
	public void getCountryList() {
		log.info("\n***** checking getCountryList *****");
		int actual = registerPage.checkCountryList();
		error = excelReader.getCellData("DataSheet", "FailureMessage", 3);
		Assert.assertEquals(actual, 219, error);
	}

	@Test(priority = 11)
	public void selectCountry() {
		log.info("\n***** checking selectCountry *****");
		registerPage.changeCountry(propertiesReader.getProperty("countryName"));
	}
}
