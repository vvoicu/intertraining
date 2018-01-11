package com.emag.steps;

import com.emag.pages.RegisterPage;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;


public class RegisterSteps extends ScenarioSteps {
    RegisterPage registerPage;

    @Step
    public String grabNoAccountText(){
        return registerPage.grabNoAccountText();
    }
}
