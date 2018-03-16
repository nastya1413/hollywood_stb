package com.stb.hollywood.tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeClass;

import static com.codeborne.selenide.Selenide.open;


public abstract class BaseTest {

    private static final String DEFAULT_URL = "http://hollywood.slingbox.com/demos/Austin%20Slingplayer.htm";

    @BeforeClass
    @Step("WebDriver initialization. WebDriver is Chrome")
    public static void setupClass() {
        Configuration.browser = "chrome";
    }

    @Step("Navigate to http://hollywood.slingbox.com/demos/Austin%20Slingplayer.htm")
    public void openHollywoodURL(){
        open(DEFAULT_URL);
    }


}
