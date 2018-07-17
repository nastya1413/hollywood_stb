package com.stb.hollywood.steps;

import com.codeborne.selenide.Condition;
import com.stb.hollywood.pages.AustinPlayerPage;
import io.qameta.allure.Step;
import org.testng.Assert;

public class AustinPlayerSteps {

    private AustinPlayerPage player_page;

    public AustinPlayerSteps() {
        player_page = new AustinPlayerPage();
    }

    @Step("Setting password")
    public void setPassword(String psswrd)
    {
        player_page.getPasswordField().setValue(psswrd);
    }

    @Step("Click Connect and Stream button")
    public void clickConnectAndStreamButton() throws InterruptedException {
        int attempt = 0;
        do{
            System.out.println("Attempt #" + attempt);
            player_page.getConnectAndStreamButton().click();
            attempt++;
            delay(5000);
            System.out.println("Box status: " + getBoxStatusText());
        }while(!getBoxStatusText().equals("STARTING_STREAMING") &&
                !getBoxStatusText().equals("STREAMING") &&
                attempt < 10);
    }

    @Step("Click Connect button")
    public void clickConnectButton() throws InterruptedException {
        int attempt = 0;
        do{
            System.out.println("Attempt #" + attempt);
            player_page.getConnectButton().click();
            attempt++;
            delay(5000);
            System.out.println("Box status: " + getBoxStatusText());
        }while(!getBoxStatusText().equals("CONNECTED") &&
                attempt < 10);
    }

    @Step("Click Start Streaming button")
    public void clickStartStreamingButton() throws InterruptedException {
        int attempt = 0;
        do{
            System.out.println("Attempt #" + attempt);
            player_page.getStartStreamingButton().click();
            attempt++;
            delay(5000);
            System.out.println("Box status: " + getBoxStatusText());
        }while(!getBoxStatusText().equals("STREAMING") &&
                attempt < 10);
    }

    @Step("Click Stop Streaming button")
    public void clickStopStreamingButton() throws InterruptedException {
        int attempt = 0;
        do{
            System.out.println("Attempt #" + attempt);
            player_page.getStopStreamingButton().click();
            attempt++;
            delay(5000);
            System.out.println("Box status: " + getBoxStatusText());
        }while(!getBoxStatusText().equals("CONNECTED") &&
                attempt < 10);
    }

    @Step("Click Disconnect button")
    public void clickDisconnectButton() throws InterruptedException {
        int attempt = 0;
        do{
            System.out.println("Attempt #" + attempt);
            player_page.getDisconnectButton().click();
            attempt++;
            delay(1000);
            System.out.println("Box status: " + getBoxStatusText());
        }while(!getBoxStatusText().equals("DISCONNECTED") &&
                attempt < 10);
        delay(5000);
    }

    @Step("Click Play button")
    public void clickPlayButton()
    {
        player_page.getPlayButton().click();
    }

    @Step("Click Pause button")
    public void clickPauseButton()
    {
        player_page.getPauseButton().click();
    }

    @Step("Click CC config button")
    public void clickCC_ConfigButton()
    {
        player_page.getCC_Config().click();
    }

    @Step("Waiting for Video player")
    public void waitForPlayer(){
        player_page.getPlayer().waitUntil(Condition.appears, 60000);
    }

    @Step("Waiting for starting streaming")
    public void waitForStreaming(){
        player_page.getStreamInfoAudioBuffer().waitUntil(Condition.not(Condition.text("-")), 30000);
    }

    @Step("Get Video player attribute 'isVisible'")
    public boolean isPlayerVisible(){
        waitForPlayer();
        return player_page.getPlayer().isDisplayed();
    }

    @Step("Get Video player attribute 'isExist'")
    public boolean isPlayerExist(){
        return player_page.getPlayer().exists();
    }

    @Step("Get Box Status text")
    public String getBoxStatusText()
    {
        return player_page.getBoxStatusLabel().innerText().replace(" ", "");
    }

    @Step("Delay")
    public void delay(long milliSeconds) throws InterruptedException {
        Thread.sleep(milliSeconds);
    }

    @Step("Validating difference between 'outputAfterDelay' current time and 'outputBeforeDelay' current time for verifying a duration of an event")
    public void diffShouldBeMoreThan(double outputAfterDelay, double outputBeforeDelay, int expDiffInSec){
        Assert.assertTrue((outputAfterDelay - outputBeforeDelay) >= expDiffInSec,
                String.format(
                        "Difference is less than %d between 'currentTimeAfterDelay' and 'currentTimeBeforeDelay'. " +
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
        return player_page.getPlayer().toString();
    }

    @Step("Comparing expected and actual titles of a steaming event")
    public void validateProgramTitle(String expectedTitle, String actualTitle){
        Assert.assertEquals(expectedTitle, actualTitle );
    }
}
