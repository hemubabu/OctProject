package com.stepdefintion;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import com.baseclass.CommonActions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SauceDemoStepDefinition extends CommonActions{
	
	
	
	
	@Given("User launches the application")
	public void user_launches_the_application() {
		
		launchApplication("https://www.saucedemo.com/");;
		
	}

	@When("User enters valid credentials")
	public void user_enters_valid_credentials() {
		WebElement username = driver.findElement(By.id("user-name"));
		enterText(username, "standard_user");
		WebElement password = driver.findElement(By.id("password"));
		enterText(username, "secret_sauce");
	}

	@When("User clicks the login button")
	public void user_clicks_the_login_button() {
		WebElement login = driver.findElement(By.id("login-button"));
		click(login);
	}

	@Then("User should be logged in successfully")
	public void user_should_be_logged_in_successfully() {
		
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("inventory"));
		System.out.println("Valid Login Test Passed");
		quitBrowser();
	 
	}
	
	@When("User enters Invalid credentials")
	public void user_enters_invalid_credentials() {
		WebElement username = driver.findElement(By.id("user-name"));
		enterText(username, "12345");
		WebElement password = driver.findElement(By.id("password"));
		enterText(password, "00000");
	}

	@Then("User should be to see the error message")
	public void user_should_be_to_see_the_error_message() {
		String errorMessage = driver.findElement(By.tagName("h3")).getText();
		Assert.assertTrue(errorMessage.contains("Username and password do not match"));
		System.out.println("Invalid Login Test passed");
		quitBrowser();
	}
	

	@When("User enters valid username {string}")
	public void user_enters_valid_username(String username) {
		WebElement username_field = driver.findElement(By.id("user-name"));
		enterText(username_field, username);
		
   
}

	@When("User enters valid password {string}")
	public void user_enters_valid_password(String password) {
		WebElement password_field = driver.findElement(By.id("password"));
		enterText(password_field, password);
	}
    
}




