package ru.buttonone.hw6;

import com.codeborne.selenide.*;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
//        Configuration.headless = false;
        Selenide.open("https://store.steampowered.com/?l=russian");
//        WebDriverRunner.getWebDriver();
        SelenideElement selenideElement = Selenide.$x("//..")
                .should(Condition.visible, Duration.ofSeconds(10));


    }
}
