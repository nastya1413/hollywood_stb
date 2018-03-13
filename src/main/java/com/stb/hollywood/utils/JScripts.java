package com.stb.hollywood.utils;

import io.qameta.allure.Step;

public class JScripts {

    @Step("Get current time of the video element")
    public String getCurrentTime(){
        return "return document.getElementById('bitmovinplayer-video-dashPlayer').currentTime;";
    }
}
