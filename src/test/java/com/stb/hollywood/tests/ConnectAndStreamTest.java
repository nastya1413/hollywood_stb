package com.stb.hollywood.tests;

import com.stb.hollywood.steps.HollywoodSlingboxDemoSteps;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ConnectAndStreamTest extends BaseTest{

    private JavascriptExecutor js;
    private WebDriver driver;
    HollywoodSlingboxDemoSteps hollywoodSteps;

    @Test
    public void testConnectAndStream() throws InterruptedException {

        hollywoodSteps = new HollywoodSlingboxDemoSteps();
        openHollywoodURL();
        hollywoodSteps.setFinderID("252300CBA05BAA4397B00C06440C5B4C");
        hollywoodSteps.setPassword("admin");
        hollywoodSteps.clickConnectAndStreamButton();

        js = (JavascriptExecutor) driver;

        String script = "return document.getElementById('bitmovinplayer-video-dashPlayer').currentTime;";

        String output = js.executeScript(script).toString();
        System.out.println(output);
        String output2 = js.executeScript(script).toString();
        System.out.println(output2);
    }

}
