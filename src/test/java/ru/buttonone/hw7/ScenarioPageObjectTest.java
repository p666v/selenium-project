package ru.buttonone.hw7;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.buttonone.hw7.steam.CategoryPage;
import ru.buttonone.hw7.steam.GamePage;
import ru.buttonone.hw7.steam.MainPage;
import ru.buttonone.hw7.steam.SearchPage;
import ru.buttonone.hw7.utilities.ConfProperties;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ScenarioPageObjectTest {
    private final MainPage mainPage = new MainPage();
    private final SearchPage searchPage = new SearchPage();
    private final GamePage gamePage = new GamePage();
    private final CategoryPage categoryPage = new CategoryPage();
    private final ConfProperties confProperties = new ConfProperties();
    private static final String GAME_NAME = "Warhammer 40,000: Rogue Trader - Season Pass";
    private final SoftAssert softAssert = new SoftAssert();

    @BeforeClass
    public void setupClass() {
        Configuration.browser = "chrome";
        open();
        getWebDriver().manage().window().maximize();
    }

    @AfterClass
    public void quitTest() {
        getWebDriver().quit();
    }

    @Test
    public void checkingCorrectnessSortingByReleaseDateGame() {
        open(confProperties.getProperty("test-site"));
        mainPage.enterDataSearchField("Warhammer 40000").searchFieldClick();
        assertEquals(title(), "Поиск Steam",
                "Указан заголовок некорректной страницы");
        searchPage.sortingParametersDropDownClick();
        softAssert.assertTrue(searchPage.sortingParametersDropDownActiveIsDisplayed(),
                "Выпадающее меню сортировки не активно");
        searchPage.sortingReleaseDateButtonClick();
        softAssert.assertEquals(searchPage.sortingParametersDropDownGetText(), "дате выхода",
                "Пункт выбора параметра сортировки не активный");
        searchPage.freeGamesCheckBoxClick();
        softAssert.assertTrue(searchPage.freeGamesCheckBoxActiveIsDisplayed(),
                "В блоке Цена пункт \"Скрыть бесплатные игры\" не активен");
        searchPage.gameCorrespondsToParametersClick(GAME_NAME);
        assertEquals(gamePage.appNameGetText(), GAME_NAME,
                String.format("Игра, отрывшаяся по клику, не соответствует выбранной игре из списка." +
                        " Ожидаем = %s, факт = %s", GAME_NAME, gamePage.appNameGetText()));
        softAssert.assertAll();
    }

    @Test
    public void checkingCorrectReflectionProductAccordanceFilterParameters() {
        open(confProperties.getProperty("test-site"));
        mainPage.categoriesPullDownClick();
        assertTrue(mainPage.categoriesPullDownActiveIsDisplayed(),
                "Выпадающее меню Категорий отсутствует");
        mainPage.categoryMysteriesDetectivesButtonClick();
        assertEquals(title(), "Тайны и детективы",
                "Указан заголовок некорректной страницы");
        categoryPage.moveToShowMoreButton();
        categoryPage.salesLeadersButtonClick();
        softAssert.assertTrue(categoryPage.salesLeadersButtonActiveIsDisplayed(),
                "Кнопка сортировки по продажам не активна");
        categoryPage.showMoreGenresButtonClick();
        softAssert.assertTrue(categoryPage.showLessGenresButtonIsDisplayed(),
                "Кнопка \"Показать больше\" не активна, так как не появилась кнопка \"Показать меньше\"");
        categoryPage.strategyGenreButtonClick();
        softAssert.assertTrue(categoryPage.strategyGenreTagActiveIsDisplayed(),
                "Кнопка выбора жанра не активна");
        categoryPage.playersListBoxClick();
        softAssert.assertTrue(categoryPage.multiplePlayersButtonIsDisplayed(),
                "При нажатии кнопки \"Игроки\" раскрывающее меню выбора количества игроков отсутствует");
        categoryPage.multiplePlayersButtonClick();
        softAssert.assertTrue(categoryPage.multiplePlayersTagActiveIsDisplayed(),
                "Пункты меню выбора количества игроков не активны");
        String currentGame = categoryPage.firstGameFilteredListGetText();
        String idCurrentWindow = getWebDriver().getWindowHandle();
        categoryPage.firstGameWithFilterParametersClick();
        for (String idWindow : getWebDriver().getWindowHandles()) {
            if (!idCurrentWindow.equals(idWindow)) {
                switchTo().window(idWindow);
            }
        }
        assertTrue(currentGame.equalsIgnoreCase(gamePage.appNameGetText()),
                String.format("Игра, отрывшаяся по клику, не соответствует выбранной игре из списка." +
                        " Ожидаем = %s, факт = %s", currentGame, gamePage.appNameGetText()));
        softAssert.assertAll();
    }
}