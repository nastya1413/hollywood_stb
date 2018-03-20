package com.stb.hollywood.tests;

import com.codeborne.selenide.Configuration;
import com.stb.hollywood.steps.HollywoodSlingboxDemoSteps;
import com.stb.hollywood.utils.BaseListener;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import static com.codeborne.selenide.Selenide.open;

@Listeners({BaseListener.class})
public abstract class BaseTest {

    private static final String DEFAULT_URL = "http://hollywood.slingbox.com/demos/Austin%20Slingplayer.htm";
    private HollywoodSlingboxDemoSteps hollywoodSteps;

    @BeforeClass
    @Step("WebDriver initialization. WebDriver is Chrome")
    public static void setupClass() {
        Configuration.browser = "chrome";
    }

    @Step("Navigate to http://hollywood.slingbox.com/demos/Austin%20Slingplayer.htm")
    public void openHollywoodURL(){
        open(DEFAULT_URL);
    }

    @Step("Setting the default credentials")
    public void setDefaultCredentials (){
        hollywoodSteps = new HollywoodSlingboxDemoSteps();
        hollywoodSteps.setFinderID("252300CBA05BAA4397B00C06440C5B4C");
        hollywoodSteps.setPassword("admin");
    }
}
