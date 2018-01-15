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
		userName = "paul@yahoo.com";
		userPass = "testarebt";
		expectedMessage = "Iuliana Cozma";
	}

	@Test
	public void loginPasswordMessageTest() {
		System.out.println("Hamster...");
		homePageSteps.navigateTo(url);
		homePageSteps.moveOverOnMyAccountLink();
		homePageSteps.clickOnLoginSubmenuLink();
		loginSteps.performLogin(userName, userPass);
		loginSteps.verifyPasswordErrorMessage("Ai introdus gresit parola sau adresa de email. Te rog completeaza din nou.");
		loginSteps.forgetPasswordButton();
		loginSteps.verifyPasswordText("Informațiile pentru resetarea parolei au fost trimise la adresa ta de email");
		loginSteps.yahooButton();


	}

}
