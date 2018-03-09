package com.stb.hollywood.tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;

import static com.codeborne.selenide.Selenide.open;


public abstract class BaseTest {

    private static final String DEFAULT_URL = "http://hollywood.slingbox.com/demos/Austin%20Slingplayer.htm";

    @BeforeClass
    public static void setupClass() {
        Configuration.browser = "chrome";
    }

    public void openHollywoodURL(){
        open(DEFAULT_URL);
    }
}
