package com.emag.pages.header;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class HeaderPage extends PageObject {
	
	@FindBy(css = "#my_account")
	private WebElement myAccountLink;
	
	@FindBy(css = "a.btn-emag i")
	private WebElement loginLink;
		
	public void waitVisibleMyAccountLink() {
		element(myAccountLink).waitUntilVisible();
	}
	
	public void moveToMyAccount() {
		element(myAccountLink).waitUntilVisible();
		Actions action = new Actions(getDriver());
		action.moveToElement(myAccountLink).build().perform();
	}

	public void clickOnLoginSubMenuLink() {
		element(loginLink).waitUntilVisible();
		loginLink.click();
	}
}
