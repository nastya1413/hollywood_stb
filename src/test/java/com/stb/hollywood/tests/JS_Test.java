package com.stb.hollywood.tests;

import com.stb.hollywood.pages.HollywoodSlingboxDemoPage;
import com.stb.hollywood.steps.HollywoodSlingboxDemoSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class JS_Test extends BaseTest{

    private JavascriptExecutor js;
    private WebDriver driver;
    HollywoodSlingboxDemoSteps hollywoodSteps = new HollywoodSlingboxDemoSteps();

    @Test
    public void testJS() throws InterruptedException {

        driver = setupTest();

        openHollywoodURL();
        Thread.sleep(10000);
        hollywoodSteps.setFinderID("252300CBA05BAA4397B00C06440C5B4C");
        hollywoodSteps.setPassword("admin");
        hollywoodSteps.clickConnectAndStreamButton();
        Thread.sleep(20000);

        js = (JavascriptExecutor) driver;

        String video = "return document.getElementById('bitmovinplayer-video-dashPlayer').currentTime;";

        String output = js.executeScript(video).toString();

        System.out.println(output);
        Thread.sleep(10000);
        String output2 = js.executeScript(video).toString();
        System.out.println(output2);
    }

}
