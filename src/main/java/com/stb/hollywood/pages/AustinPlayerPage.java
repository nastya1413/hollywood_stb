package com.stb.hollywood.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AustinPlayerPage {

    public SelenideElement getPasswordField()
    {
        return $(By.id("box-pass"));
    }

    public SelenideElement getConnectAndStreamButton()
    {
        return $(By.id("box-connect-and-stream"));
    }

    public SelenideElement getConnectButton()
    {
        return $(By.id("box-connect"));
    }

    public SelenideElement getStartStreamingButton()
    {
        return $(By.id("box-start-stream"));
    }

    public SelenideElement getStopStreamingButton()
    {
        return $(By.id("box-stop-stream"));
    }

    public SelenideElement getDisconnectButton()
    {
        return $(By.id("box-disconnect"));
    }

    public SelenideElement getPlayButton()
    {
        return $(By.id("box-play"));
    }

    public SelenideElement getPauseButton()
    {
        return $(By.id("box-pause"));
    }

    public SelenideElement getCC_Config(){
        return $(By.id("btn btn-mini yellow_button"));
    }

    public SelenideElement getPlayer() {return $(By.id("bitmovinplayer-video-dashPlayer"));}

    public SelenideElement getBoxStatusLabel(){
        return $(By.id("box_status"));
    }

    public SelenideElement getStreamInfoAudioBuffer() {
        return $(By.xpath(".//*[@id='streamInfo-audio-buffer']//*[@class='data-value']"));
    }
}
