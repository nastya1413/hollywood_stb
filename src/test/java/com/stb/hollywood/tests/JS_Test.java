package com.stb.hollywood.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class JS_Test extends BaseTest{

    private JavascriptExecutor js;
    private WebDriver driver;

    @Test
    public void testJS(){

        driver = setupTest();

        js = (JavascriptExecutor) driver;
        js.executeScript("");

    }

}
