package com.emag.tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.emag.steps.HomePageSteps;
import com.emag.steps.LoginSteps;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("logindata.csv")
public class LoginEmagTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	public String url = "https://www.emag.ro/";
	public String userName;
	public String userPass;
	public String expectedMessage;

	@Steps
	public HomePageSteps homePageSteps;
	@Steps
	public LoginSteps loginSteps;
	
	@Qualifier
	public String getTestLabel() {
		return userName + "--" + userPass + "--" + expectedMessage;
	}
	
//	@Before
//	public void setupData() {
//		userName = "betina.tudor@gmail.com";
//		userPass = "testarebt1";
//		expectedMessage = "Betina Tudor2";
//	}

	@Test
	public void loginToEmagTest() {
		System.out.println("Hamster...");
		homePageSteps.navigateTo(url);
		homePageSteps.moveOverOnMyAccountLink();
		homePageSteps.clickOnLoginSubmenuLink();

		loginSteps.performLogin(userName, userPass);
		homePageSteps.moveOverOnMyAccountLink();
		String actualData = homePageSteps.grabLoggedInUserText();

		System.out.println("Data: " + actualData);
		
		homePageSteps.verifyText("Betina Tudor", actualData);
		homePageSteps.verifyText(expectedMessage, actualData);
	}

}