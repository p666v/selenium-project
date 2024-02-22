package ru.buttonone.hw5.steam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.testng.Assert.fail;
import static ru.buttonone.hw5.utilities.WebDriverSingleton.INSTANCE;

public class SearchPage {
    private final By sortingParametersDropDown = By.id("sort_by_trigger");
    private final By sortingParametersDropDownActive = By.xpath("//a[@class='trigger activetrigger']");
    private final By sortingReleaseDateButton = By.id("Released_DESC");
    private final By freeGamesCheckBox = By.xpath("//span[@data-loc='Скрыть бесплатные игры']");
    private final By freeGamesCheckBoxActive = By
            .xpath("//span[contains(@class,'checked') and @data-loc='Скрыть бесплатные игры']");
    private final By allGames = By.xpath("//div[@id='search_resultsRows']/a");
    private final By byTitleTag = By.xpath(".//span[@class = 'title']");
    private final WebDriverWait webDriverWait = new WebDriverWait(INSTANCE.getDriver(), Duration.ofSeconds(10));

    public void sortingParametersDropDownClick() {
        webDriverWait.until(visibilityOfElementLocated(sortingParametersDropDown)).click();
    }

    public String sortingParametersDropDownGetText() {
        return webDriverWait.until(visibilityOfElementLocated(sortingParametersDropDown)).getText();
    }

    public boolean sortingParametersDropDownActiveIsDisplayed() {
        return webDriverWait.until(visibilityOfElementLocated(sortingParametersDropDownActive)).isDisplayed();
    }

    public void sortingReleaseDateButtonClick() {
        webDriverWait.until(visibilityOfElementLocated(sortingReleaseDateButton)).click();
    }

    public void freeGamesCheckBoxClick() {
        webDriverWait.until(visibilityOfElementLocated(freeGamesCheckBox)).click();
    }

    public boolean freeGamesCheckBoxActiveIsDisplayed() {
        return webDriverWait.until(visibilityOfElementLocated(freeGamesCheckBoxActive)).isDisplayed();
    }

    public List<WebElement> getAllGamesWithFilterParameters() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException interruptedException) {
            System.err.println("Ожидание потока прервано");
            throw new RuntimeException(interruptedException);
        }
        return webDriverWait.until(visibilityOfAllElementsLocatedBy(allGames));
    }

    public void gameCorrespondsToParametersClick(String gameName) {
        WebElement currentGameTitle = null;
        for (WebElement game : getAllGamesWithFilterParameters()) {
            if (game.findElement(byTitleTag).getText().equals(gameName)) {
                currentGameTitle = game.findElement(byTitleTag);
                break;
            }
        }

        if (currentGameTitle != null) {
            currentGameTitle.click();
        } else {
            fail("Игра с названием: " + gameName + " в списке не найдена");
        }
    }
}