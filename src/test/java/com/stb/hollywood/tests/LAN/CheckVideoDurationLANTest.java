package com.stb.hollywood.tests.LAN;

import com.stb.hollywood.steps.AustinPlayerLANSteps;
import com.stb.hollywood.tests.LAN.BaseLANTest;
import com.stb.hollywood.utils.JScripts;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class CheckVideoDurationLANTest extends BaseLANTest {

    private JavascriptExecutor js;
    private WebDriver driver;
    AustinPlayerLANSteps austinSteps;
    JScripts script = new JScripts();

    @Feature("Streaming")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Checking the video duration using Connect and Stream button")
    @Test
    public void testVideoDuration() throws InterruptedException {

        Double outputBeforeDelay;
        Double outputAfterDelay;

        austinSteps = new AustinPlayerLANSteps();
        openHollywoodURL();
        setDefaultCredentials();
        austinSteps.clickConnectAndStreamButton();
        austinSteps.delay(10000);

        if(austinSteps.isPlayerVisible()) {
            driver = getWebDriver();
            js = (JavascriptExecutor) driver;

            austinSteps.waitForStreaming();
            outputBeforeDelay = new Double(js.executeScript(script.getCurrentTime()).toString());

            if (outputBeforeDelay != null) {
                austinSteps.delay(150000);
                outputAfterDelay = new Double(js.executeScript(script.getCurrentTime()).toString());
                austinSteps.diffShouldBeMoreThan(outputAfterDelay, outputBeforeDelay, 120);
            } else {
                Assert.fail("Current time shouldn't be null");
            }
        }else{
            Assert.fail("Video player is not visible");
        }
    }
}
