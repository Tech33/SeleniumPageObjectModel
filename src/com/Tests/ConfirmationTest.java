package com.Tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Pages.BookFlightPage;
import com.Pages.ConfirmationPage;
import com.Pages.LoginPage;
import com.Pages.SearchFlightPage;
import com.Pages.SelectFlightPage;

public class ConfirmationTest extends BaseTest{


	@Test
	public void VerifyConfirmationTest() {
	String confirmationNumber;
	
		LoginPage logInPage = new LoginPage (driver);
		SearchFlightPage searchFlightPage = logInPage.loginAsValidUser(username, password);
		SelectFlightPage selectFlightPage = searchFlightPage.search(fromPort, toPort);
		BookFlightPage   bookFlightPage = selectFlightPage.detailsVerify();
		ConfirmationPage confirmationPage = bookFlightPage.bookingInformation(initialName, surName, mobileNumber);
		
		confirmationNumber = confirmationPage.flightConfirmNumber();
		Reporter.log("Captured confirmationNumber is :: " + confirmationNumber );
	
		confirmationPage.signout();
		Assert.assertEquals(logInPage.getLoginTitle().contains("mercurysignon"), true,"un-successful signin");
		Reporter.log("SignOut was successful");
	
	 }

}
