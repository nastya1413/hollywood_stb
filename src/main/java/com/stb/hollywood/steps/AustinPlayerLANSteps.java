package com.stb.hollywood.steps;

import com.stb.hollywood.pages.AustinPlayerLANPage;
import io.qameta.allure.Step;

public class AustinPlayerLANSteps extends AustinPlayerSteps{

    private AustinPlayerLANPage player_page;

    public AustinPlayerLANSteps() {
        player_page = new AustinPlayerLANPage();
    }

    @Step("Setting box' ip number")
    public void setBoxIP(String boxIP)
    {
        player_page.getBoxIPAddress_Field().setValue(boxIP);
    }

    @Step("Setting box' port number")
    public void setBoxPort(String boxPort)
    {
        player_page.getBoxPortNumber_Field().setValue(boxPort);
    }

    @Step("Click 'Get channels' button")
    public void clickGetChannelsButton()
    {
        player_page.getChanelsButton().click();
    }

    @Step("Select Change channel by value from channel change dropdown")
    public void selectChangeChannelByValue(String option) throws InterruptedException {
        clickGetChannelsButton();
        delay(10000);
        System.out.println("Selected channel is " + option);
        player_page.getChangeChanelDropdown().selectOptionContainingText(option);
    }

    @Step("Get selected channel from channel change dropdown")
    public String getSelectedChannel_Option(){
        return player_page.getChangeChanelDropdown().getSelectedText();
    }

}
