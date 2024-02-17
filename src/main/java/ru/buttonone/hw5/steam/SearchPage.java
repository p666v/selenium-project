package ru.buttonone.hw5.steam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.testng.Assert.fail;
import static ru.buttonone.hw5.utilities.WebDriverSingleton.DRIVER;

public class SearchPage {
    private final By searchTag = By.xpath("//div[@class='searchtag tag_dynamic']");
    private final By sortingParametersDropDown = By.id("sort_by_trigger");
    private final By sortingParametersDropDownActive = By.xpath("//a[@class='trigger activetrigger']");
    private final By releaseDateItemSortingDropDown = By.id("Released_DESC");
    private final By freeGamesCheckBox = By.xpath("//span[@data-loc='Скрыть бесплатные игры']");
    private final By freeGamesCheckBoxActive = By
            .xpath("//span[contains(@class,'checked') and @data-loc='Скрыть бесплатные игры']");
    private final By listGames = By.xpath("//div[@id='search_resultsRows']/descendant::a");
    private final By gameFromList = By.xpath(".//span[@class = 'title']");
    private final WebDriverWait webDriverWait = new WebDriverWait(DRIVER.getDriver(), Duration.ofSeconds(10));

    public boolean searchTagIsDisplayed() {
        return webDriverWait.until(visibilityOfElementLocated(searchTag)).isDisplayed();
    }

    public void sortingParametersDropDownClick() {
        webDriverWait.until(visibilityOfElementLocated(sortingParametersDropDown)).click();
    }

    public String sortingParametersDropDownGetText() {
        return webDriverWait.until(visibilityOfElementLocated(sortingParametersDropDown)).getText();
    }

    public boolean sortingParametersDropDownActiveIsDisplayed() {
        return webDriverWait.until(visibilityOfElementLocated(sortingParametersDropDownActive)).isDisplayed();
    }

    public void releaseDateItemSortingDropDownClick() {
        webDriverWait.until(visibilityOfElementLocated(releaseDateItemSortingDropDown)).click();
    }

    public void freeGamesCheckBoxClick() {
        webDriverWait.until(visibilityOfElementLocated(freeGamesCheckBox)).click();
    }

    public boolean freeGamesCheckBoxActiveIsDisplayed() {
        return webDriverWait.until(visibilityOfElementLocated(freeGamesCheckBoxActive)).isDisplayed();
    }

    public List<WebElement> getListGames() {
        return webDriverWait.until(visibilityOfAllElementsLocatedBy(listGames));
    }

    public String gameFromListGetText(String nameGame) {
        String currentGameText = "";
        Optional<String> gameOptional = getListGames().stream()
                .filter(game -> game.findElement(gameFromList).getText().equals(nameGame))
                .map(game -> game.findElement(gameFromList).getText()).findAny();

        if (gameOptional.isPresent()) {
            currentGameText = gameOptional.get();
        } else {
            fail("Игра с названием: " + nameGame + " в списке не найдена");
        }
        return currentGameText;
    }

    public void gameFromListClick(String nameGame) {
        Optional<WebElement> currentGame = getListGames().stream()
                .filter(game -> game.findElement(gameFromList).getText().equals(nameGame))
                .map(game -> game.findElement(gameFromList)).findAny();

        if (currentGame.isPresent()) {
            currentGame.get().click();
        } else {
            fail("Игра с названием: " + nameGame + " в списке не найдена");
        }
    }
}