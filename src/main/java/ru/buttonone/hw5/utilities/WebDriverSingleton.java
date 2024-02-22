package ru.buttonone.hw5.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
public enum WebDriverSingleton {
    INSTANCE;
    private final WebDriver driver;

    WebDriverSingleton() {
        ConfProperties confProperties = new ConfProperties();
        driver = WebDriverManager.getInstance(confProperties.getProperty("browser-name")).create();
    }
}