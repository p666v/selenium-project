package ru.buttonone.hw4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.buttonone.utilities.ConfProperties;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ScenarioPracticeTest {
    private WebDriver driver;
    private final ConfProperties confProperties = new ConfProperties();
    private WebDriverWait webDriverWait;

    @BeforeClass
    public void setupClass() {
        driver = WebDriverManager.getInstance(confProperties.getProperty("browserName")).create();
        driver.manage().window().maximize();
    }

    @AfterClass
    void quitTest() {
        driver.quit();
    }

    @Test
    public void checkingCorrectnessSortingByReleaseDateGame() {
        driver.get(confProperties.getProperty("test_site"));
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement searchField = webDriverWait.until(visibilityOfElementLocated(By.id("store_nav_search_term")));
        searchField.sendKeys("Warhammer 40000");
        searchField.submit();
        assertTrue(webDriverWait
                        .until(visibilityOfElementLocated(By.xpath("//div[@class='searchtag tag_dynamic']"))).isDisplayed(),
                "Поле ввода не активно");

        WebElement sortingParametersDropDown = webDriverWait.until(visibilityOfElementLocated(By.id("sort_by_trigger")));
        sortingParametersDropDown.click();
        assertTrue(webDriverWait
                        .until(visibilityOfElementLocated(By.xpath("//a[@class='trigger activetrigger']"))).isDisplayed(),
                "Выпадающее меню сортировки не активно");

        WebElement releaseDateItemSortingDropDown = webDriverWait.until(visibilityOfElementLocated(By.xpath("//a[@class='inactive_selection' and text() = 'дате выхода']")));
        releaseDateItemSortingDropDown.click();
        assertEquals(webDriverWait
                        .until(visibilityOfElementLocated(By.xpath("//a[@id='sort_by_trigger' and text() = 'дате выхода']"))).getText(),
                "дате выхода", "Пункт сортировки некорректный");

        WebElement freeGamesCheckBox = webDriverWait.until(visibilityOfElementLocated(By.xpath("//span[@data-loc='Скрыть бесплатные игры']")));
        freeGamesCheckBox.click();
        assertTrue(webDriverWait
                        .until(visibilityOfElementLocated(By.xpath("//span[contains(@class,'checked') and @data-loc='Скрыть бесплатные игры']"))).isDisplayed(),
                "В блоке Цена пункт \"Скрыть бесплатные игры\" не активен");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        List<WebElement> allGamesSorted = webDriverWait.until(visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='search_resultsRows']/descendant::a")));
        String nameGame = "";
        for (WebElement game : allGamesSorted) {
            if (game.findElement(By.xpath(".//span[@class = 'title']")).getText()
                    .equals("Warhammer 40,000: Rogue Trader - Season Pass")) {
                nameGame = game.getText();
                game.click();
                break;
            }
        }
        assertTrue(nameGame.contains(webDriverWait.until(visibilityOfElementLocated(By.id("appHubAppName"))).getText()),
                "Игра, отрывшаяся по клику, не соответствует выбранной игре из списка");
    }

    @Test
    public void checkingCorrectReflectionProductAccordanceFilterParameters() {
        driver.get(confProperties.getProperty("test_site"));
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        WebElement categoriesDropdown = webDriverWait
                .until(visibilityOfElementLocated(By.xpath("//div[@id='genre_tab']//a[@class = 'pulldown_desktop']")));
        categoriesDropdown.click();
        assertTrue(webDriverWait
                        .until(visibilityOfElementLocated(By.xpath("//div[@id='genre_flyout' and contains(@style, 'block')]"))).isDisplayed(),
                "Выпадающее меню Категорий отсутствует");

        WebElement categoryButtonMysteriesDetectives = webDriverWait
                .until(visibilityOfElementLocated(By.xpath("//a[@class = 'popup_menu_item' and text() = 'Тайны и детективы']")));
        categoryButtonMysteriesDetectives.click();
        assertTrue(webDriverWait
                        .until(visibilityOfElementLocated(By.xpath("//div[@class='Panel Focusable']//div[text()='Тайны и детективы']"))).isDisplayed(),
                "Переход на страницу выбранной категории не произошёл");

        actions.moveToElement(webDriverWait
                .until(visibilityOfElementLocated(By.xpath("//div[contains(@class, 'salesection_ShowContentsContainer')]//button[text()='Показать больше']")))).perform();
        WebElement salesLeadersButton = webDriverWait
                .until(visibilityOfElementLocated(By.xpath("//div[contains(@class, 'FlavorLabel') and text() = 'Лидеры продаж']")));
        salesLeadersButton.click();
        assertTrue(webDriverWait
                        .until(visibilityOfElementLocated(By.xpath("//div[contains(@class, 'SelectedFlavor') and text() = 'Лидеры продаж']"))).isDisplayed(),
                "Кнопка сортировки по продажам не активна");

        WebElement showMoreGenresButton = webDriverWait
                .until(visibilityOfElementLocated(By.xpath("//div[contains(@class, 'FacetValueShowMore')]")));
        showMoreGenresButton.click();
        assertTrue(webDriverWait
                        .until(visibilityOfElementLocated(By.xpath("//div[contains(@class, 'FacetValue')]/a[text()='Гонки']"))).isDisplayed(),
                "Кнопка \"Показать Больше\" не активна");

        WebElement strategyGenreButton = webDriverWait
                .until(visibilityOfElementLocated(By.xpath("//a[contains(@class,'FacetValueName') and text()='Стратегия']")));
        strategyGenreButton.click();
        assertTrue(webDriverWait
                        .until(visibilityOfElementLocated(By.xpath("//span[text()='Стратегия']"))).isDisplayed(),
                "Кнопка выбора жанра не активна");

        WebElement playersListBox = webDriverWait
                .until(visibilityOfElementLocated(By.xpath("//div[contains(@class,'FacetTitle') and text()='Игроки']")));
        playersListBox.click();
        assertTrue(webDriverWait
                        .until(visibilityOfElementLocated(By.xpath("//a[contains(@class,'FacetValueName') and text()='Для нескольких игроков']"))).isDisplayed(),
                "Кнопка выбора количества игроков не активна");

        WebElement multiplePlayersButton = webDriverWait
                .until(visibilityOfElementLocated(By.xpath("//a[contains(@class,'FacetValueName') and text()='Для нескольких игроков']")));
        multiplePlayersButton.click();
        assertTrue(webDriverWait
                        .until(visibilityOfElementLocated(By.xpath("//span[text()='Для нескольких игроков']"))).isDisplayed(),
                "Подпункт выбора количества игроков не активен");

        WebElement firstGameFilteredList = webDriverWait
                .until(visibilityOfElementLocated(By.xpath("//div[contains(@class, 'FacetedBrowseItems')]/div[1]//div[contains(@class, 'StoreSaleWidgetTitle')]")));
        String nameGame = firstGameFilteredList.getText();
        jsExecutor.executeScript("arguments[0].click()", firstGameFilteredList);
        Set<String> windowHandles = driver.getWindowHandles();
        for (String idWindow : windowHandles) {
            if (!driver.getWindowHandle().equals(idWindow)) {
                driver.switchTo().window(idWindow);
            }
        }
        assertTrue(nameGame.equalsIgnoreCase(webDriverWait.until(visibilityOfElementLocated(By.id("appHubAppName"))).getText()),
                "Игра, отрывшаяся по клику, не соответствует выбранной игре из списка");
    }
}
