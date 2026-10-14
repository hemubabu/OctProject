package com.baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonActions {
	
	public static WebDriver driver;
	
	public void launchApplication(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	public void enterText(WebElement element,String textvalue) {
		
		element.sendKeys(textvalue);
		
	}
	
	public void click(WebElement element) {
		element.click();
	}
	
	public void quitBrowser() {
		if(driver!=null) {
			driver.quit();
		}
	}

}
