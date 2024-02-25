package ru.buttonone.hw7.steam;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final String searchField = "//input[@id='store_nav_search_term']";
    private final String categoriesPullDown = "//div[@id='genre_tab']//a[@class = 'pulldown_desktop']";
    private final String categoriesPullDownActive = "//div[@id='genre_flyout' and contains(@style, 'block')]";
    private final String categoryMysteriesDetectivesButton = "//a[@class = 'popup_menu_item' and text() = 'Тайны и детективы']";

    public MainPage enterDataSearchField(String nameGame) {
        $x(searchField).shouldBe(visible, Duration.ofSeconds(10)).sendKeys(nameGame);
        return this;
    }

    public void searchFieldClick() {
        $x(searchField).shouldBe(visible, Duration.ofSeconds(10)).pressEnter();
    }

    public void categoriesPullDownClick() {
        $x(categoriesPullDown).shouldBe(visible, Duration.ofSeconds(10)).click();
    }

    public boolean categoriesPullDownActiveIsDisplayed() {
        return $x(categoriesPullDownActive).shouldBe(visible, Duration.ofSeconds(10)).isDisplayed();
    }

    public void categoryMysteriesDetectivesButtonClick() {
        $x(categoryMysteriesDetectivesButton).shouldBe(visible, Duration.ofSeconds(10)).click();
    }
}