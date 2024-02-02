package ru.buttonone.documents;

public class ChromeOptionsMethodsDoc {
    public static void main(String[] args) {
        /**
         *  МЕТОДЫ
         *--------------------------------------------------------------------------------------------------------------
         *  addEncodedExtensions(String... encoded)               Добавляет закодированные расширения (плагины) к браузеру
         *  addExtensions(File... paths)                          Добавляет новое расширение для установки при запуске браузера
         *  addArguments(String... arguments)                     Добавляет дополнительные аргументы командной строки, которые будут использоваться при запуске
         *  asMap()                                               Возвращает карту (Map), представляющую текущие опции
         *  getPlatform()
         *  getBrowserName()                                      Возвращает имя браузера
         *  getBrowserVersion()                                   Возвращает версию браузера
         *  getCapability()                                       Возвращает значение указанной возможности
         *  getCapabilityNames()                                  Возвращает названия всех возможностей
         *  getPlatformName()                                     Возвращает имя платформы
         *  merge(Capabilities extraCapabilities)                 Комбинирует настройки из разных наборов параметров (merge)
         *  setAcceptInsecureCerts(boolean acceptInsecureCerts)
         *  setBinary(File path)                                  Устанавливает путь к исполняемому файлу Chrome.
         *  setCapability(String capabilityName, boolean value)
         *  setExperimentalOption(String name, Object value)      Устанавливает экспериментальный вариант.
         *  setHeadless(boolean headless)
         *  setPageLoadStrategy(PageLoadStrategy strategy)
         *  setProxy(Proxy proxy)
         *  setUnhandledPromptBehaviour(UnexpectedAlertBehaviour behaviour)
         *
         *
         *  ChromeOptions options = new ChromeOptions();
         *  ChromeOptions options1 = new ChromeOptions();
         *  ChromeOptions options2 = new ChromeOptions();
         *
         *  options.addArguments("start-maximized", "incognito"); // Добавляет дополнительные аргументы (параметры) запуска браузера
         *  options1.addArguments("start-maximized");
         *  options2.addArguments("incognito");
         *  options.addExtensions(new File(("C:\\Users\\dmark\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\gkojfkhlekighikafcpjkiklfbnlmeio\\1.219.646_0.crx"))); // Добавляет расширение (плагин) к браузеру
         *  options.setExperimentalOption("download.default.directory", "C:\\Users\\dmark\\Desktop\\internship\\selenium\\new Downloads"); // Устанавливает экспериментальные опции для браузера (например, настройка каталога для скачивания)
         *
         *  WebDriver driver1 = new ChromeDriver(options);
         *  driver1.get("https://www.youtube.com/");
         *
         *  WebDriver driver2 = new ChromeDriver(options1.merge(options2)); // Комбинирует настройки из разных наборов параметров (merge)
         *  driver2.get("https://store.steampowered.com/?l=russian");
         *
         */
    }
}
