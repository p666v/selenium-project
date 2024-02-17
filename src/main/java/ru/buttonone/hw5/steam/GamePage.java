package ru.buttonone.hw5.steam;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static ru.buttonone.hw5.utilities.WebDriverSingleton.DRIVER;

public class GamePage {
    private final By gameApp = By.xpath("//div[@id='appHubAppName']");
    private final WebDriverWait webDriverWait = new WebDriverWait(DRIVER.getDriver(), Duration.ofSeconds(10));

    public String gameAppGetText() {
        return webDriverWait.until(visibilityOfElementLocated(gameApp)).getText();
    }
}