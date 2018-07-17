package com.stb.hollywood.tests.WAN;

import com.codeborne.selenide.Configuration;
import com.stb.hollywood.steps.AustinPlayerWANSteps;
import com.stb.hollywood.steps.HollywoodSlingboxDemoSteps;
import com.stb.hollywood.utils.BaseListener;
import io.qameta.allure.Step;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import static com.codeborne.selenide.Selenide.open;

@Listeners({BaseListener.class})
public abstract class BaseWANTest {

    private static final String DEFAULT_URL = "http://hollywood.slingbox.com/demos/Austin%20Slingplayer.htm";

//    Venu's link
//    private static final String DEFAULT_URL = "https://hollywood.slingbox.com/drmdemo-austin-v3/app/player.html?debug=true&devTest=true";

    private AustinPlayerWANSteps austinSteps;

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
        austinSteps = new AustinPlayerWANSteps();
        austinSteps.setFinderID("BAAB3FDC56BAD9439B63C4AC826EFCE4");
        austinSteps.setPassword("admin");
    }

    @AfterTest
    @Step("Performing Disconnecting")
    public void Disconnecting() throws InterruptedException {
        austinSteps.clickDisconnectButton();
        austinSteps.delay(5000);
    }
}
