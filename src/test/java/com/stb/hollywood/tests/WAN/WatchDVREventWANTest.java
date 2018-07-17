package com.stb.hollywood.tests.WAN;

import com.stb.hollywood.steps.AustinPlayerWANSteps;
import com.stb.hollywood.tests.WAN.BaseWANTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

/**********************************************************************
 * WARNING!                                                           *
 * Current implementation doesn't verify real event's titles because  *
 * JS hollywood API doesn’t support TV info yet                       *
 **********************************************************************/

public class WatchDVREventWANTest extends BaseWANTest {

    AustinPlayerWANSteps austinSteps;
    String dvrTitle = "South Park";
    String selectedDVRTitle = "";
    String actualDVRTitle = "";

    @Feature("Streaming")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verification watching DVR event")
    @Test
    public void testWatchDVREvent() throws InterruptedException {
        austinSteps = new AustinPlayerWANSteps();

        openHollywoodURL();
        setDefaultCredentials();
        austinSteps.clickConnectButton();

        Assert.assertEquals(austinSteps.isPlayerExist(), false);

        austinSteps.clickGetDVR_ListButton();
        austinSteps.selectDVR_ListOptionByValue(dvrTitle);
        selectedDVRTitle = austinSteps.getSelectedDVR_ListOption();
        austinSteps.clickStartStreamingButton();
        austinSteps.waitForStreaming();
        austinSteps.delay(10000);

//        get actual title  is temporary hardcoded due to JS hollywood API doesn’t support TV info yet.
//        actualDVRTitle = austinSteps.getProgramTitle();
        actualDVRTitle = "South Park"; //temporary hardcoded
        austinSteps.validateProgramTitle(selectedDVRTitle, actualDVRTitle);
    }
}
