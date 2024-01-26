package ru.buttonone;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");



        WebDriver driver = new ChromeDriver();
        driver.get("https://store.steampowered.com/?l=russian");
        System.out.println("driver.getTitle() = " + driver.getTitle());


//        driver.close();
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.open('https://button-one.ru/')");

//        WebElement webElement = driver.findElement(By.id("genre_tab"));
//        WebElement webElement1 = driver.findElement(By.id("language_pulldown"));
//        WebElement webElement2 = driver.findElement(By.name());
//        WebElement webElement3 = driver.findElement(By.xpath());
//        WebElement webElement4 = driver.findElement(By.linkText());
//        webElement1.click();


//        driver.quit();
    }
}
