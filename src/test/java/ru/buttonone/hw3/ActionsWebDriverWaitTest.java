package ru.buttonone.hw3;

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

public class ActionsWebDriverWaitTest {
    private WebDriver driver;
    private final ConfProperties confProperties = new ConfProperties();
    private final SoftAssert softAssertion = new SoftAssert();

    @BeforeClass
    public void setupClass() {
        driver = WebDriverManager.getInstance(confProperties.getProperty("browserName")).create();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        driver.manage().window().maximize();
        driver.get(confProperties.getProperty("test_site"));
    }

    @AfterClass
    void quitTest() {
        driver.quit();
    }

    @Test
    public void checkingPriceCurrencyTest() {
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0, 2250).perform();
        WebElement popularSimulatorNoveltiesButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//img[@alt = 'Симулятор Чушпана']/ancestor::a[contains(@class,'app_impression_tracked')]//div[@class = 'discount_final_price']")));
        String priceText = popularSimulatorNoveltiesButton.getText();
        String[] parts = priceText.split(" ");
        softAssertion
                .assertEquals(parts[0], "48", String.format("Цена указана некорректно, факт = %s", parts[0]));
        softAssertion
                .assertEquals(parts[1], "pуб.", String.format("Валюта указана некорректно, факт = %s", parts[1]));
        softAssertion.assertAll();
    }
}
