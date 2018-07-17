package com.stb.hollywood.tests.WAN;

import com.stb.hollywood.steps.AustinPlayerWANSteps;
import com.stb.hollywood.steps.HollywoodSlingboxDemoSteps;
import com.stb.hollywood.tests.WAN.BaseWANTest;
import com.stb.hollywood.utils.JScripts;
import com.stb.hollywood.utils.LogUtil;
import io.qameta.allure.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class ConnectAndStreamWANTest extends BaseWANTest {

    private JavascriptExecutor js;
    private WebDriver driver;
    AustinPlayerWANSteps austinSteps;
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

        austinSteps = new AustinPlayerWANSteps();
        openHollywoodURL();
        setDefaultCredentials();
        austinSteps.clickConnectButton();
        austinSteps.clickStartStreamingButton();
        austinSteps.delay(10000);

        boxStatus = austinSteps.getBoxStatusText();


        if(austinSteps.isPlayerVisible()) {
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
                austinSteps.delay(180000);
                outputAfterDelay = new Double(js.executeScript(script.getCurrentTime()).toString());
                austinSteps.diffShouldBeMoreThan(outputAfterDelay, outputBeforeDelay, 150);

                austinSteps.clickDisconnectButton();
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

