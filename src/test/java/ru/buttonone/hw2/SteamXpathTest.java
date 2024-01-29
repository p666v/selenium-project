package ru.buttonone.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.buttonone.ConfProperties;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SteamXpathTest {
    private WebDriver driver;
    private final ConfProperties confProperties = new ConfProperties();

    @BeforeClass
    public void setupClass() {
        driver = WebDriverManager.getInstance(confProperties.getProperty("browserName")).create();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get(confProperties.getProperty("test_site"));
        System.out.println("The profile setup process is completed");
    }

    @AfterClass
    void quitTest() {
        driver.quit();
    }

    @Test
    public void buttonTestIsDisplayed() {
        WebElement supportButton = driver
                .findElement(By.xpath("//a[@class='menuitem ' and contains(text(), 'ПОДДЕРЖКА')]"));

        assertTrue(supportButton.isDisplayed(), "Ожидаем 'true'");

    }


    @Test
    public void buttonTestGetTagName() {
        WebElement storeButton = driver
                .findElement(By.xpath("//a[@class='pulldown_desktop' and contains(text(), 'Магазин')]"));
        storeButton.click();
        WebElement communityRecommendationsButton = driver
                .findElement(By.xpath("//a[@class='popup_menu_item' and contains(text(), 'Рекомендации сообщества')]"));

        assertEquals(communityRecommendationsButton.getTagName(), "a", "Ожидаем 'Рекомендации сообщества");

    }

    @Test
    public void buttonTestGetAccessibleName() {
        WebElement salesLeadersButton = driver
                .findElement(By.xpath("//a[@class='gutter_item' and contains(text(), 'Лидеры продаж')]"));

        assertEquals(salesLeadersButton.getAccessibleName(), "Лидеры продаж", "Ожидаем 'Лидеры продаж'");

    }


}
