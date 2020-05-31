package com.Tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Pages.LoginPage;
import com.Pages.SearchFlightPage;
import com.Util.Util;


public class LoginTest extends BaseTest {

	String strCountry, strDate_actual, strDate_expected;
	boolean actualimage;
	LoginPage logInPage;

	// Scenario steps begins below

	@BeforeClass
	public void setupenvi() throws IOException {
		setup();
		init();
	}

	@Test
	public void ImageTest() {

		logInPage = new LoginPage(driver);
		strCountry = "Aruba";
		actualimage = logInPage.IsCountryPresent(strCountry); // value of actual
																// image is
																// stored
		assertEquals(actualimage, true, "Country Image Not Found");
		Reporter.log(strCountry + " Country Image Was Found Successfully ");
	}

	@Test
	public void DateTest() {

		logInPage = new LoginPage(driver);
		strDate_actual = logInPage.dateVerify();
		strDate_expected = Util.systemDate();
		assertEquals(strDate_actual.trim(), strDate_expected.trim(), "Website is not showing Current Date");
		Reporter.log("Website is showing Current Date " + strDate_expected);
	}

	@Test(priority = 2, dataProvider = "users")
	public void loginTestCheck(String username, String password, String validity) {
		
		logInPage = new LoginPage(driver);
		if (validity.equals("invalid")) {
			
			logInPage.loginAsInvalidUser(username,password);
			Assert.assertEquals(logInPage.getLoginTitle().contains("mercurysignon"), true,"successful signin");
			Reporter.log("Login was not successful with incorrect UserId " + username + " and Password " + password );	
		
		} else {
			
			SearchFlightPage searchFlightPage = logInPage.loginAsValidUser(username, password);
			Assert.assertEquals(searchFlightPage.getSearchFlightTitle().contains("mercuryreservation"), true, "Un-successful signin");
			Reporter.log("Login was not successful with correct UserId " + username + " and Password " + password  );
		}

	
	}

	
	@DataProvider
	public Object[][] users() {
		Object[][] data = new Object[3][3];

		// 1st row
		data[0][0] = "mercury";
		data[0][1] = "mercury1";
		data[0][2] = "invalid";

		// 2nd row
		data[1][0] = "mercury";
		data[1][1] = "mercury2";
		data[1][2] = "invalid";
		
		// 3rd row
		data[2][0] = "mercury";
		data[2][1] = "mercury";
		data[2][2] = "valid";
		
		return data;
	}

	@AfterClass
	public void Tearenvir() {
		tearDown();
	}
}
