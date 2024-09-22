package com.qa.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.HomePage;

public class HomePageTest extends BaseClass {
	HomePage homePage;
	Logger log = Logger.getLogger(HomePageTest.class);
	String error;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		log.info("\n***** test execution started *****");
		init();
		homePage = new HomePage();
		homePage.openBrowser();
		System.out.println("Before Method");
	}

	@AfterMethod
	public void exit() {
		close();
		System.out.println("After Method");
		log.info("\n***** test execution ended *****");
	}

	@Test(priority = 1)
	public void checkTitle() {
		log.info("\n***** checking home page title *****");
		String actualTitle = homePage.getPageTitle();
		String expectedTitle = excelReader.getCellData("DataSheet", "Title", 2);
		error = excelReader.getCellData("DataSheet", "FailureMessage", 2);
		Assert.assertEquals(actualTitle, expectedTitle, error);
	}

	@Test(priority = 2)
	public void myEbayList() {
		log.info("\n***** checking myEbayList *****");
		int myEbaySize = homePage.getMyEbayList();
		error = excelReader.getCellData("DataSheet", "FailureMessage", 3);
		Assert.assertEquals(myEbaySize, 10, error);
	}

	@Test(priority = 3)
	public void searchThing() {
		log.info("\n***** checking searchList *****");
		int searchResult = homePage.search(propertiesReader.getProperty("search"));
		error = excelReader.getCellData("DataSheet", "FailureMessage", 3);
		Assert.assertEquals(searchResult, 10, error);
	}

	@Test(priority = 4)
	public void changeCategory() {
		log.info("\n***** checking changeCategory *****");
		int catListSize = homePage.selectCategoty(propertiesReader.getProperty("category"));
		error = excelReader.getCellData("DataSheet", "FailureMessage", 3);
		Assert.assertEquals(catListSize, 36, error);
	}

	@Test(priority = 5)
	public void checkFooterList() {
		log.info("\n***** checking footerList *****");
		int footerListSize = homePage.getFooterList();
		error = excelReader.getCellData("DataSheet", "FailureMessage", 3);
		Assert.assertEquals(footerListSize, 5, error);
	}
}
