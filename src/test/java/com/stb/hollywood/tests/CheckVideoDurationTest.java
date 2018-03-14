package com.stb.hollywood.tests;

import com.google.common.base.Verify;
import com.stb.hollywood.steps.HollywoodSlingboxDemoSteps;
import com.stb.hollywood.utils.JScripts;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class CheckVideoDurationTest extends BaseTest{

    private JavascriptExecutor js;
    private WebDriver driver;
    HollywoodSlingboxDemoSteps hollywoodSteps;
    JScripts script = new JScripts();

    @Test
    @Description("Checking the video duration using Connect and Stream button")
    public void testVideoDuration() throws InterruptedException {

        Double outputBeforeDelay;
        Double outputAfterDelay;

        hollywoodSteps = new HollywoodSlingboxDemoSteps();
        openHollywoodURL();
        hollywoodSteps.setFinderID("252300CBA05BAA4397B00C06440C5B4C");
        hollywoodSteps.setPassword("admin");
        hollywoodSteps.clickConnectAndStreamButton();

        if(hollywoodSteps.isPlayerVisible()) {
            driver = getWebDriver();
            js = (JavascriptExecutor) driver;

            hollywoodSteps.waitForStreaming();
            outputBeforeDelay = new Double(js.executeScript(script.getCurrentTime()).toString());

            if (outputBeforeDelay != null) {
                hollywoodSteps.delay(15000);
                outputAfterDelay = new Double(js.executeScript(script.getCurrentTime()).toString());
                Assert.assertTrue((outputAfterDelay - outputBeforeDelay) >= 10,
                        String.format(
                                "Difference is less than 10 between 'outputAfterDelay' and 'outputBeforeDelay'. " +
                                        "The 'outputBeforeDelay value is %f, 'outputAfterDelay' value is %f",
                                outputBeforeDelay, outputAfterDelay));
            } else {
                Assert.fail("Current time shouldn't be null");
            }
        }else{
            Assert.fail("Video player is not visible");
        }
    }
}
