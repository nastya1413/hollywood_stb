package com.stb.hollywood.steps;

import com.stb.hollywood.pages.HollywoodSlingboxDemoPage;
import io.qameta.allure.Step;

public class HollywoodSlingboxDemoSteps {

    HollywoodSlingboxDemoPage hllwd_page;

    public HollywoodSlingboxDemoSteps() {
        hllwd_page = new HollywoodSlingboxDemoPage();
    }

    @Step
    public void setFinderID(String finderID)
    {
        hllwd_page.getFinderID().clear();
        hllwd_page.getFinderID().sendKeys(finderID);
    }

    @Step
    public void setPassword(String psswrd)
    {
        hllwd_page.getPassword().clear();
        hllwd_page.getPassword().sendKeys(psswrd);
    }

    @Step
    public void clickConnectAndStreamButton()
    {
        hllwd_page.getConnectAndStreamButton().click();
    }
}
