package com.Tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Pages.LoginPage;
import com.Pages.SearchFlightPage;
import com.Pages.SelectFlightPage;

public class SelectFlightTest extends BaseTest{
	
	@Test()
	public void selectFlightTest() {

		String actualColor;
		String expectedColor="#003399";
		boolean verifySortByPrice;
		
		
		LoginPage logInPage = new LoginPage (driver);
		SearchFlightPage searchFlightPage = logInPage.loginAsValidUser(username, password);
		SelectFlightPage selectFlightPage = searchFlightPage.search(fromPort, toPort);
		
		verifySortByPrice = selectFlightPage.sortByPrice();
		Assert.assertEquals(verifySortByPrice, true, "The order of the flights displayed is not sorted on its price");
		Reporter.log("The order of the flights is getting displayed in sorted order on its price");
		
		actualColor = selectFlightPage.getHeaderColor();
		Assert.assertEquals(actualColor,expectedColor,"Colour does not match !!"); 
		Reporter.log("Header Colour Matches to ::- " + expectedColor );

	}
}
