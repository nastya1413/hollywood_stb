package com.stb.hollywood.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.stb.hollywood.pages.HollywoodSlingboxDemoPage;
import io.qameta.allure.Step;

import java.util.concurrent.TimeUnit;

public class HollywoodSlingboxDemoSteps {

    private HollywoodSlingboxDemoPage hllwd_page;

    public HollywoodSlingboxDemoSteps() {
        hllwd_page = new HollywoodSlingboxDemoPage();
    }

    @Step("Setting finder ID")
    public void setFinderID(String finderID)
    {
        hllwd_page.getFinderID_Field().setValue(finderID);
    }

    @Step("Setting password")
    public void setPassword(String psswrd)
    {
        hllwd_page.getPasswordField().setValue(psswrd);
    }

    @Step("Click Connect and Stream button")
    public void clickConnectAndStreamButton()
    {
        hllwd_page.getConnectAndStreamButton().click();
    }

    @Step("Click Connect button")
    public void clickConnectButton()
    {
        hllwd_page.getConnectButton().click();
    }

    @Step("Click Start Streaming button")
    public void clickStartStreamingButton()
    {
        hllwd_page.getStartStreamingButton().click();
    }

    @Step("Click Stop Streaming button")
    public void clickStopStreamingButton()
    {
        hllwd_page.getStopStreamingButton().click();
    }

    @Step("Click Disconnect button")
    public void clickDisconnectButton()
    {
        hllwd_page.getDisconnectButton().click();
    }

    @Step("Click Play button")
    public void clickPlayButton()
    {
        hllwd_page.getPlayButton().click();
    }

    @Step("Click Pause button")
    public void clickPauseButton()
    {
        hllwd_page.getPauseButton().click();
    }

    @Step("Click Get DVR List button")
    public void clickGetDVR_ListButton()
    {
        hllwd_page.getGetDVR_ListButton().click();
    }

    @Step("Click CC config button")
    public void clickCC_ConfigButton()
    {
        hllwd_page.getCC_Config().click();
    }

    @Step("Waiting for Video player")
    public void waitForPlayer(){
        hllwd_page.getPlayer().waitUntil(Condition.appears, 30000);
    }

    @Step("Waiting for starting streaming")
    public void waitForStreaming(){
        hllwd_page.getStreamInfoAudioBuffer().waitUntil(Condition.not(Condition.matchText("*-*")), 30000);
    }

    @Step("Get Video player attribute 'isVisible'")
    public boolean isPlayerVisible(){
        return hllwd_page.getPlayer().isDisplayed();
    }

    @Step("Get Box Status text")
    public String getBoxStatusText()
    {
        return hllwd_page.getBoxStatusLabel().text();
    }

    @Step("Get Audio stream info buffering text")
    public String getStreamInfoAudioBuffer(){
       return hllwd_page.getStreamInfoAudioBuffer().innerText();
    }

    @Step("Delay")
    public void delay(long milliSeconds) throws InterruptedException {
            Thread.sleep(milliSeconds);
    }
}
