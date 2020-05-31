package com.Tests;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Pages.LoginPage;
import com.Pages.SearchFlightPage;
import com.Pages.SelectFlightPage;

public class SearchFlightTest extends BaseTest {
	
	@Test
	public void searchFlightTest() {
		
		LoginPage logInPage = new LoginPage (driver);
		SearchFlightPage searchFlightPage = logInPage.loginAsValidUser(username, password);
		
		List<WebElement> departingPortList = searchFlightPage.getDepartingPorts(fromPort);
		boolean departingPortsCheck = false;
		for( WebElement we : departingPortList) {
		    if(we.getText().equals("London")) {
		    	departingPortsCheck=true;
		        break;
		    }
		}
		Assert.assertEquals(departingPortsCheck, true, "Place in dropdown not found");
		Reporter.log( fromPort + " Place in dropdown was found successful ");
		SelectFlightPage selectFlightPage = searchFlightPage.search(fromPort, toPort);
		Assert.assertEquals(selectFlightPage.getSelectFlightTitle().contains("mercuryreservation2"), true,"Un-successful Search");
		Reporter.log("Search of " + fromPort + " and " + toPort + " was Successful");
		
	}

}