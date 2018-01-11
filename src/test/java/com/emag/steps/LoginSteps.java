package com.emag.steps;

import com.emag.pages.login.LoginPhaseOnePage;
import com.emag.pages.login.LoginPhaseTwoPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

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

}
