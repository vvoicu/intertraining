package com.emag.tests;

import com.emag.steps.HomePageSteps;
import com.emag.steps.LoginSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class LoginPasswordMessageTest {

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
	
	@Before
	public void setupData() {
		userName = "betina.tudor@gmail.com";
		userPass = "testarebt";
		expectedMessage = "Betina Tudor2";
	}

	@Test
	public void loginPasswordMessageTest() {
		System.out.println("Hamster...");
		homePageSteps.navigateTo(url);
		homePageSteps.moveOverOnMyAccountLink();
		homePageSteps.clickOnLoginSubmenuLink();
		loginSteps.performLogin(userName, userPass);
		loginSteps.verifyPasswordErrorMessage("Te rugam bifeaza \"Nu sunt robot\"");
	}

}
