package com.stb.hollywood.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


public abstract class BaseTest {

    private static final String DEFAULT_URL = "http://hollywood.slingbox.com/demos/Austin%20Slingplayer.htm";
    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public WebDriver setupTest() {
        driver = new ChromeDriver();
        return driver;
    }

    public void openHollywoodURL(){
        driver.get(DEFAULT_URL);
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
