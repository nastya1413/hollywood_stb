package com.stb.hollywood.tests.LAN;

import com.codeborne.selenide.Configuration;
import com.stb.hollywood.steps.AustinPlayerLANSteps;
import com.stb.hollywood.utils.BaseListener;
import io.qameta.allure.Step;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import static com.codeborne.selenide.Selenide.open;

@Listeners({BaseListener.class})
public abstract class BaseLANTest {

    private static final String DEFAULT_URL = "http://hollywood.slingbox.com/airtv-desktop-player-v26/htmls/player.html?ip=true";

    private AustinPlayerLANSteps austinSteps;

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
        austinSteps = new AustinPlayerLANSteps();
        austinSteps.setBoxIP("192.168.40.56");
        austinSteps.setBoxPort("5118");
        austinSteps.setPassword("admin");
    }

    @AfterTest
    @Step("Performing Disconnecting")
    public void Disconnecting() throws InterruptedException {
        austinSteps.clickDisconnectButton();
        austinSteps.delay(5000);
    }
}
