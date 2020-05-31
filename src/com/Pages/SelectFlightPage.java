package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectFlightPage {

	WebDriver driver;

	public SelectFlightPage (WebDriver driver) {

		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@class='frame_header_info'][1]")
	public WebElement HeaderColor;

	@FindBy(xpath = "//form/table[1]/tbody/tr[4]/td/font/font/b")
	public WebElement FlightPrice1;

	@FindBy(xpath = "//form/table[1]/tbody/tr[6]/td/font/font/b")
	public WebElement FlightPrice2;

	@FindBy(xpath = "//form/table[1]/tbody/tr[8]/td/font/font/b")
	public WebElement FlightPrice3;

	@FindBy(xpath = "//form/table[1]/tbody/tr[10]/td/font/font/b")
	public WebElement FlightPrice4;
	
	@FindBy(xpath = "//img[@src='/images/masts/mast_selectflight.gif']")
	public WebElement SelectFlightPageHeader;
	
	@FindBy(xpath = "//input[@name='reserveFlights']")
	public WebElement ReserveFlights;

	// verfication method for the presence of sorted price
	public boolean sortByPrice() {

		boolean order = false;
			String price1 = FlightPrice1.getText();
			String price2 = FlightPrice2.getText();
			String price3 = FlightPrice3.getText();
			String price4 = FlightPrice4.getText();

			if ((price1.compareTo(price2) <= 0) && (price2.compareTo(price3) <= 0) && (price3.compareTo(price4) <= 0)) {
				order = true;
			}
		return order;
	}

	// verfication method for the presence of backgroundcolor blue
	public String getHeaderColor() {
		String color = null;

		color = HeaderColor.getAttribute("bgcolor"); 
		return color;
	}
	
	
	public String getSelectFlightTitle() {
		return driver.getCurrentUrl();
	}
	
		//Define Wait
		public void waitUntilPresenceOfElementLocated(WebElement locator)
		{
			WebDriverWait wait=new WebDriverWait(driver, 60, 1000);
			wait.until(ExpectedConditions.visibilityOf(locator));
		}
		
		public BookFlightPage detailsVerify() {

			waitUntilPresenceOfElementLocated(ReserveFlights);
			ReserveFlights.click();
			return new BookFlightPage(driver);
			
		}
}
