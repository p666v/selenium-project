package ru.buttonone.documents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.buttonone.utilities.ConfProperties;

import java.time.Duration;

public class WaitsDoc {
    public static void main(String[] args) {
        ConfProperties confProperties = new ConfProperties();

        WebDriver driver = WebDriverManager.getInstance(confProperties.getProperty("browserName")).create();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get(confProperties.getProperty("test_site"));
        /**
         * Implicit Wait, или неявное ожидание, — пожалуй, самый популярный способ ожидания в Selenium благодаря своей легкости в использовании.
         * Чтобы использовать Implicit Wait в автотестестах, достаточно:
         *    - установить его всего 1 раз
         *    - указать вручную лимит ожидания.
         * После того как команда исполнится, Implicit Wait будет действовать на протяжении всего пробега авто тестов и
         * ожидать указанное время прежде, чем выбросить Exception (или не выбрасывать, если необходимый элемент на странице найден).
         *
         * driver.manage().timeouts().
         *   getImplicitWaitTimeout();  Получает время, в течение которого драйвер должен ждать при поиске элемента, если он отсутствует сразу
         *   getPageLoadTimeout();      Получает время ожидания завершения загрузки страницы перед выдачей ошибки
         *   getScriptTimeout();        Получает время ожидания завершения выполнения асинхронного сценария перед выдачей ошибки
         *   implicitlyWait();          Указывает время, в течение которого драйвер должен ждать при поиске элемента, если он отсутствует сразу
         *   pageLoadTimeout();         Устанавливает время ожидания завершения загрузки страницы перед выдачей ошибки
         *   scriptTimeout();           Устанавливает время ожидания завершения выполнения асинхронного сценария перед выдачей ошибки
         */


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt = 'Симулятор Чушпана']")));
        /**
         * Explicit wait, или явное ожидание, чаще используется для ожидания определенного условия, которое должно быть
         * выполнено прежде, чем тест пойдет дальше.
         * О явном ожидании стоит помнить следующие вещи:
         *    - ожидание сработает именно там, где оно указано;
         *    - как и неявному ожиданию, ему необходимо указать лимит времени;
         *    - ожидает выполнения необходимого условия;
         *    - ждет завершения Ajax request.
         *
         * alertIsPresent()                          Возвращает условие ожидания появления всплывающего окна
         * and()                                     Ожидание с логикой и условием данного списка условий.
         * attributeContains()                       Проверка, что указанный элемент содержит атрибут с конкретным значением
         * attributeToBe()                           Проверка, что указанный элемент имеет атрибут с определенным значением.
         * attributeToBeNotEmpty()                   Проверка, что у элемента с указанным локатором есть атрибут с непустым значением.
         * domAttributeToBe()                        Ожидание проверки данного WebElement имеет атрибут DOM с определенным значением.
         * domPropertyToBe()                         Ожидание проверки данного WebElement имеет свойство DOM с определенным значением.
         * elementSelectionStateToBe()               Ожидание проверки того, выбран ли данный элемент.
         * elementToBeClickable()                    Ожидание проверки элемента отображается и включено, так что вы можете щелкнуть по нему.
         * elementToBeSelected()                     Ожидание проверки того, выбран ли данный элемент.
         * frameToBeAvailableAndSwitchToIt()         Ожидание проверки доступности данного кадра для переключения.
         * invisibilityOf()                          Ожидание проверки невидимости элемента
         * invisibilityOfAllElements()               Ожидание проверки невидимости всех элементов из данного списка.
         * invisibilityOfElementLocated()            Ожидание проверки того, что элемент либо невидим, либо отсутствует в DOM.
         * invisibilityOfElementWithText()           Ожидание проверки того, что элемент с текстом либо невидим, либо отсутствует в DOM.
         * javaScriptThrowsNoExceptions()            Ожидание проверки того, является ли js исполняемым.
         * jsReturnsValue()                          Ожидание значения String из JavaScript
         * not()                                     Ожидание с условием, логически противоположным данному состоянию.
         * numberOfElementsToBe()                    Ожидание проверки количества WebElements с заданным локатором
         * numberOfElementsToBeLessThan()            Ожидается проверка количества веб-элементов с заданным локатором, меньшим определенного числа.
         * or()                                      Ожидание с логическим или условием из данного списка условий.
         * presenceOfAllElementsLocatedBy()          Ожидание проверки наличия на веб-странице хотя бы одного элемента.
         * presenceOfElementLocated()                Ожидание проверки присутствия элемента в DOM страницы.
         * presenceOfNestedElementLocatedBy()        Ожидание проверки дочернего WebElement как части родительского элемента для представления
         * refreshed()                               Обертка для условия, позволяющая обновлять элементы путем перерисовки.
         * stalenessOf()                             Подождите, пока элемент больше не будет прикреплен к DOM.
         * textMatches()                             Ожидание проверки WebElement с данным локатором содержит текст со значением как часть.
         * textToBe()                                Ожидание проверки WebElement с данным локатором имеет определенный текст.
         * textToBePresentInElement()                Ожидание проверки наличия данного текста в указанном элементе.
         * textToBePresentInElementLocated()         Ожидание проверки наличия данного текста в элементе, соответствующем данному локатору.
         * textToBePresentInElementValue()           Ожидание проверки наличия данного текста в атрибуте значения указанного элемента.
         * titleContains()                           Ожидание проверки того, что заголовок содержит подстроку, чувствительную к регистру.
         * titleIs()                                 Ожидание проверки заголовка страницы.
         * urlContains()                             Ожидание того, что URL-адрес текущей страницы будет содержать определенный текст.
         * urlMatches()                              Ожидание соответствия URL-адреса определенному регулярному выражению.
         * urlToBe()                                 Ожидается, что URL-адрес текущей страницы будет конкретным URL-адресом.
         * visibilityOf()                            Ожидание проверки видимости элемента, о котором известно, что он присутствует в DOM страницы.
         * visibilityOfAllElements()                 Ожидание проверки того, что все элементы, присутствующие на веб-странице, соответствующие локатору, видимы.
         * visibilityOfAllElementsLocatedBy()        Ожидание проверки того, что все элементы, присутствующие на веб-странице, соответствующие локатору, видимы.
         * visibilityOfElementLocated()              Ожидание проверки наличия элемента в DOM страницы и его видимости.
         * visibilityOfNestedElementsLocatedBy()     Ожидание проверки видимости дочернего WebElement как части родительского элемента.
         */


        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        WebElement webElement = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt = 'Симулятор Чушпана']")));
        /**
         * FluentWait - умные ожидания, те же явные ожидания но с доп. методами.
         * Разница между FluentWait и Explicit Wait:
         * попросту говоря, Explicit Wait имеет несколько установленных методов ожидания с предварительными условиями,
         * а Fluent wait позволяет настроить свои собственные методы для решения различных проблем ожидания.
         *
         * ignoreAll()            Настраивает этот экземпляр так, чтобы он игнорировал определенные типы исключений во время ожидания условия.
         * ignoring()             Настраивает этот экземпляр так, чтобы он игнорировал определенные типы исключений во время ожидания условия.
         * pollingEvery()         Устанавливает частоту оценки условия.
         * timeoutException()     Выдает исключение тайм-аута.
         * until()                Повторно применяет входное значение этого экземпляра к заданной функции до тех пор,
         *   пока не произойдет одно из следующих событий: функция не возвращает ни null, ни false функция выдает
         *   не игнорируемое исключение истечение времени ожидания текущий поток прерывается
         * withMessage()          Устанавливает сообщение, которое будет отображаться по истечении времени.
         * withTimeout()          Устанавливает, как долго ждать, пока оцененное условие станет истинным.
         */


    }
}
