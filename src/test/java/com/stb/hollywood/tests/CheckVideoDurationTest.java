package com.stb.hollywood.tests;

import com.stb.hollywood.steps.HollywoodSlingboxDemoSteps;
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

public class CheckVideoDurationTest extends BaseTest{

    private JavascriptExecutor js;
    private WebDriver driver;
    HollywoodSlingboxDemoSteps hollywoodSteps;
    JScripts script = new JScripts();

    @Feature("Streaming")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Checking the video duration using Connect and Stream button")
    @Test
    public void testVideoDuration() throws InterruptedException {

        Double outputBeforeDelay;
        Double outputAfterDelay;

        hollywoodSteps = new HollywoodSlingboxDemoSteps();
        openHollywoodURL();
        setDefaultCredentials();
        hollywoodSteps.clickConnectAndStreamButton();

        if(hollywoodSteps.isPlayerVisible()) {
            driver = getWebDriver();
            js = (JavascriptExecutor) driver;

            hollywoodSteps.waitForStreaming();
            outputBeforeDelay = new Double(js.executeScript(script.getCurrentTime()).toString());

            if (outputBeforeDelay != null) {
                hollywoodSteps.delay(15000);
                outputAfterDelay = new Double(js.executeScript(script.getCurrentTime()).toString());
                hollywoodSteps.diffShouldBeMoreThan(outputAfterDelay, outputBeforeDelay, 10);
            } else {
                Assert.fail("Current time shouldn't be null");
            }
        }else{
            Assert.fail("Video player is not visible");
        }
    }
}
