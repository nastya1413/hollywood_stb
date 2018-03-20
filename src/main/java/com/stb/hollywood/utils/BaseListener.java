package com.stb.hollywood.utils;

import com.codeborne.selenide.Screenshots;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class BaseListener implements IInvokedMethodListener {

    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

    }

    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        if (iInvokedMethod.isTestMethod() && !iTestResult.isSuccess()) {
            attachScreenshot();
        }
    }

    private void attachScreenshot() {
        try {
            Allure.addAttachment("Screenshot",
                    new ByteArrayInputStream(FileUtils.readFileToByteArray(Screenshots.takeScreenShotAsFile())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
