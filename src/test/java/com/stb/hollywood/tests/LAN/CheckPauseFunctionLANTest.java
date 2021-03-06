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

public class CheckPauseFunctionLANTest extends BaseLANTest {
    private JavascriptExecutor js;
    private WebDriver driver;
    AustinPlayerLANSteps austinSteps;
    JScripts script = new JScripts();

    @Feature("Streaming")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Checking the 'Pause' functionality")
    @Test
    public void testStreamingPause() throws InterruptedException {

        Double pauseStreamTime;
        Double pauseStreamTimeWithDelay;
        Boolean isPaused;
        austinSteps = new AustinPlayerLANSteps();

        driver = getWebDriver();
        js = (JavascriptExecutor) driver;

        openHollywoodURL();
        setDefaultCredentials();
        austinSteps.clickConnectAndStreamButton();

        if (austinSteps.isPlayerVisible()) {
            austinSteps.waitForStreaming();
            austinSteps.delay(10000);
            austinSteps.clickPauseButton();

            isPaused = new Boolean(js.executeScript(script.isVideoPaused()).toString());
            if (isPaused){
                pauseStreamTime = new Double(js.executeScript(script.getCurrentTime()).toString());
                austinSteps.delay(10000);
                pauseStreamTimeWithDelay = new Double(js.executeScript(script.getCurrentTime()).toString());

                austinSteps.diffShouldBeLessThan(pauseStreamTimeWithDelay, pauseStreamTime, 1);
            } else {
                Assert.fail("Video wasn't paused");
            }
        } else {
            Assert.fail("Video player is not visible");
        }
    }
}
