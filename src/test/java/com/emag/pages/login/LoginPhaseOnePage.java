package com.emag.pages.login;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class LoginPhaseOnePage extends PageObject{

	@FindBy(css = "input#email")
	public WebElement usernameInput;
	
	@FindBy(css = ".auth-submit")
	public WebElement submitButton;
	
	public void inputUsername(String user) {
		element(usernameInput).waitUntilVisible();
		usernameInput.clear();
		usernameInput.sendKeys(user);
	}
	
	public void clickOnSubmitButton() {
		element(submitButton).waitUntilVisible();
		submitButton.click();
	}
}
