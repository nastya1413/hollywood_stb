package com.stb.hollywood.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HollywoodSlingboxDemoPage {

    public SelenideElement getFinderID_Field()
    {
        return $(By.id("box-finderId"));
    }

    public SelenideElement getPasswordField()
    {
        return $(By.id("box-pass"));
    }

    public SelenideElement getDashPlayerTypeBitmovinRadioButton()
    {
        return $(By.id("box-dash-player-type"));
    }

    public SelenideElement getDRM_TypeNoneRadioButton()
    {
        return $(By.id("box-drm-type"));
    }

    public SelenideElement getDRM_LicenseField()
    {
        return $(By.id("box-drm-licence-url"));
    }

    public SelenideElement getChanelNumberField()
    {
        return $(By.id("channel-number"));
    }

    public SelenideElement getChanelNumberButton()
    {
        return $(By.id("change-channel-stb"));
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

    public SelenideElement getGetDVR_ListButton()
    {
        return $(By.id("dvr-list"));
    }

    public SelenideElement getCC_Config()
    {
        return $(By.id("btn btn-mini yellow_button"));
    }

    public SelenideElement getBoxStatusLabel()
    {
        return $(By.id("box_status"));
    }
}
