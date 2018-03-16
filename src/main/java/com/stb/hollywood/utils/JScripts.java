package com.stb.hollywood.utils;

import io.qameta.allure.Step;

public class JScripts {
    private String videoElementID = "document.getElementById('bitmovinplayer-video-dashPlayer')";

    @Step("Get current time of the video element")
    public String getCurrentTime(){
        return String.format("return %s.currentTime;", videoElementID);
    }

    @Step("Get the paused property. The paused property returns whether the video is paused")
    public String isVideoPaused(){
        return String.format("return %s.paused;", videoElementID);
    }
}
