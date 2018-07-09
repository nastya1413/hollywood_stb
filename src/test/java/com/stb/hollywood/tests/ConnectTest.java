package com.stb.hollywood.tests;

import com.stb.hollywood.steps.HollywoodSlingboxDemoSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ConnectTest extends BaseTest {

    HollywoodSlingboxDemoSteps hollywoodSteps;

    @Feature("Connection")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Checking the Connection to STB using Connect button")
    @Test
    public void testVideoDuration() throws InterruptedException {
        hollywoodSteps = new HollywoodSlingboxDemoSteps();

        openHollywoodURL();
        setDefaultCredentials();
        hollywoodSteps.clickConnectButton();
        hollywoodSteps.delay(10000);
        Assert.assertFalse(hollywoodSteps.isPlayerExist(), "Player doesn't exist. Streaming wasn't started.");
        hollywoodSteps.clickStartStreamingButton();
        Assert.assertTrue(hollywoodSteps.isPlayerExist(), "Player exists. Streaming was started.");
        hollywoodSteps.clickStopStreamingButton();
        Assert.assertFalse(hollywoodSteps.isPlayerExist(), "Player doesn't exist. Streaming was stopped.");
    }
}
