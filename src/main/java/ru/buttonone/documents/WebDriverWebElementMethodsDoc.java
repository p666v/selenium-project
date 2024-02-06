package ru.buttonone.documents;

public class WebDriverWebElementMethodsDoc {
    public static void main(String[] args) {
        /**
         *
         *      WebElement
         *--------------------------------------------------------------------------------------------------------------
         *  System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
         *  WebDriver driver = new ChromeDriver();
         *  driver.get("https://store.steampowered.com/?l=russian");
         *
         *  WebElement element = driver.findElement(By.id("language_pulldown"));
         *
         *  driver.findElement(By.id());               Поиск элемента по идентификатору
         *  driver.findElement(By.tagName());          Поиск элемента по имени тега
         *  driver.findElement(By.name());             Поиск элемента по имени
         *  driver.findElement(By.className());        Поиск элемента по имени класса
         *  driver.findElement(By.linkText());         Поиск элемента по тексту ссылки
         *  driver.findElement(By.xpath());            Поиск элемента по выражению
         *  driver.findElement(By.cssSelector());      Поиск элемента с использованием CSS Selector
         *  driver.findElement(By.partialLinkText());  Поиск элемента по частичному совпадению текста гиперссылки
         *
         *  element.click();                 Активация кнопки (нажатие)
         *  element.clear();                 Очищение (если элемент - текстовое поле)
         *  element.findElement();           Поиск первого элемента согласно указанному параметру
         *  element.findElements();          Поиск всех элементов согласно указанному параметру
         *  element.getAccessibleName();     Получение значение атрибута "AccessibleName" у элемента
         *  element.getAriaRole();           Получение значение атрибута "aria-role" у элемента
         *  element.getAttribute("name");    Получение указанного атрибута
         *  element.getCssValue("color");    Получение указанного свойства CSS элемента
         *  element.getDomAttribute();       Получить значение заданного атрибута элемента
         *  element.getDomProperty();        Получение значения заданного свойства элемента
         *  element.getLocation();           Получение координат элемента
         *  element.getRect();               Получение объекта с информацией о размерах и положении элемента на странице
         *  element.getShadowRoot();         Возвращение представления теневого корня элемента для доступа к теневой модели DOM веб-компонента
         *  element.getSize();               Получение размеров элемента (ширина и высота)
         *  element.getTagName();            Получение имя тега HTML элемента
         *  element.getText();               Получите текст тега этого элемента
         *  element.isDisplayed();           Возвращает true, если элемент отображается на странице, и false, если скрыт
         *  element.isEnabled();             Возвращает true, если элемент доступен для взаимодействия, и false, если заблокирован.
         *  element.isSelected();            Возвращает true, если элемент является выбранным (например, чекбокс), и false, если нет.
         *  element.sendKeys();              Используйте этот метод для имитации ввода элемента, который может установить его значение.
         *  .submit();                       Если этот текущий элемент является формой или элементом внутри формы, он будет отправлен на удаленный сервер.
         *
         *
         *      WebDriver
         *--------------------------------------------------------------------------------------------------------------
         *  System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
         *  WebDriver driver = new ChromeDriver();
         *
         *  driver.get("https://store.steampowered.com/?l=russian"); Загрузка и открытие страницы в окне браузера
         *  driver.findElements(By by);    Найти все элементы на текущей странице, используя данный механизм
         *  driver.get(String url);        Загрузите новую веб-страницу в текущем окне браузера
         *  driver.getCurrentUrl();        Получите строку, представляющую текущий URL-адрес, который просматривает браузер
         *  driver.getPageSource();        Получите источник последней загруженной страницы
         *  driver.getTitle();             Получить заголовок текущей страницы
         *  driver.getWindowHandle();      Получение идентификатора открытого окна браузера
         *  driver.getWindowHandles();     Получение идентификаторов всех открытых окон браузера
         *  driver.quit();                 Завершение всего сеанса (закрытие всех вкладок в окне)
         *  driver.close();                Закрытие текущей страницы (прочие вкладки в окне остаются открытыми)
         *  driver.switchTo()              Отправляйте будущие команды в другой фрейм или окно:
         *      driver.switchTo().window(String nameOrHandle);       Переключите фокус будущих команд для этого драйвера на окно с заданным именем/дескриптором.
         *      driver.switchTo().alert();                           Переключается на текущий активный модальный диалог для данного конкретного экземпляра драйвера.
         *                                                           Возвращает Дескриптор диалогового окна.
         *      driver.switchTo().defaultContent();                  Этот драйвер сосредоточился на верхнем окне/первой рамке.
         *      driver.switchTo().newWindow(WindowType typeHint);    Создает новое окно браузера и переключает фокус для будущих команд этого драйвера на новое окно.
         *                                                           WindowType typeHint - тип нового окна
         *      driver.switchTo().frame(String nameOrId);            Выбери рамку по его имени или идентификатору. Фокус драйвера на эту рамку.
         *      driver.switchTo().frame(WebElement frameElement);    Выбери рамку, используя его ранее расположенный веб-элемент. Фокус драйвера на эту рамку.
         *      driver.switchTo().parentFrame();                     Этот драйвер сфокусирован на родительском фрейме
         *
         *
         * _____MANAGE
         *  driver.manage();                       Возвращает объект Options, который предоставляет доступ к различным настройкам браузера
         *  driver.manage().addCookie();           Добавление куки в текущий сеанс браузера
         *  driver.manage().deleteAllCookies();    Удаление всех куки из текущего сеанса браузера
         *  driver.manage().deleteCookie();        Удаление куки из текущего сеанса браузера
         *  driver.manage().deleteCookieNamed();   Удаление куки по указанному имени из текущего сеанса браузера
         *  driver.manage().getCookieNamed()       Получение куки по указанному имени из текущего сеанса браузера
         *  driver.manage().getCookies()           Получение всех куки из текущего сеанса браузера
         *  driver.manage().logs()                 Получение логов браузера
         *  driver.manage().timeouts()             Установление таймауты для различных операций (например, ожидание загрузки страницы)
         *  driver.manage().window()               Интерфейс управления текущим окном:
         *      driver.manage().window().fullscreen();                      Полноэкранный режим.
         *      driver.manage().window().getSize();                         Получить размер текущего окна
         *      driver.manage().window().setSize(Dimension targetSize);     Установить размер для текущего окна
         *      driver.manage().window().getPosition();                     Позиция текущего окна.
         *      driver.manage().window().setPosition(Point targetPosition); targetPosition - Целевое положение окна.
         *      driver.manage().window().maximize();                        Разворачивает текущее окно
         *      driver.manage().window().minimize();                        Сворачивает текущее окно
         *
         *
         * _____NAVIGATE
         *  driver.navigate().to("https://www.youtube.com/");  Переход на страницу по указанному URL
         *  driver.navigate().back();                          Переход на страницу назад (кнопка "Назад")
         *  driver.navigate().forward();                       Переход на страницу вперед (кнопка "Вперед")
         *  driver.navigate().refresh();                       Обновление текущей страницы браузера
         *
         *
         * WebDriver - самая важная сущность, ответственная за управление браузером. Основной ход скрипта/теста строится
         *   именно вокруг экземпляра этой сущности.
         * WebElement - вторая важная сущность, представляющая собой абстракцию над веб
         *   элементом (кнопки, ссылки, инпута и др.). WebElement инкапсулирует методы для взаимодействия пользователя
         *   с элементами и получения их текущего статуса.
         * By - абстракция над локатором веб элемента. Этот класс инкапсулирует информацию о селекторе(например, CSS),
         *   а также сам локатор элемента, то есть всю информацию, необходимую для нахождения нужного элемента на странице.
         */
    }
}
