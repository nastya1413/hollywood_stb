package com.stb.hollywood.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HollywoodSlingboxDemoPage {

    public SelenideElement getFinderID()
    {
        return $(By.id("box-finderId"));
    }

    public SelenideElement getPassword()
    {
        return $(By.id("box-pass"));
    }

    public SelenideElement getConnectAndStreamButton()
    {
        return $(By.id("box-connect-and-stream"));
    }

}
