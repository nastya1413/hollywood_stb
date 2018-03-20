package com.stb.hollywood.tests;

import com.stb.hollywood.steps.HollywoodSlingboxDemoSteps;
import com.stb.hollywood.utils.BaseListener;
import com.stb.hollywood.utils.JScripts;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Listeners({BaseListener.class})
public class CheckPauseFunctionTest extends BaseTest{
    private JavascriptExecutor js;
    private WebDriver driver;
    HollywoodSlingboxDemoSteps hollywoodSteps;
    JScripts script = new JScripts();

    @Feature("Streaming")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Checking the 'Pause' functionality")
    @Test
    public void testStreamingPause() throws InterruptedException {

        Double pauseStreamTime;
        Double pauseStreamTimeWithDelay;
        Boolean isPaused;
        hollywoodSteps = new HollywoodSlingboxDemoSteps();

        driver = getWebDriver();
        js = (JavascriptExecutor) driver;

        openHollywoodURL();
        setDefaultCredentials();
        hollywoodSteps.clickConnectAndStreamButton();

        if (hollywoodSteps.isPlayerVisible()) {
            hollywoodSteps.waitForStreaming();
            hollywoodSteps.delay(10000);
            hollywoodSteps.clickPauseButton();

            isPaused = new Boolean(js.executeScript(script.isVideoPaused()).toString());
            if (isPaused){
                pauseStreamTime = new Double(js.executeScript(script.getCurrentTime()).toString());
                hollywoodSteps.delay(10000);
                pauseStreamTimeWithDelay = new Double(js.executeScript(script.getCurrentTime()).toString());

                hollywoodSteps.diffShouldBeLessThan(pauseStreamTimeWithDelay, pauseStreamTime, 1);

                hollywoodSteps.clickDisconnectButton();
            } else {
                Assert.fail("Video wasn't paused");
            }
        } else {
            Assert.fail("Video player is not visible");
        }
    }
}
