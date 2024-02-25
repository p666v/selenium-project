package ru.buttonone.hw7.steam;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class SearchPage {
    private final String sortingParametersDropDown = "//a[@id='sort_by_trigger']";
    private final String sortingParametersDropDownActive = "//a[@class='trigger activetrigger']";
    private final String sortingReleaseDateButton = "//a[@id='Released_DESC']";
    private final String freeGamesCheckBox = "//span[@data-loc='Скрыть бесплатные игры']";
    private final String freeGamesCheckBoxActive = "//span[contains(@class,'checked') and @data-loc='Скрыть бесплатные игры']";
    private final String allGames = "//div[@id='search_resultsRows']/a";

    public void sortingParametersDropDownClick() {
        $x(sortingParametersDropDown).shouldBe(visible, Duration.ofSeconds(10)).click();
    }

    public String sortingParametersDropDownGetText() {
        return $x(sortingParametersDropDown).shouldBe(visible, Duration.ofSeconds(10)).getText();
    }

    public boolean sortingParametersDropDownActiveIsDisplayed() {
        return $x(sortingParametersDropDownActive).shouldBe(visible, Duration.ofSeconds(10)).isDisplayed();
    }

    public void sortingReleaseDateButtonClick() {
        $x(sortingReleaseDateButton).shouldBe(visible, Duration.ofSeconds(10)).click();
    }

    public void freeGamesCheckBoxClick() {
        $x(freeGamesCheckBox).shouldBe(visible, Duration.ofSeconds(10)).click();
    }

    public boolean freeGamesCheckBoxActiveIsDisplayed() {
        return $x(freeGamesCheckBoxActive).shouldBe(visible, Duration.ofSeconds(10)).isDisplayed();
    }

    public void gameCorrespondsToParametersClick(String gameName) {
        $$x(allGames).shouldBe(sizeGreaterThan(0), Duration.ofSeconds(10)).findBy(text(gameName)).click();
    }
}