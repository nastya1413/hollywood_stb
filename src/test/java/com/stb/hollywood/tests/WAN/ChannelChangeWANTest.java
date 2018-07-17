package com.stb.hollywood.tests.WAN;

import com.stb.hollywood.steps.AustinPlayerWANSteps;
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
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

/**********************************************************************
 * WARNING!                                                           *
 * Current implementation doesn't verify real event's titles because  *
 * JS hollywood API doesn’t support TV info yet                       *
 **********************************************************************/


public class ChannelChangeWANTest extends BaseWANTest {
    private JavascriptExecutor js;
    private WebDriver driver;
    AustinPlayerWANSteps austinSteps;

    String eventTitleBeforeChannelChange = "";
    String eventTitleAfterChannelChange = "";

    @Feature("Streaming")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Check channel changing")
    @Test
    public void testChannelChange() throws InterruptedException {
        Double currentTime;
        Double currentTimeAfterdelay;
        JScripts script = new JScripts();
        SoftAssert softAssert = new SoftAssert();
        driver = getWebDriver();
        js = (JavascriptExecutor) driver;

        austinSteps = new AustinPlayerWANSteps();
        openHollywoodURL();
        setDefaultCredentials();
        austinSteps.clickConnectAndStreamButton();
        austinSteps.delay(10000);
        Assert.assertTrue(austinSteps.isPlayerExist(), "Player exists. Streaming was started.");

//        get eventTitleBeforeChannelChange is temporary hardcoded due to JS hollywood API doesn’t support TV info yet.
//        eventTitleBeforeChannelChange = austinSteps.getProgramTitle();
        eventTitleBeforeChannelChange = "South Park"; //temporary hardcoded
        currentTime = new Double(js.executeScript(script.getCurrentTime()).toString());
        austinSteps.delay(60000);
        currentTimeAfterdelay = new Double(js.executeScript(script.getCurrentTime()).toString());
        try{
            austinSteps.diffShouldBeMoreThan(currentTimeAfterdelay, currentTime, 40);
        } catch (Exception e){
            softAssert.fail();
        }

        austinSteps.changeChannel("123");

//        get eventTitleAfterChannelChange is temporary hardcoded due to JS hollywood API doesn’t support TV info yet.
//        eventTitleAfterChannelChange = austinSteps.getProgramTitle();
        eventTitleAfterChannelChange = "DISH 101"; //temporary hardcoded
        currentTime = new Double(js.executeScript(script.getCurrentTime()).toString());
        austinSteps.delay(60000);
        currentTimeAfterdelay = new Double(js.executeScript(script.getCurrentTime()).toString());
        try{
            austinSteps.diffShouldBeMoreThan(currentTimeAfterdelay, currentTime, 40);
        } catch (Exception e){
            softAssert.fail();
        }

        Assert.assertNotEquals(eventTitleBeforeChannelChange, eventTitleAfterChannelChange);
    }
}
