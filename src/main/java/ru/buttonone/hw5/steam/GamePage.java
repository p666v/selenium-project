package ru.buttonone.hw5.steam;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static ru.buttonone.hw5.utilities.WebDriverSingleton.INSTANCE;

public class GamePage {
    private final By appName = By.xpath("//div[@id='appHubAppName']");
    private final WebDriverWait webDriverWait = new WebDriverWait(INSTANCE.getDriver(), Duration.ofSeconds(10));

    public String appNameGetText() {
        return webDriverWait.until(visibilityOfElementLocated(appName)).getText();
    }
}