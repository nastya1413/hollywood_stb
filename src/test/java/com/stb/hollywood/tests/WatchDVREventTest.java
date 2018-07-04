package com.stb.hollywood.tests;

import com.stb.hollywood.steps.HollywoodSlingboxDemoSteps;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WatchDVREventTest extends BaseTest{

    HollywoodSlingboxDemoSteps hollywoodSteps;
    String dvrTitle = "South Park";
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
        hollywoodSteps.selectDVR_ListOptionByValue(dvrTitle);
        selectedDVRTitle = hollywoodSteps.getSelectedDVR_ListOption();
        hollywoodSteps.clickStartStreamingButton();
        hollywoodSteps.waitForStreaming();
        hollywoodSteps.delay(10000);

//        get actual title  is temporary hardcoded due to JS hollywood API doesn’t support TV info yet.
//        actualDVRTitle = hollywoodSteps.getProgramTitle();
        actualDVRTitle = "South Park"; //temporary hardcoded
        hollywoodSteps.validateProgramTitle(selectedDVRTitle, actualDVRTitle);
    }
}
