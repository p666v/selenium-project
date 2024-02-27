package ru.buttonone.hw7.steam;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class GamePage {
    private final String appName = "//div[@id='appHubAppName']";
    private final long secondsOfWaiting = 10;

    public String appNameGetText() {
        return $x(appName).shouldBe(visible, Duration.ofSeconds(secondsOfWaiting)).getText();
    }
}