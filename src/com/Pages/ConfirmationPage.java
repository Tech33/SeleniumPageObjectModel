package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ConfirmationPage {

	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {

		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@class='frame_header_info']//descendant::font[contains(text(),'Confirmation')]")
	public WebElement FlightConfirmNumber;

	@FindBy(xpath = "//a[@href='mercurysignoff.php']")
	public WebElement SignOut;

	@FindBy(xpath = "//img[@src='/images/masts/mast_confirmation.gif']")
	public WebElement ConfirmationPageHeader;


	// method for the flight confirmation number
	public String flightConfirmNumber()
	{
	return FlightConfirmNumber.getText();

	}
	// signing off method
	public void signout() {
		
		SignOut.click();
		
	}
	
	public WebElement getConfirmationPageHeader() {

		waitUntilPresenceOfElementLocated(ConfirmationPageHeader);
		return ConfirmationPageHeader;
	}
	
	
	// Define Wait
	public void waitUntilPresenceOfElementLocated(WebElement locator) {
		WebDriverWait wait = new WebDriverWait(driver, 60, 1000);
		wait.until(ExpectedConditions.visibilityOf(locator));
	}
	
}
