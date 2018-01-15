package com.emag.tests;

import com.emag.steps.HomePageSteps;
import com.emag.steps.LoginSteps;
import com.emag.steps.RegisterSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Qualifier;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
//@UseTestDataFrom("logindata.csv")
public class RegisterViaLoginTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	public String url = "https://www.emag.ro/";
	public String userName;
	public String userPass;
	public String expectedMessage;
	public String noAccountMessage;

	@Steps
	public HomePageSteps homePageSteps;
	@Steps
	public LoginSteps loginSteps;
	@Steps
	public RegisterSteps registerSteps;
	
	@Before
	public void setupData() {
		userName = "betdsina.tudor@gmail.com";
		userPass = "testarebt1";
		expectedMessage = "Betina Tudor2";
		noAccountMessage = "Se pare ca nu ai un cont eMAG";
	}

	@Test
	public void loginWithInexitentUser(){
		homePageSteps.navigateTo(url);

		homePageSteps.moveOverOnMyAccountLink();
		homePageSteps.clickOnLoginSubmenuLink();

		loginSteps.inputUsername(userName);
		loginSteps.clickOnSubmit();

		String actual = registerSteps.grabNoAccountText();
		homePageSteps.verifyText(noAccountMessage,actual);
		System.out.println(registerSteps.grabNoAccountText());
	}

}
