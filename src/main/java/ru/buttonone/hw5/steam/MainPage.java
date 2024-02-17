package ru.buttonone.hw5.steam;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.buttonone.hw5.utilities.ConfProperties;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static ru.buttonone.hw5.utilities.WebDriverSingleton.DRIVER;

public class MainPage {
    private final By searchField = By.id("store_nav_search_term");
    private final By categoriesPullDown = By.xpath("//div[@id='genre_tab']//a[@class = 'pulldown_desktop']");
    private final By categoriesPullDownActive = By.xpath("//div[@id='genre_flyout' and contains(@style, 'block')]");
    private final By categoryMysteriesDetectivesButton = By
            .xpath("//a[@class = 'popup_menu_item' and text() = 'Тайны и детективы']");
    private final ConfProperties confProperties = new ConfProperties();
    private final WebDriverWait webDriverWait = new WebDriverWait(DRIVER.getDriver(), Duration.ofSeconds(10));

    public void getToMainPage(String key) {
        DRIVER.getDriver().get(confProperties.getProperty(key));
    }

    public void enterDataSearchField(String nameGame) {
        webDriverWait.until(visibilityOfElementLocated(searchField)).sendKeys(nameGame);
    }

    public void searchFieldClick() {
        webDriverWait.until(visibilityOfElementLocated(searchField)).submit();
    }

    public void categoriesPullDownClick() {
        webDriverWait.until(visibilityOfElementLocated(categoriesPullDown)).click();
    }

    public boolean categoriesPullDownActiveIsDisplayed() {
        return webDriverWait.until(visibilityOfElementLocated(categoriesPullDownActive)).isDisplayed();
    }

    public void categoryMysteriesDetectivesButtonClick() {
        webDriverWait.until(visibilityOfElementLocated(categoryMysteriesDetectivesButton)).click();
    }
}