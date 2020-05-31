package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='userName']")
	public WebElement username;

	@FindBy(xpath = "//input[@name='password']")
	public WebElement password;

	@FindBy(xpath = "//input[@name='login']")
	public WebElement loginButton;

	@FindBy(xpath = "//img[@src='/images/featured_destination.gif']")
	public WebElement FeaturedDestination;

	@FindBy(xpath = "//form[@name='home']/table/tbody/tr/td/font/b")
	public WebElement DateVerifyElement;


	public boolean IsCountryPresent(String Country) {

		String field_value = FeaturedDestination.getAttribute("alt");

		if (field_value.contains(Country))
			return true;
		else
			return false;
	}

	// method for date verify
	public String dateVerify() {
		String Date_actual = null;
		Date_actual = DateVerifyElement.getText();
		return Date_actual;
	}

	//Set user name in textbox
	public void setUserName(String userName){
		username.sendKeys(userName);
		
	}
	
	//Set password in password textbox
	public void setPassword(String pwd){
		password.sendKeys(pwd);
	}
	
	//Click on login button
	public void clickLogin(){
		loginButton.click();
	}
	
	//Get the title of Login Page
	public String getLoginTitle(){
	 return	driver.getCurrentUrl();
	}

	
	public SearchFlightPage loginAsValidUser(String userName, String pwd){
		this.setUserName(userName);
		//Fill password
		this.setPassword(userName);
		//Click Login button
		this.clickLogin();
		return new SearchFlightPage(driver);
	}

	public LoginPage loginAsInvalidUser(String userName, String pwd){
		username.sendKeys(userName);
		password.sendKeys(pwd);
		loginButton.click();
		return this;
	}
	
}
