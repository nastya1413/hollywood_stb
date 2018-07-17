package com.stb.hollywood.steps;

import com.codeborne.selenide.Condition;
import com.stb.hollywood.pages.AustinPlayerWANPage;
import io.qameta.allure.Step;
import org.testng.Assert;

public class AustinPlayerWANSteps extends AustinPlayerSteps{

    private AustinPlayerWANPage player_page;

    public AustinPlayerWANSteps() {
        player_page = new AustinPlayerWANPage();
    }

    @Step("Setting finder ID")
    public void setFinderID(String finderID)
    {
        player_page.getFinderID_Field().setValue(finderID);
    }

    @Step("Click Get DVR List button")
    public void clickGetDVR_ListButton() throws InterruptedException {
        player_page.getGetDVR_ListButton().click();
        delay(1000);
    }

    @Step("Click Get DVR List options by value")
    public void selectDVR_ListOptionByValue(String option){
        System.out.println("Selected program ID is " + option);
        player_page.getGetDVR_ListDropDown().selectOptionContainingText(option);
    }

    @Step("Click get selected DVR List option")
    public String getSelectedDVR_ListOption(){
        return player_page.getGetDVR_ListDropDown().getSelectedText();
    }

    @Step("Click Change channel button")
    public void clickChangeChannelButton(){
        player_page.getChanelNumberButton().click();
    }

    @Step("Change channel")
    public void changeChannel(String channelNum) throws InterruptedException {
        player_page.getChanelNumberField().setValue(channelNum);
        clickChangeChannelButton();
        delay(15000);
    }
}
