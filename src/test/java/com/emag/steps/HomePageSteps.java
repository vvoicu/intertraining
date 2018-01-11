package com.emag.steps;

import org.junit.Assert;

import com.emag.pages.header.HeaderPage;
import com.emag.pages.header.LoggedInHeaderPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class HomePageSteps extends ScenarioSteps{

	
	HeaderPage headerPage;
	LoggedInHeaderPage loggedInHeaderPage;
	
	@Step
	public void navigateTo(String url) {
		getDriver().get(url);
		getDriver().manage().window().maximize();
	}
	
	@Step
	public void moveOverOnMyAccountLink() {
		headerPage.waitVisibleMyAccountLink();
	}

	@Step
	public void clickOnLoginSubmenuLink() {
		headerPage.clickOnLoginSubMenuLink();
	}
	
	public String grabLoggedInUserText() {
		headerPage.moveToMyAccount();
		return loggedInHeaderPage.grabAccountTextDropdown();
	}
	
	@Step
	public void verifyText(String expected, String actual) {
		Assert.assertTrue("Values did not match. Expected: " + expected + " , Actual: " + actual, actual.contains(expected));

	}
	
}
