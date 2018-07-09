package com.stb.hollywood.tests;

import com.stb.hollywood.steps.HollywoodSlingboxDemoSteps;
import com.stb.hollywood.utils.JScripts;
import com.stb.hollywood.utils.LogUtil;
import io.qameta.allure.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.Log4JLogger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class ConnectAndStreamTest extends BaseTest{

    private JavascriptExecutor js;
    private WebDriver driver;
    HollywoodSlingboxDemoSteps hollywoodSteps;
    JScripts script = new JScripts();
    String boxStatus = "";
    Boolean isControlsVisible = false;

    @Feature("Streaming")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Checking the connection to STB and a streaming")
    @Test
    public void testConnectionAndStreaming() throws InterruptedException {
        Double outputBeforeDelay;
        Double outputAfterDelay;
        SoftAssert softassertion = new SoftAssert();

        hollywoodSteps = new HollywoodSlingboxDemoSteps();
        openHollywoodURL();
        setDefaultCredentials();
        hollywoodSteps.clickConnectButton();
        hollywoodSteps.clickStartStreamingButton();
        hollywoodSteps.delay(10000);

        boxStatus = hollywoodSteps.getBoxStatusText();


        if(hollywoodSteps.isPlayerVisible()) {
            driver = getWebDriver();
            js = (JavascriptExecutor) driver;

            checkStreanmingStatus(js, boxStatus);

            isControlsVisible = Boolean.parseBoolean(script.isControlsVisible());
            if (!isControlsVisible){

                softassertion.fail("Player controls are not visible.");

//                Reporter.getCurrentTestResult().setAttribute("warn", "Player controls are not visible.");
            } else {
                LogUtil.log("Player controls are visible.");
            }

            outputBeforeDelay = new Double(js.executeScript(script.getCurrentTime()).toString());
            if (outputBeforeDelay != null) {
                hollywoodSteps.delay(180000);
                outputAfterDelay = new Double(js.executeScript(script.getCurrentTime()).toString());
                hollywoodSteps.diffShouldBeMoreThan(outputAfterDelay, outputBeforeDelay, 150);

                hollywoodSteps.clickDisconnectButton();
            } else {
                Assert.fail("Current time shouldn't be null");
            }
        }else {
            Assert.fail("Video player is not visible");
        }
        softassertion.assertAll();
    }

    public void checkStreanmingStatus(JavascriptExecutor js, String status ){
        if(!status.equals("STREAMING"))
        {
            Assert.fail("Streaming wasn't successful. Current Box status is: " + boxStatus);
        } else {
            LogUtil.log("Streaming is in progress");
            LogUtil.log("Video Height is: " + js.executeScript(script.getVideoHeight()).toString());
            LogUtil.log("VideoWidth is: " + js.executeScript(script.getVideoWidth()).toString());
        }
    }
}

