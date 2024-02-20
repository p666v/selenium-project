package ru.buttonone.hw5;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.buttonone.hw5.steam.CategoryPage;
import ru.buttonone.hw5.steam.GamePage;
import ru.buttonone.hw5.steam.MainPage;
import ru.buttonone.hw5.steam.SearchPage;
import ru.buttonone.hw5.utilities.ConfProperties;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static ru.buttonone.hw5.utilities.WebDriverSingleton.INSTANCE;

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
        INSTANCE.getDriver().manage().window().maximize();
    }

    @AfterClass
    public void quitTest() {
        INSTANCE.getDriver().quit();
    }

    @Test
    public void checkingCorrectnessSortingByReleaseDateGame() {
        INSTANCE.getDriver().get(confProperties.getProperty("test-site"));
        mainPage.enterDataSearchField("Warhammer 40000");
        mainPage.searchFieldClick();
        assertEquals(INSTANCE.getDriver().getTitle(), "Поиск Steam",
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

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        searchPage.gameCorrespondsToParametersClick(GAME_NAME);
        assertEquals(gamePage.appNameGetText(), GAME_NAME,
                String.format("Игра, отрывшаяся по клику, не соответствует выбранной игре из списка." +
                        " Ожидаем = %s, факт = %s", GAME_NAME, gamePage.appNameGetText()));
        softAssert.assertAll();
    }

    @Test
    public void checkingCorrectReflectionProductAccordanceFilterParameters() {
        INSTANCE.getDriver().get(confProperties.getProperty("test-site"));
        mainPage.categoriesPullDownClick();
        assertTrue(mainPage.categoriesPullDownActiveIsDisplayed(),
                "Выпадающее меню Категорий отсутствует");
        mainPage.categoryMysteriesDetectivesButtonClick();
        assertEquals(INSTANCE.getDriver().getTitle(), "Тайны и детективы",
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
        String idCurrentWindow = INSTANCE.getDriver().getWindowHandle();
        categoryPage.firstGameWithFilterParametersClick();
        for (String idWindow : INSTANCE.getDriver().getWindowHandles()) {
            if (!idCurrentWindow.equals(idWindow)) {
                INSTANCE.getDriver().switchTo().window(idWindow);
            }
        }
        assertTrue(currentGame.equalsIgnoreCase(gamePage.appNameGetText()),
                String.format("Игра, отрывшаяся по клику, не соответствует выбранной игре из списка." +
                        " Ожидаем = %s, факт = %s", currentGame, gamePage.appNameGetText()));
        softAssert.assertAll();
    }
}