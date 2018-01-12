package com.emag.steps;

import com.emag.pages.login.LoginPhaseOnePage;
import com.emag.pages.login.LoginPhaseTwoPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import org.junit.Assert;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class LoginSteps {

	LoginPhaseOnePage loginPhaseOnePage;
	LoginPhaseTwoPage loginPhaseTwoPage;
	
	@StepGroup
	public void performLogin(String user, String pass) {
		inputUsername(user);
		clickOnSubmit();
		inputPassword(pass);
		clickOnSubmit();
	}
	
	
	@Step
	public void inputUsername(String user) {
		loginPhaseOnePage.inputUsername(user);
	}

	@Step
	public void clickOnSubmit() {
		loginPhaseOnePage.clickOnSubmitButton();
	}
	
	@Step
	public void inputPassword(String pass) {
		loginPhaseTwoPage.inputPassword(pass);
	}

	public void verifyPasswordErrorMessage(String text){
		Assert.assertTrue("Expected: " + text + ", Actual: " + loginPhaseTwoPage.getMesaggeText(), loginPhaseTwoPage.getMesaggeText().contains(text));
	}

}
