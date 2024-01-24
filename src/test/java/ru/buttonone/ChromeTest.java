package ru.buttonone;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.itsjava.ConfProperties;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class ChromeTest {
    private WebDriver driver;
    private ConfProperties confProperties = new ConfProperties();

    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
