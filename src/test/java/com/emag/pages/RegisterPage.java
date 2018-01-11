package com.emag.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.stream.Collectors;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

public class RegisterPage extends PageObject{

    @FindBy(css = "p.description")
    private WebElement noAccountMessage;

    public String grabNoAccountText(){
        element(noAccountMessage).waitUntilVisible();
        return noAccountMessage.getText();
    }
}
