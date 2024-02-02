package ru.buttonone.documents;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PracticeSelenium {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://store.steampowered.com/?l=russian");
        System.out.println("driver.getTitle() = " + driver.getTitle());


        Actions actions = new Actions(driver);
//        actions.pause(Duration.ofSeconds(5));
        actions.scrollByAmount(0, 2250).perform();
//
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//img[@alt = 'TEKKEN 8']/ancestor::a[contains(@class,'app_impression_tracked')]//div[@class = 'discount_final_price']"))));
//        WebElement element = driver.findElement(By.xpath("//img[@alt = 'TEKKEN 8']/ancestor::a[contains(@class,'app_impression_tracked')]//div[@class = 'discount_final_price']"));
        System.out.println("element.getText() = " + element.getText());

//        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//        jsExecutor.executeScript("window.scrollBy(0, " + 2250 + ");");
//        WebElement element = driver.findElement(By.xpath("//img[@alt = 'TEKKEN 8']/ancestor::a[contains(@class,'app_impression_tracked')]//div[@class = 'discount_final_price']"));
//
//        System.out.println("element.getText() = " + element.getText());


//        driver.close();
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.open('https://button-one.ru/')");

//        WebElement webElement = driver.findElement(By.id("genre_tab"));
//        WebElement webElement1 = driver.findElement(By.id("language_pulldown"));
//        WebElement webElement2 = driver.findElement(By.name());
//        WebElement webElement3 = driver.findElement(By.xpath());
//        WebElement webElement4 = driver.findElement(By.linkText());
//        webElement1.click();


        driver.quit();
    }
}
