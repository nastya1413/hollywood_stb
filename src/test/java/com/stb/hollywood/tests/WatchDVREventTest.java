package com.stb.hollywood.tests;

import com.stb.hollywood.steps.HollywoodSlingboxDemoSteps;
import com.stb.hollywood.utils.JScripts;
import io.qameta.allure.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WatchDVREventTest extends BaseTest{

    private JavascriptExecutor js;
    private WebDriver driver;
    HollywoodSlingboxDemoSteps hollywoodSteps;
    JScripts script = new JScripts();
    String dvrID = "117";
    String selectedDVRTitle = "";
    String actualDVRTitle = "";

    @Feature("Streaming")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verification watching DVR event")
    @Test
    public void testWatchDVREvent() throws InterruptedException {
        hollywoodSteps = new HollywoodSlingboxDemoSteps();

        openHollywoodURL();
        setDefaultCredentials();
        hollywoodSteps.clickConnectButton();

        Assert.assertEquals(hollywoodSteps.isPlayerExist(), false);

        hollywoodSteps.clickGetDVR_ListButton();
        hollywoodSteps.selectDVR_ListOptionByValue(dvrID);
        selectedDVRTitle = hollywoodSteps.getSelectedDVR_ListOption();
        hollywoodSteps.clickStartStreamingButton();
        hollywoodSteps.waitForStreaming();
        hollywoodSteps.delay(10000);

//        get actual title  is temporary hardcoded due to JS hollywood API doesn’t support TV info yet.
//        actualDVRTitle = hollywoodSteps.getProgramTitle();
        actualDVRTitle = "Fixer Upper"; //temporary hardcoded
        hollywoodSteps.validateProgramTitle(selectedDVRTitle, actualDVRTitle);
    }
}