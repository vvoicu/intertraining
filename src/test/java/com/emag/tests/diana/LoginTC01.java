package com.emag.tests.diana;

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

public class LoginTC01 {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    public String url = "https://www.emag.ro/";
    public String userName;
    public String userPass;
    public String expectedMessage;
    public String userWrongPass;


    @Steps
    public HomePageSteps homePageSteps;
    @Steps
    public LoginSteps loginSteps;

    @Before
    public void setupData() {
        userName = "betina";
        userPass = "testareBT";
        expectedMessage = "Nu sunt robot";
    }


    @Test
    public void attemptLoginCaptcha() throws InterruptedException {
        homePageSteps.navigateTo(url);

        homePageSteps.moveOverOnMyAccountLink();
        homePageSteps.clickOnLoginSubmenuLink();

        loginSteps.inputUsername(userName);
        loginSteps.clickOnSubmit();

        for (int i = 1; i<=6; i++){
            loginSteps.inputPassword(userWrongPass);
            loginSteps.clickOnSubmit();
        }

        homePageSteps.verifyText(expectedMessage, loginSteps.grabCatpchaText());

        loginSteps.inputPassword(userPass);
        loginSteps.clickOnSubmit();

    }

}
