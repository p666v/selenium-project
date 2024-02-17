package ru.buttonone.hw5;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.buttonone.hw5.steam.CategoryPage;
import ru.buttonone.hw5.steam.GamePage;
import ru.buttonone.hw5.steam.MainPage;
import ru.buttonone.hw5.steam.SearchPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static ru.buttonone.hw5.utilities.WebDriverSingleton.DRIVER;

public class ScenarioPageObjectTest {
    private final MainPage mainPage = new MainPage();
    private final SearchPage searchPage = new SearchPage();
    private final GamePage gamePage = new GamePage();
    private final CategoryPage categoryPage = new CategoryPage();

    @BeforeClass
    public void setupClass() {
        DRIVER.getDriver().manage().window().maximize();
    }

    @AfterClass
    void quitTest() {
        DRIVER.getDriver().quit();
    }

    @Test
    public void checkingCorrectnessSortingByReleaseDateGame() {
        mainPage.getToMainPage("test_site");
        mainPage.enterDataSearchField("Warhammer 40000");
        mainPage.searchFieldClick();
        assertTrue(searchPage.searchTagIsDisplayed(),
                "Поле ввода не активно");
        searchPage.sortingParametersDropDownClick();
        assertTrue(searchPage.sortingParametersDropDownActiveIsDisplayed(),
                "Выпадающее меню сортировки не активно");
        searchPage.releaseDateItemSortingDropDownClick();
        assertEquals(searchPage.sortingParametersDropDownGetText(), "дате выхода",
                "Пункт выбора параметра сортировки не активный");
        searchPage.freeGamesCheckBoxClick();
        assertTrue(searchPage.freeGamesCheckBoxActiveIsDisplayed(),
                "В блоке Цена пункт \"Скрыть бесплатные игры\" не активен");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String currentGame = searchPage.gameFromListGetText("Warhammer 40,000: Rogue Trader - Season Pass");
        searchPage.gameFromListClick("Warhammer 40,000: Rogue Trader - Season Pass");
        assertTrue(currentGame.equalsIgnoreCase(gamePage.gameAppGetText()),
                String.format("Игра, отрывшаяся по клику, не соответствует выбранной игре из списка." +
                        " Ожидаем = %s, факт = %s", currentGame, gamePage.gameAppGetText()));
    }

    @Test
    public void checkingCorrectReflectionProductAccordanceFilterParameters() {
        mainPage.getToMainPage("test_site");
        mainPage.categoriesPullDownClick();
        assertTrue(mainPage.categoriesPullDownActiveIsDisplayed(),
                "Выпадающее меню Категорий отсутствует");
        mainPage.categoryMysteriesDetectivesButtonClick();
        assertTrue(categoryPage.categoryMysteriesDetectivesButtonActiveIsDisplayed(),
                "Переход на страницу выбранной категории не произошёл");
        categoryPage.moveToShowMoreButton();
        categoryPage.salesLeadersButtonClick();
        assertTrue(categoryPage.salesLeadersButtonActiveIsDisplayed(),
                "Кнопка сортировки по продажам не активна");
        categoryPage.showMoreGenresButtonClick();
        assertTrue(categoryPage.showLessGenresButtonActiveIsDisplayed(),
                "Кнопка \"Показать больше\" не активна, так как не появилась кнопка \"Показать меньше\"");
        categoryPage.strategyGenreButtonClick();
        assertTrue(categoryPage.strategyGenreTagActiveIsDisplayed(),
                "Кнопка выбора жанра не активна");
        categoryPage.playersListBoxClick();
        assertTrue(categoryPage.multiplePlayersButtonIsDisplayed(),
                "При нажатии кнопки \"Игроки\" раскрывающее меню выбора количества игроков отсутствует");
        categoryPage.multiplePlayersButtonClick();
        assertTrue(categoryPage.multiplePlayersTagActiveIsDisplayed(),
                "Пункты меню выбора количества игроков не активны");
        String currentGame = categoryPage.firstGameFilteredListGetText();
        String idCurrentWindow = DRIVER.getDriver().getWindowHandle();
        categoryPage.firstGameFilteredListClick();
        for (String idWindow : DRIVER.getDriver().getWindowHandles()) {
            if (!idCurrentWindow.equals(idWindow)) {
                DRIVER.getDriver().switchTo().window(idWindow);
            }
        }
        assertTrue(currentGame.equalsIgnoreCase(gamePage.gameAppGetText()),
                String.format("Игра, отрывшаяся по клику, не соответствует выбранной игре из списка." +
                        " Ожидаем = %s, факт = %s", currentGame, gamePage.gameAppGetText()));
    }
}