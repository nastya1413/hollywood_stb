package com.stb.hollywood.tests.WAN;

import com.stb.hollywood.steps.AustinPlayerWANSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ConnectWANTest extends BaseWANTest {

    AustinPlayerWANSteps austinSteps;

    @Feature("Connection")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Checking the Connection to STB using Connect button")
    @Test
    public void testVideoDuration() throws InterruptedException {
        austinSteps = new AustinPlayerWANSteps();

        openHollywoodURL();
        setDefaultCredentials();
        austinSteps.clickConnectButton();
        austinSteps.delay(10000);
        Assert.assertFalse(austinSteps.isPlayerExist(), "Player doesn't exist. Streaming wasn't started.");
        austinSteps.clickStartStreamingButton();
        Assert.assertTrue(austinSteps.isPlayerExist(), "Player exists. Streaming was started.");
        austinSteps.clickStopStreamingButton();
        Assert.assertFalse(austinSteps.isPlayerExist(), "Player doesn't exist. Streaming was stopped.");
    }
}
