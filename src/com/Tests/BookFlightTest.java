package com.Tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Pages.BookFlightPage;
import com.Pages.ConfirmationPage;
import com.Pages.LoginPage;
import com.Pages.SearchFlightPage;
import com.Pages.SelectFlightPage;

public class BookFlightTest extends BaseTest {

	@Test
	public void verifyBookFlightTest() {
		
		LoginPage loginPage = new LoginPage (driver);
		SearchFlightPage searchFlightPage = loginPage.loginAsValidUser(username, password);
		SelectFlightPage selectFlightPage = searchFlightPage.search(fromPort, toPort);
		BookFlightPage bookFlightPage = selectFlightPage.detailsVerify();
		ConfirmationPage confirmationPage = bookFlightPage.bookingInformation(initialName, surName, mobileNumber);

		Assert.assertEquals(confirmationPage.getConfirmationPageHeader().isDisplayed(), true, "Booking Information not Verified");
		Reporter.log("Successful Booking Done with " + initialName + " and " + surName + " and " +mobileNumber+ " mobileNumber" );
		
	}
}
