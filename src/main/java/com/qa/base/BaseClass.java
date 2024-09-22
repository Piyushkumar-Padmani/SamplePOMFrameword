package com.qa.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.utils.Utilities;
import com.qa.utils.XLSReaderClass;

public class BaseClass {
	public static WebDriver driver;
	public static Properties propertiesReader;
	public static XLSReaderClass excelReader;

	public BaseClass() {
		excelReader = new XLSReaderClass(Utilities.DATA_FILE_PATH);

		try {
			propertiesReader = new Properties();
			FileInputStream fileIn = new FileInputStream(Utilities.PROPERTIES_FILE_PATH);
			propertiesReader.load(fileIn);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	public void init() {
		String browserName = propertiesReader.getProperty("browser");
		driver = browserName.equals("Firefox") ? new FirefoxDriver()
				: browserName.equals("Chrome") ? new ChromeDriver() : new SafariDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
	}

	public void close() {
		driver.quit();
	}
}
