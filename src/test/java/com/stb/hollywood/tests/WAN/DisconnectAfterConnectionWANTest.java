package com.stb.hollywood.tests.WAN;

import com.stb.hollywood.steps.AustinPlayerWANSteps;
import com.stb.hollywood.steps.HollywoodSlingboxDemoSteps;
import com.stb.hollywood.tests.WAN.BaseWANTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisconnectAfterConnectionWANTest extends BaseWANTest {
    AustinPlayerWANSteps austinSteps;

    @Feature("Connection")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Checking the Disconnection after connecting to STB using Disconnect button")
    @Test
    public void testVideoDuration() throws InterruptedException {
        austinSteps = new AustinPlayerWANSteps();

        openHollywoodURL();
        setDefaultCredentials();
        austinSteps.clickConnectButton();
        austinSteps.delay(10000);
        Assert.assertFalse(austinSteps.isPlayerExist(), "Player doesn't exist. Streaming wasn't started.");
        austinSteps.delay(10000);
        austinSteps.clickDisconnectButton();
        Assert.assertFalse(austinSteps.isPlayerExist(), "Player doesn't exist. Connection was disconnected.");
    }
}
