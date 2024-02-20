package ru.buttonone.hw5.steam;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static ru.buttonone.hw5.utilities.WebDriverSingleton.INSTANCE;

public class CategoryPage {
    private final By showMoreButton = By
            .xpath("//div[contains(@class, 'ShowContentsContainer')]/button[text()='Показать больше']");
    private final By salesLeadersButton = By.xpath("//div[text()='Лидеры продаж']");
    private final By salesLeadersButtonActive = By
            .xpath("//div[text()='Лидеры продаж' and contains(@class, '3HhxiFyD3z9B')]");
    private final By showMoreGenresButton = By
            .xpath("//div[text()='Показать больше']");
    private final By showLessGenresButton = By
            .xpath("//div[text()='Показать меньше']");
    private final By strategyGenreButton = By
            .xpath("//div[text()='Основные жанры']/ancestor::div/div/a[text()='Стратегия']");
    private final By strategyGenreTagActive = By.xpath("//span[text()='Стратегия']");
    private final By playersListBox = By.xpath("//div[text()='Игроки']");
    private final By multiplePlayersButton = By
            .xpath("//div[text()='Игроки']/../following-sibling::div/a[text()='Для нескольких игроков']");
    private final By multiplePlayersTagActive = By.xpath("//span[text()='Для нескольких игроков']");
    private final By firstGameWithFilterParameters = By
            .xpath("//div[contains(@class, 'NO-IPpXzHDNjw_TLDlIo7')]/div[1]//div[contains(@class, 'StoreSaleWidgetTitle')]");
    private final WebDriverWait webDriverWait = new WebDriverWait(INSTANCE.getDriver(), Duration.ofSeconds(10));
    private final Actions actions = new Actions(INSTANCE.getDriver());
    private final JavascriptExecutor jsExecutor = (JavascriptExecutor) INSTANCE.getDriver();

    public void moveToShowMoreButton() {
        actions.moveToElement(webDriverWait.until(visibilityOfElementLocated(showMoreButton))).perform();
    }

    public void salesLeadersButtonClick() {
        webDriverWait.until(visibilityOfElementLocated(salesLeadersButton)).click();
    }

    public boolean salesLeadersButtonActiveIsDisplayed() {
        return webDriverWait.until(visibilityOfElementLocated(salesLeadersButtonActive)).isDisplayed();
    }

    public void showMoreGenresButtonClick() {
        webDriverWait.until(visibilityOfElementLocated(showMoreGenresButton)).click();
    }

    public boolean showLessGenresButtonIsDisplayed() {
        return webDriverWait.until(visibilityOfElementLocated(showLessGenresButton)).isDisplayed();
    }

    public void strategyGenreButtonClick() {
        webDriverWait.until(visibilityOfElementLocated(strategyGenreButton)).click();
    }

    public boolean strategyGenreTagActiveIsDisplayed() {
        return webDriverWait.until(visibilityOfElementLocated(strategyGenreTagActive)).isDisplayed();
    }

    public void playersListBoxClick() {
        webDriverWait.until(visibilityOfElementLocated(playersListBox)).click();
    }

    public boolean multiplePlayersButtonIsDisplayed() {
        return webDriverWait.until(visibilityOfElementLocated(multiplePlayersButton)).isDisplayed();
    }

    public void multiplePlayersButtonClick() {
        webDriverWait.until(visibilityOfElementLocated(multiplePlayersButton)).click();
    }

    public boolean multiplePlayersTagActiveIsDisplayed() {
        return webDriverWait.until(visibilityOfElementLocated(multiplePlayersTagActive)).isDisplayed();
    }

    public String firstGameFilteredListGetText() {
        return webDriverWait.until(visibilityOfElementLocated(firstGameWithFilterParameters)).getText();
    }

    public void firstGameWithFilterParametersClick() {
        jsExecutor.executeScript("arguments[0].click()",
                webDriverWait.until(visibilityOfElementLocated(firstGameWithFilterParameters)));
    }
}