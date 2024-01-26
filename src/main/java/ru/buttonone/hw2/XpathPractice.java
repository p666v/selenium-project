package ru.buttonone.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import ru.buttonone.ConfProperties;

public class XpathPractice {
    public static void main(String[] args) {
        ConfProperties confProperties = new ConfProperties();
        WebDriver driver = WebDriverManager.getInstance(confProperties.getProperty("browserName")).create();
        driver.manage().window().maximize();
        driver.get(confProperties.getProperty("test_site"));

//        Кнопка категории вверху
        WebElement element1 = driver
                .findElement(By.xpath("//a[@class = 'pulldown_desktop' and text() = 'Категории']"));
        System.out.println("element1.isDisplayed() = " + element1.isDisplayed());


//        Надпись категории внизу
        WebElement element2 = driver
                .findElement(By.xpath("//div[@class = 'title' and text() = 'Категории']"));
        System.out.println("element2.isDisplayed() = " + element2.isDisplayed());


//        Нажать на кнопку Приключенческая игра
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(confProperties.getProperty("test_site"));
        WebElement element3 = driver
                .findElement(By.xpath("//a[@class = 'pulldown_desktop' and text() = 'Категории']"));
        element3.click();

        WebElement element4 = driver
                .findElement(By.xpath("//a[@class = 'popup_menu_item' and contains(text(), 'Приключенческая игра')]"));
        System.out.println("element4.isDisplayed() = " + element4.isDisplayed());
        element4.click();


    }
}
