package com.gipl.lms.test;

import static org.testng.Assert.assertTrue;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Configuration;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.gipl.lms.core.Browser;
import com.gipl.lms.core.TestData;
import com.gipl.lms.core.TestDataSet;
import com.gipl.lms.model.MTest;
import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;

public class Login {
	private final String TEST_ID="login";
	private WebDriver driver;
	private Browser browser;

	@Test(dataProvider = "tests")
	public void test(final MTest test) {

		System.out.println("LOGIN TEST START");
		try {		
			TestData testData = new TestData(test);

			WebElement email = browser.abs("/html[1]/body[1]/app-root[1]/app-login[1]/div[1]/div[1]/div[1]/form[1]/div[1]/input[1]");
			WebElement pass = browser.getByNameAttr("pass");

			browser.waitForAngular();
			email.sendKeys(testData.get("email"));
			pass.sendKeys(testData.get("password"));
			browser.waitForAngular();

			browser.buttonClickByName("Login");

			if(driver.getCurrentUrl().contains("app")) {	
				browser.abs("/html[1]/body[1]/app-root[1]/app-main[1]/div[1]/div[1]/app-header[1]/nav[1]/div[1]/div[2]/ul[1]/li[1]/a[1]/i[1]").click();
				browser.waitForAngular();
			}					

			System.out.println("LOGIN TEST DONE");
			assertTrue(true);	
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}

	}

	@BeforeTest
	@Parameters("browser")
	public void setup(String brow)  throws Exception{
		browser = new Browser(brow);
		driver = browser.getDriver();  
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	@AfterSuite
	public void afterSuite() {
		driver.quit();
	}

	@DataProvider
	private  Object[][] tests() {
		return  new TestDataSet().getByTestID(TEST_ID);
	}
}
