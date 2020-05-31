package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookFlightPage {
	
	WebDriver driver;

	public BookFlightPage (WebDriver driver) {

		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@name='passFirst0']")
	public WebElement InitialName;

	@FindBy(xpath = "//*[@name='passLast0']")
	public WebElement SurName;

	@FindBy(xpath = "//*[@name='creditnumber']")
	public WebElement MobileNumber;

	@FindBy(xpath = "//*[@name='buyFlights']")
	public WebElement BuyFlights;

	
	// verfication method for the booking information
	public ConfirmationPage bookingInformation(String initialName, String surName, String mobileNumber) {
		
			// entering the first name for the booking
			waitUntilPresenceOfElementLocated(InitialName);
			InitialName.sendKeys(initialName);
			// entering the last name for the booking
			SurName.sendKeys(surName);
			// entering the phone number
			MobileNumber.sendKeys(mobileNumber);
			// clicking the submit button
			BuyFlights.click();
			return new ConfirmationPage(driver);
			
			}

	// verfication method for the details

	//Define Wait
	public void waitUntilPresenceOfElementLocated(WebElement locator)
	{
		WebDriverWait wait=new WebDriverWait(driver, 60, 1000);
		wait.until(ExpectedConditions.visibilityOf(locator));
	}

}