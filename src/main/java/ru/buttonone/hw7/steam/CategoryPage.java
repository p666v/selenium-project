package ru.buttonone.hw7.steam;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class CategoryPage {
    private final String showMoreButton = "//div[contains(@class, 'ShowContentsContainer')]/button[text()='Показать больше']";
    private final String salesLeadersButton = "//div[text()='Лидеры продаж']";
    private final String salesLeadersButtonActive = "//div[text()='Лидеры продаж' and contains(@class, '3HhxiFyD3z9B')]";
    private final String showMoreGenresButton = "//div[text()='Показать больше']";
    private final String showLessGenresButton = "//div[text()='Показать меньше']";
    private final String strategyGenreButton = "//div[text()='Основные жанры']/ancestor::div/div/a[text()='Стратегия']";
    private final String strategyGenreTagActive = "//span[text()='Стратегия']";
    private final String playersListBox = "//div[text()='Игроки']";
    private final String multiplePlayersButton = "//div[text()='Игроки']/../following-sibling::div/a[text()='Для нескольких игроков']";
    private final String multiplePlayersTagActive = "//span[text()='Для нескольких игроков']";
    private final String firstGameWithFilterParameters = "//div[contains(@class, 'NO-IPpXzHDNjw_TLDlIo7')]/" +
            "div[1]//div[contains(@class, 'StoreSaleWidgetTitle')]";

    public void moveToShowMoreButton() {
        $x(showMoreButton).shouldBe(visible, Duration.ofSeconds(10)).scrollTo();
    }

    public void salesLeadersButtonClick() {
        $x(salesLeadersButton).shouldBe(visible, Duration.ofSeconds(10)).click();
    }

    public boolean salesLeadersButtonActiveIsDisplayed() {
        return $x(salesLeadersButtonActive).shouldBe(visible, Duration.ofSeconds(10)).isDisplayed();
    }

    public void showMoreGenresButtonClick() {
        $x(showMoreGenresButton).shouldBe(visible, Duration.ofSeconds(10)).click();
    }

    public boolean showLessGenresButtonIsDisplayed() {
        return $x(showLessGenresButton).shouldBe(visible, Duration.ofSeconds(10)).isDisplayed();
    }

    public void strategyGenreButtonClick() {
        $x(strategyGenreButton).shouldBe(visible, Duration.ofSeconds(10)).click();
    }

    public boolean strategyGenreTagActiveIsDisplayed() {
        return $x(strategyGenreTagActive).shouldBe(visible, Duration.ofSeconds(10)).isDisplayed();
    }

    public void playersListBoxClick() {
        $x(playersListBox).shouldBe(visible, Duration.ofSeconds(10)).click();
    }

    public boolean multiplePlayersButtonIsDisplayed() {
        return $x(multiplePlayersButton).shouldBe(visible, Duration.ofSeconds(10)).isDisplayed();
    }

    public void multiplePlayersButtonClick() {
        $x(multiplePlayersButton).shouldBe(visible, Duration.ofSeconds(10)).click();
    }

    public boolean multiplePlayersTagActiveIsDisplayed() {
        return $x(multiplePlayersTagActive).shouldBe(visible, Duration.ofSeconds(10)).isDisplayed();
    }

    public String firstGameFilteredListGetText() {
        return $x(firstGameWithFilterParameters).shouldBe(visible, Duration.ofSeconds(10)).getText();
    }

    public void firstGameWithFilterParametersClick() {
        executeJavaScript("arguments[0].click()",
                $x(firstGameWithFilterParameters).shouldBe(visible, Duration.ofSeconds(10)));
    }
}