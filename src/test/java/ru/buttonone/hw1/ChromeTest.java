package ru.buttonone.hw1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.buttonone.utilities.ConfProperties;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class ChromeTest {
    private WebDriver driver;
    private final ConfProperties confProperties = new ConfProperties();

    @BeforeClass
    public void setupClass() {
        driver = WebDriverManager.getInstance(confProperties.getProperty("browserName")).create();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        System.out.println("The profile setup process is completed");
    }

    @Test
    public void testPageTitle() {
        driver.get(confProperties.getProperty("test_site"));
        assertEquals(driver.getTitle(), "Добро пожаловать в Steam");
    }

    @AfterClass
    void setupTest() {
        driver.quit();
    }

}
