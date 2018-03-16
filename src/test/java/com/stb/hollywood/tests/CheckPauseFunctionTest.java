package com.stb.hollywood.tests;

import com.stb.hollywood.steps.HollywoodSlingboxDemoSteps;
import com.stb.hollywood.utils.JScripts;
import io.qameta.allure.Description;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class CheckPauseFunctionTest extends BaseTest{
    private JavascriptExecutor js;
    private WebDriver driver;
    HollywoodSlingboxDemoSteps hollywoodSteps;
    JScripts script = new JScripts();

    @Test
    @Description("Checking the 'Pause' functionality")
    public void testStreamingPause() throws InterruptedException {

        Double pauseStreamTime;
        Double pauseStreamTimeWithDelay;
        Boolean isPaused;
        hollywoodSteps = new HollywoodSlingboxDemoSteps();

        driver = getWebDriver();
        js = (JavascriptExecutor) driver;

        openHollywoodURL();
        hollywoodSteps.setFinderID("252300CBA05BAA4397B00C06440C5B4C");
        hollywoodSteps.setPassword("admin");
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
