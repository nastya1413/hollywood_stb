package com.stb.hollywood.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.stb.hollywood.pages.HollywoodSlingboxDemoPage;
import io.qameta.allure.Step;
import org.testng.Assert;


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
    public void clickConnectAndStreamButton() throws InterruptedException {
        int attempt = 0;
        do{
            System.out.println("Attempt #" + attempt);
            hllwd_page.getConnectAndStreamButton().click();
            attempt++;
            delay(5000);
            System.out.println("Box status: " + getBoxStatusText());
        }while(!getBoxStatusText().equals("STARTING_STREAMING") &&
                !getBoxStatusText().equals("STREAMING") &&
                attempt < 2);
    }

    @Step("Click Connect button")
    public void clickConnectButton() throws InterruptedException {
        int attempt = 0;
        do{
            System.out.println("Attempt #" + attempt);
            hllwd_page.getConnectButton().click();
            attempt++;
            delay(5000);
            System.out.println("Box status: " + getBoxStatusText());
        }while(!getBoxStatusText().equals("CONNECTED") &&
                attempt < 2);
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
    public void clickDisconnectButton() throws InterruptedException {
        int attempt = 0;
        do{
            System.out.println("Attempt #" + attempt);
            hllwd_page.getDisconnectButton().click();
            attempt++;
            delay(1000);
            System.out.println("Box status: " + getBoxStatusText());
        }while(!getBoxStatusText().equals("DISCONNECTED") &&
                attempt < 2);
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
    public void clickGetDVR_ListButton() throws InterruptedException {
        hllwd_page.getGetDVR_ListButton().click();
        delay(1000);
    }

    @Step("Click Get DVR List options by value")
    public void selectDVR_ListOptionByValue(String option){
        System.out.println("Selected progran ID is " + option);
        hllwd_page.getGetDVR_ListDropDown().selectOptionByValue(option);
    }

    @Step("Click get selected DVR List option")
    public String getSelectedDVR_ListOption(){
        return hllwd_page.getGetDVR_ListDropDown().getSelectedText();
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
        hllwd_page.getStreamInfoAudioBuffer().waitUntil(Condition.not(Condition.text("-")), 30000);
    }

    @Step("Get Video player attribute 'isVisible'")
    public boolean isPlayerVisible(){
        waitForPlayer();
        return hllwd_page.getPlayer().isDisplayed();
    }

    @Step("Get Video player attribute 'isExist'")
    public boolean isPlayerExist(){
        return hllwd_page.getPlayer().exists();
    }

    @Step("Get Box Status text")
    public String getBoxStatusText()
    {
        return hllwd_page.getBoxStatusLabel().innerText().replace(" ", "");
    }

    @Step("Delay")
    public void delay(long milliSeconds) throws InterruptedException {
            Thread.sleep(milliSeconds);
    }

    @Step("Validating difference between 'outputAfterDelay' current time and 'outputBeforeDelay' current time for verifying a duration of an event")
    public void diffShouldBeMoreThan(double outputAfterDelay, double outputBeforeDelay, int expDiffInSec){
        Assert.assertTrue((outputAfterDelay - outputBeforeDelay) >= expDiffInSec,
                String.format(
                        "Difference is less than %d between 'outputAfterDelay' and 'outputBeforeDelay'. " +
                                "The 'outputBeforeDelay value is %f, 'outputAfterDelay' value is %f",
                        expDiffInSec, outputBeforeDelay, outputAfterDelay));
    }

    @Step("Validating difference between 'outputAfterDelay' current time and 'outputBeforeDelay' current time for verifying a duration of an event")
    public void diffShouldBeLessThan(double outputAfterDelay, double outputBeforeDelay, int expDiffInSec){
        Assert.assertTrue((outputAfterDelay - outputBeforeDelay) <= expDiffInSec,
                String.format(
                        "Difference is larger than %d between 'outputAfterDelay' and 'outputBeforeDelay'. " +
                                "The 'outputBeforeDelay value is %f, 'outputAfterDelay' value is %f",
                        expDiffInSec, outputBeforeDelay, outputAfterDelay));
    }

    /*The getProgramTitle method should return a String value with program info - program title data e.g. 'Fixer Upper'*/
    @Step("Get program title")
    public String getProgramTitle(){
        return hllwd_page.getPlayer().toString();
    }

    @Step("Comparing expected and actual titles of a steaming event")
    public void validateProgramTitle(String expectedTitle, String actualTitle){
        Assert.assertEquals(expectedTitle, actualTitle );
    }
}
