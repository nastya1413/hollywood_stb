package com.stb.hollywood.tests;

import com.stb.hollywood.steps.HollywoodSlingboxDemoSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisconnectAfterStreamingTest extends BaseTest{
    HollywoodSlingboxDemoSteps hollywoodSteps;

    @Feature("Connection")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Checking the Disconnection during streaming using Disconnect button")
    @Test
    public void testVideoDuration() throws InterruptedException {
        hollywoodSteps = new HollywoodSlingboxDemoSteps();

        openHollywoodURL();
        setDefaultCredentials();
        hollywoodSteps.clickConnectAndStreamButton();
        hollywoodSteps.delay(10000);
        hollywoodSteps.clickDisconnectButton();
        Assert.assertFalse(hollywoodSteps.isPlayerExist(), "Player doesn't exist. Streaming was disconnected.");
    }
}
