package ru.buttonone.hw4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.buttonone.utilities.ConfProperties;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ScenarioPracticeTest {
    private WebDriver driver;
    private final ConfProperties confProperties = new ConfProperties();
    private final SoftAssert softAssertion = new SoftAssert();
    private WebDriverWait webDriverWait;

    @BeforeClass
    public void setupClass() {
        driver = WebDriverManager.getInstance(confProperties.getProperty("browserName")).create();
        driver.manage().window().maximize();
        driver.get(confProperties.getProperty("test_site"));
    }

    @AfterClass
    void quitTest() {
        driver.quit();
    }

    @Test
    public void checkingCorrectnessSortingByReleaseDateGame() throws InterruptedException {
        driver.get(confProperties.getProperty("test_site"));
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement inputBox = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("store_nav_search_term")));
        assertTrue(inputBox.isDisplayed(), "Поле ввода не найдено");
        inputBox.sendKeys("Warhammer 40000");
        inputBox.submit();

        WebElement searchTag = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='searchtag_tmpl' and @class='searchtag tag_dynamic']")));
        String searchTagText = searchTag.getText();
        softAssertion.assertTrue(searchTag.isDisplayed(), "Лейбл результатов поиска отсутствует");
        softAssertion.assertEquals(searchTagText, "\"Warhammer 40000\"", String.format("Результат поиска указан некорректно, факт = %s", searchTagText));
        softAssertion.assertAll();

        WebElement sortingParameters = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sort_by_trigger")));
        assertTrue(sortingParameters.isDisplayed(), "Блок \"Сортировать по\" не найден");
        sortingParameters.click();

        WebElement releaseDate = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='inactive_selection' and text() = 'дате выхода']")));
        assertTrue(releaseDate.isDisplayed(), "Блок \"дате выхода\" не найден");
        releaseDate.click();

        WebElement freeGames = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class, 'tab_filter_control') and @data-loc='Скрыть бесплатные игры']")));
        assertTrue(freeGames.isDisplayed(), "Блок \"Скрыть бесплатные игры\" не найден");
        freeGames.click();

        WebElement queryResult = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='search_results_filtered_warning_persistent']/div[contains(text(), 'Результатов по вашему запросу')]")));
        assertTrue(queryResult.isDisplayed(), "Надпись \"Результатов по вашему запросу\" не найдена");

        Thread.sleep(5000);
        List<WebElement> allGamesSorted = webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='search_resultsRows']/descendant::a")));
        for (WebElement game : allGamesSorted) {
            WebElement currentGame = game.findElement(By.xpath(".//span[@class = 'title']"));
            if (currentGame.getText().equals("Warhammer 40,000: Rogue Trader - Season Pass")) {
                String gameLink = game.getAttribute("href");
                driver.navigate().to(gameLink);
                break;
            }
        }
        assertEquals(driver.getTitle(), "Warhammer 40,000: Rogue Trader - Season Pass в Steam", String.format("Заголовок некорректный, факт = %s", driver.getTitle()));
    }

    @Test
    public void checkingCorrectReflectionProductAccordanceFilterParameters() {
        driver.get(confProperties.getProperty("test_site"));
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        WebElement categoriesButton = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span//a[@class = 'pulldown_desktop' and text() = 'Категории']")));
        assertTrue(categoriesButton.isDisplayed(), "Пункт меню \"Категории\" не найден");
        categoriesButton.click();

        WebElement categoryButtonMysteriesDetectives = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class = 'popup_menu_item' and text() = 'Тайны и детективы']")));
        assertTrue(categoryButtonMysteriesDetectives.isDisplayed(), "Пункт меню \"Тайны и детективы\" не найден");
        categoryButtonMysteriesDetectives.click();

        actions.scrollByAmount(0, 2200).perform();
        WebElement salesLeadersButton = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'FlavorLabel_Dhg57') and text() = 'Лидеры продаж']")));
        assertTrue(salesLeadersButton.isDisplayed(), "Пункт меню \"Лидеры продаж\" не найден");
        salesLeadersButton.click();

        WebElement filterButtonShowMoreGenres = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='facetedbrowse_FacetValueShowMore_230Th']")));
        assertTrue(filterButtonShowMoreGenres.isDisplayed(), "Пункт \"Показать больше\" не найден");
        filterButtonShowMoreGenres.click();

        WebElement strategyGenreButton = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'facetedbrowse_FacetValueName') and text()='Стратегия']")));
        assertTrue(strategyGenreButton.isDisplayed(), "Пункт фильтра \"Стратегия\" не найден");
        strategyGenreButton.click();

        WebElement filterItemPlayers = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'facetedbrowse_FacetTitle') and text()='Игроки']")));
        assertTrue(filterItemPlayers.isDisplayed(), "Пункт фильтра \"Игроки\" не найден");
        filterItemPlayers.click();

        WebElement filterItemMultiplePlayers = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'facetedbrowse_FacetValueName') and text()='Для нескольких игроков']")));
        assertTrue(filterItemMultiplePlayers.isDisplayed(), "Пункт фильтра Игроки \"Для нескольких игроков\" не найден");
        filterItemMultiplePlayers.click();

        WebElement firstGameFilteredList = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'facetedbrowse_FacetedBrowseItems')]/div[1]//div[contains(@class, 'salepreviewwidgets_TitleCtn')]/a")));
        assertTrue(firstGameFilteredList.isDisplayed(), "Список игр не найден");
        System.out.println("firstGameFilteredList.getText() = " + firstGameFilteredList.getText());
        driver.get(firstGameFilteredList.getAttribute("href"));
        assertEquals(driver.getTitle(),"West Hunt в Steam", String.format("Заголовок некорректный, факт = %s", driver.getTitle()));
    }
}
