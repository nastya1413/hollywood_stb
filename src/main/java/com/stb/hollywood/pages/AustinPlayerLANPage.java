package com.stb.hollywood.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AustinPlayerLANPage extends AustinPlayerPage{
    
    public SelenideElement getBoxIPAddress_Field()
    {
        return $(By.id("box-ip"));
    }

    public SelenideElement getBoxPortNumber_Field()
    {
        return $(By.id("box-port"));
    }

    public SelenideElement getChanelsButton()
    {
        return $(By.id("box-get-channel"));
    }

    public SelenideElement getChangeChanelDropdown()
    {
        return $(By.id("box-change-channel"));
    }
}
