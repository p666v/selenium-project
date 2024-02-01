package ru.buttonone.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import ru.buttonone.hw1.ConfProperties;

public class XpathPractice {
    public static void main(String[] args) {
        ConfProperties confProperties = new ConfProperties();
        WebDriver driver = WebDriverManager.getInstance(confProperties.getProperty("browserName")).create();
        driver.manage().window().maximize();
        driver.get(confProperties.getProperty("test_site"));

//        Кнопка категории вверху
        WebElement categoryTopButton = driver
                .findElement(By.xpath("//a[@class = 'pulldown_desktop' and text() = 'Категории']"));
        System.out.println("categoryTopButton.isDisplayed() = " + categoryTopButton.isDisplayed());


//        Надпись категории внизу
        WebElement categoryLabelBottom = driver
                .findElement(By.xpath("//div[@class = 'title' and text() = 'Категории']"));
        System.out.println("categoryLabelBottom.isDisplayed() = " + categoryLabelBottom.isDisplayed());


//        Нажать на кнопку Приключенческая игра
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(confProperties.getProperty("test_site"));
        WebElement labelCategoryBottom = driver
                .findElement(By.xpath("//a[@class = 'pulldown_desktop' and text() = 'Категории']"));
        labelCategoryBottom.click();

        WebElement adventureGameButton = driver
                .findElement(By.xpath("//a[@class = 'popup_menu_item' and contains(text(), 'Приключенческая игра')]"));
        System.out.println("adventureGameButton.isDisplayed() = " + adventureGameButton.isDisplayed());
        adventureGameButton.click();

    }
}
