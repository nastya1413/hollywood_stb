package com.stb.hollywood.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AustinPlayerWANPage extends AustinPlayerPage {

    public SelenideElement getFinderID_Field()
    {
        return $(By.id("box-finderId"));
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
        return $(By.name("channel-number"));
    }

    public SelenideElement getChanelNumberButton()
    {
        return $(By.id("change-channel-stb"));
    }

    public SelenideElement getGetDVR_ListButton()
    {
        return $(By.id("dvr-list"));
    }

    public SelenideElement getGetDVR_ListDropDown()
    {
        return $(By.id("play-dvr"));
    }
}
