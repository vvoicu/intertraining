package com.emag.pages.login;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class LoginPhaseTwoPage extends PageObject{

	@FindBy(css = "input#password")
	public WebElement passInput;
	
//	@FindBy(css = ".auth-submit")
//	public WebElement submitButton;
	
	public void inputPassword(String pass) {
		element(passInput).waitUntilVisible();
		passInput.clear();
		passInput.sendKeys(pass);
	}
	
//	public void clickOnSubmitButton() {
//		element(submitButton).waitUntilVisible();
//		submitButton.click();
//	}
}
