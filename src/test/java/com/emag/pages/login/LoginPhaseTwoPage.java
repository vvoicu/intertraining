package com.emag.pages.login;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class LoginPhaseTwoPage extends PageObject{

	@FindBy(css = "input#password")
	public WebElement passInput;

	@FindBy(css = "div.gui-form-row.custom_error_message")
	private WebElement confirmationMessage;

    @FindBy(css = "button.auth-anchor")
    private WebElement forgetPass;

    @FindBy(css = "p.success")
    private WebElement mesaggePass;

	@FindBy(css = "a.gui-btn")
	private WebElement yahooButton;

//	@FindBy(css = ".auth-submit")
//	public WebElement submitButton;
	
	public void inputPassword(String pass) {
		element(passInput).waitUntilVisible();
		passInput.clear();
		passInput.sendKeys(pass);
	}
	public String getMesaggeText() {
		element(confirmationMessage).waitUntilVisible();
		System.out.println(confirmationMessage.getText());
		return confirmationMessage.getText();
	}
	public void forgetPassword(){
        forgetPass.click();
    }
    public String messagePassword(){
	    return mesaggePass.getText();
    }
	public void yahooButton(){
		yahooButton.click();
	}

//	public void clickOnSubmitButton() {
//		element(submitButton).waitUntilVisible();
//		submitButton.click();
//	}
}
