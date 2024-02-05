package ru.buttonone.documents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ru.buttonone.utilities.ConfProperties;

import java.time.Duration;

public class ActionsDoc {
    public static void main(String[] args) {
        ConfProperties confProperties = new ConfProperties();
        WebDriver driver = WebDriverManager.getInstance(confProperties.getProperty("browserName")).create();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get(confProperties.getProperty("test_site"));
        WebElement clickable = driver.findElement(By.id("clickable"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(clickable)
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .perform();
        /**
         * Класс Actions представляет собой набор отдельных действий, которые вы хотите выполнить.
         * Это возможность, предоставляемая Selenium для обработки событий клавиатуры и мыши.
         *
         * build()                    Создает составное действие, содержащее все действия, готовые к выполнению
         *                            (и сбрасывает внутреннее состояние построителя, поэтому последующие вызовы этого
         *                            метода будут содержать новые последовательности).
         * click()                    Щелчки в текущем местоположении мыши/середине данного элемента.
         * clickAndHold()             Щелкает (не отпуская) в текущем местоположении мыши/середине данного элемента.
         * contextClick()             Выполняет контекстный щелчок в текущем местоположении мыши/середине данного элемента.
         * doubleClick()              Выполняет двойной щелчок в текущем местоположении мыши/середине данного элемента.
         * dragAndDrop()              Выполняет щелчок и удерживание в месте расположения исходного элемента, перемещается к местоположению целевого элемента, а затем отпускает мышь.
         * dragAndDropBy()            Выполняет щелчок и удерживание в месте расположения исходного элемента, перемещает его на заданное смещение, а затем отпускает мышь.
         * keyDown()                  Выполняет нажатие клавиши-модификатора/после фокусировки на элементе.
         * keyUp()                    Выполняет отпускание клавиши-модификатора/после фокусировки на элементе.
         * moveByOffset()             Перемещает мышь из текущей позиции (или 0,0) на заданное смещение.
         * moveToElement()            Перемещает указатель мыши в середину элемента/на смещение от центральной точки элемента
         * moveToLocation()           Перемещает мышь по указанным координатам на экране независимо от начального положения мыши.
         * pause()                    Выполняет паузу.
         * perform()                  Выполнения действий без предварительного вызова build().
         * release()                  Отпускает нажатую левую кнопку мыши в текущем положении мыши/середине данного элемента.
         * scrollByAmount()           Прокручивает на заданное количество, начало координат находится в верхнем левом углу области просмотра.
         * scrollFromOrigin()         Прокручивает на указанную сумму в зависимости от указанного источника.
         * scrollToElement()          Если элемент находится за пределами области просмотра, происходит прокрутка нижней части элемента до нижней части области просмотра.
         * sendKeys()                 Отправляет ключи активному элементу.
         */
    }
}
