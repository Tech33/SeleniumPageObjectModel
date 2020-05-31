package com.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchFlightPage {
	
		WebDriver driver;

		public SearchFlightPage (WebDriver driver) {
			
			this.driver = driver;
			
			PageFactory.initElements(driver, this);
		}

		@FindBy(xpath = "//*[@name='fromPort']")
		public WebElement FromPort;

		@FindBy(xpath = "//*[@name='toPort']")
		public WebElement ToPort;

		@FindBy(xpath = "//*[@name='servClass']")
		public WebElement ServClass;

		@FindBy(xpath = "//input[@name='findFlights']")
		public WebElement FindFlights;

	

	public String getSearchFlightTitle() {
		return driver.getCurrentUrl();
	}

	// verification method of the presence of value LONDON
	public List<WebElement> getDepartingPorts(String fromPort) {
		return new Select(FromPort).getOptions(); 
	}

	public SelectFlightPage search(String fromPort, String toPort) {

		// selecting from place
		new Select(FromPort).selectByValue(fromPort);;
		// selecting toplace
		new Select(ToPort).selectByValue(toPort);;
		// selecting type of class
		ServClass.click();
		FindFlights.click();
//		waitUntilPresenceOfElementLocated(FlightApplicationOR.ReserveFlights, 60);
		return new SelectFlightPage(driver);

	}

}
