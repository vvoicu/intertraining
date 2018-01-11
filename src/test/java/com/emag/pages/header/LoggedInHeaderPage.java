package com.emag.pages.header;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class LoggedInHeaderPage extends PageObject{

//	@FindBy(css = "#my_account")
//	private WebElement myAccountLink;
	
	@FindBy(css = ".my-account-dropdown-logged-in strong")
	public WebElement accountDropdown;

	
	
	public String grabAccountTextDropdown() {
		element(accountDropdown).waitUntilVisible();
		return accountDropdown.getText();
	}
}
