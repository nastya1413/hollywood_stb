package com.stb.hollywood.tests;

import com.google.common.base.Verify;
import com.stb.hollywood.steps.HollywoodSlingboxDemoSteps;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ConnectAndStreamTest extends BaseTest{

    private JavascriptExecutor js;
    private WebDriver driver;
    HollywoodSlingboxDemoSteps hollywoodSteps;

    @Test
    public void testConnectAndStream() throws InterruptedException {

        Float outputBeforeDalay;
        Float outputAfterDelay;
        String script = "return document.getElementById('bitmovinplayer-video-dashPlayer').currentTime;";

        hollywoodSteps = new HollywoodSlingboxDemoSteps();
        openHollywoodURL();
        hollywoodSteps.setFinderID("252300CBA05BAA4397B00C06440C5B4C");
        hollywoodSteps.setPassword("admin");
        hollywoodSteps.clickConnectAndStreamButton();

        if(hollywoodSteps.isPlayerVisible()) {
            driver = getWebDriver();
            js = (JavascriptExecutor) driver;
            outputBeforeDalay = Float.parseFloat((String) js.executeScript(script));

            if (outputBeforeDalay != null) {
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                outputAfterDelay = Float.parseFloat((String) js.executeScript(script));
                Verify.verify(Math.abs(outputBeforeDalay - outputAfterDelay) >= 10);
            } else {
                Assert.fail("Current time shouldn't be null");
            }
        }else{
            Assert.fail("Video player is not visible");
        }
    }
}
