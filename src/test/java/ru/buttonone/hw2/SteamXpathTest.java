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
        WebElement element = driver
                .findElement(By.xpath("//a[@class='menuitem ' and contains(text(), 'ПОДДЕРЖКА')]"));
        System.out.println("buttonTestIsDisplayed = " + element.isDisplayed());

        assertTrue(element.isDisplayed(), "true");

    }


    @Test
    public void buttonTestGetTagName() {
        WebElement element1 = driver
                .findElement(By.xpath("//a[@class='pulldown_desktop' and contains(text(), 'Магазин')]"));
        element1.click();

        WebElement element2 = driver
                .findElement(By.xpath("//a[@class='popup_menu_item' and contains(text(), 'Рекомендации сообщества')]"));
        System.out.println("buttonTestGetTagName = " + element2.isDisplayed());

        assertEquals(element2.getTagName(), "a");

    }

    @Test
    public void buttonTestGetAccessibleName() {
        WebElement element = driver
                .findElement(By.xpath("//a[@class='gutter_item' and contains(text(), 'Лидеры продаж')]"));
        System.out.println("element.isDisplayed() = " + element.isDisplayed());

        assertEquals(element.getAccessibleName(), "Лидеры продаж");

    }


}
