package com.gipl.lms.core;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;
import static io.github.bonigarcia.wdm.DriverManagerType.FIREFOX;
import static io.github.bonigarcia.wdm.DriverManagerType.IEXPLORER;
import static io.github.bonigarcia.wdm.DriverManagerType.EDGE;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	private WebDriver driver;
	private NgWebDriver ngDriver;
	private final String baseUrl="http://uatlms.seesales.in/";

	public Browser(String browser) {
				
		if("firefox".equalsIgnoreCase(browser)) {
			WebDriverManager.getInstance(FIREFOX).setup();
			driver = new FirefoxDriver(); 
		}
		else if("ie".equalsIgnoreCase(browser)) {
			WebDriverManager.getInstance(IEXPLORER).setup();
			driver = new InternetExplorerDriver(); 
		}

		else if("edge".equalsIgnoreCase(browser)) {
			WebDriverManager.getInstance(EDGE).setup();
			driver = new EdgeDriver(); 
		}
		else {
			WebDriverManager.getInstance(CHROME).setup();
			driver = new ChromeDriver(); 
		}

		ngDriver = new NgWebDriver((JavascriptExecutor) driver);	
		driver.manage().window().maximize();
		driver.get(baseUrl); 
		waitForAngular();
	}

	public WebDriver getDriver() {		
		return driver;
	}

	public NgWebDriver getNgDriver() {		
		return ngDriver;
	}

	public WebElement abs(String pqr)
	{
		return driver==null ? null : driver.findElement(By.xpath(pqr));	
	}

	public WebElement relative(String abc) {
		return driver==null ? null : driver.findElement(By.xpath(abc));
	}
	
	public void waitForAngular() {
		ngDriver.waitForAngularRequestsToFinish();		
	}
	
	public void buttonClickByName(String name) {
		new Actions(driver).moveToElement(driver.findElement(ByAngular.buttonText(name))).click().perform();
		waitForAngular();
	}
	
	public WebElement getByNameAttr(String name) {
		return driver.findElement(By.name(name));
	}

}
