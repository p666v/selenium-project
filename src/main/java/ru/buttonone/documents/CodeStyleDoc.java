package ru.buttonone.documents;

public class CodeStyleDoc {
/**
 * Правила создания МР-ов:
 *        1. Создаем задачу в JIra
 *        2. Создаем ветку от master-а
 *        3. Называем ветку: JIRA-123213_название_теста
 *        4. Пишем тест и доп классы создаем в отдельном пакете с названием hw и номер, например “hw2” (внутри пакета ru.buttonone)
 *                                      ❗ проверяем, что на данной ветке все работает ❗
 *        5. Добавляем файлы и пушим на сервер в новую ветку
 *        6. Создаем мердж реквест
 *        7. Кидаем ссылку в чат и ждем апрува
 *        8. После внесения исправлений обязательно проверяем, что все исправления действительно сделаны (не торопимся, аккуратно все проверяем)
 *        9. После апрува принимаем merge и удаляем ветку глобально
 *        10. Переключаемся на мастер (удаляем локально свою ветку) и делаем git -> update project
 *
 * Общие договоренности:
 *        1. Нельзя Пушить в мастер.Все делается через другие ветки и мерджиться в мастер через гит
 *        2. Нельзя заливать нерабочий код
 *        3. Именования классов, методов согласно Java конвенциям
 *        4. Классы, методы и переменные называем максимально осмысленно❗️
 *        5. Помогаем другу другу с домашками и с код ревью
 *        6. Ценим время других ребят и преподавателей.
 *        7. Внимательно проверяем свой МР, делаем на чистовик ❗️
 *
 *        1. Соглашения по именованию.
 *         а) Имена классов:
 *             Используйте CamelCase для имен классов. Начинайте имена классов с заглавной буквы.
 *             Пример:
 *             public class MyClassName {
 *                 // ...
 *             }
 *         б) Имена методов:
 *             Используйте camelCase для имен методов. Выбирайте описательные имена, передающие назначение метода. Начинайте имена методов с прописной буквы.
 *             Пример:
 *             public void calculateTotalPrice() {
 *                 // ...
 *             }
 *         в) Имена переменных:
 *             Используйте camelCase для имен переменных. Будьте описательными и используйте значимые имена для переменных.
 *             Начинайте имена переменных с прописной буквы. Избегайте использования однобуквенных имен переменных (за исключением счетчиков циклов).
 *             Пример:
 *             int itemCount;
 *             String customerName;
 *         г) Имена констант:
 *             Используйте заглавные буквы и подчеркивания для констант. Объявляйте константы с ключевым словом final.
 *             Разделяйте слова в именах констант подчеркиваниями.
 *             Пример:
 *             public static final int MAX_VALUE = 100;
 *         д) Имена пакетов:
 *             Используйте строчные буквы для имен пакетов. Используйте обратную доменную нотацию для именования пакетов (например, com.example.myapp).
 *        2. Форматирование кода.
 *         а) Отступы:
 *             Используйте 4 пробела для отступов (без табуляции). Сохраняйте однородный отступ во всем коде.
 *             Пример:
 *             public void exampleMethod() {
 *                 if (condition) {
 *                     // Отступ согласован
 *                     doSomething();
 *                 } else {
 *                     doSomethingElse();
 *                 }
 *             }
 *         б) Фигурные скобки:
 *             Используйте стиль "Кернигана и Ритчи" для фигурных скобок. Размещайте открывающие фигурные скобки { на той же строке, что и объявление.
 *             Пример:
 *             public void exampleMethod() {
 *                 if (condition) {
 *                     doSomething();
 *                 } else {
 *                     doSomethingElse();
 *                 }
 *             }
 *         в) Длина строки:
 *             Ограничивайте строки от 80 до 120 символов для улучшения читаемости. Разбивайте длинные строки на несколько строк при необходимости.
 *             Пример:
 *             public void exampleMethod(String parameter1, String parameter2, String parameter3,
 *                                       String parameter4, String parameter5) {
 *                 // ...
 *             }
 *        3. Комментирование и документирование:
 *         а) Комментарии:
 *             Используйте комментарии сдержанно, сосредотачиваясь на объяснении сложной логики или неочевидных решений.
 *             Пишите четкие и краткие комментарии. Избегайте комментирования очевидного.
 *             Пример:
 *             // Вычислить общую стоимость
 *             public double calculateTotalPrice() {
 *                 // ...
 *             }
 *         б) Javadoc:
 *             Используйте комментарии Javadoc для документирования классов, методов и полей.
 *             Включите информацию о назначении, параметрах, возвращаемых значениях и исключениях (если применимо) для методов.
 *             Пример:
 *         /**
 *          * Это комментарий Javadoc для класса MyClass.
 *          /*
 *                 public class MyClass {
 *                     /**
 *                      * Вычисляет общую стоимость.
 *                      *
 *                      * @param quantity Количество товаров.
 *                      * @param price Цена за единицу товара.
 *                      * @return Общая стоимость.
 *                      * /
 *                     public double calculateTotalPrice(int quantity, double price) {
 *                         // ...
 *                     }
 *                 }
 *        4. Организация кода.
 *         а) Импорты:
 *             Организуйте импорты и используйте отдельные строки для различных групп импортов (стандартные, специфичные для проекта, сторонние).
 *             Избегайте использования импортов с подстановочными символами (import java.util.*); явно импортируйте только необходимые классы.
 *             Неиспользуемых импортов в классе не должно быть.
 *             Пример:
 *             import java.util.List;
 *             import java.util.ArrayList;
 *             import com.example.myapp.MyClass;
 *         б) Структура класса:
 *             Сохраняйте последовательную структуру класса: объявление пакета, импорты, объявление класса, поля, конструкторы, методы.
 *             Группируйте связанные поля и методы вместе.
 *             Пример:
 *             package com.example.myapp;
 *             import java.util.List;
 *                     public class MyClass {
 *                         // Поля
 *                         // Конструкторы
 *                         // Методы
 *                     }
 *
 *        Hot Keys:
 * Ctrl + Space	                Список компонентов (класса, метода, переменной)
 * Ctrl + Shift + Space	        Smart code – фильтрует список из методов и переменных ожидаемого типа
 * Ctrl + Alt + Space	        Название любого класса проекта независимо от импортируемых
 * Ctrl + Shift + Enter	        Завершение оператора
 * Ctrl + P	                    Сведения о параметрах (в пределах аргументов вызоваемого метода)
 * Ctrl + Q	                    Быстрый поиск документации
 * Shift + F1	                Внешняя документация
 * Ctrl +                       Наведение мышью на фрагмент кода	Краткая информация
 * Ctrl + F1	                Показать описания ошибки или предупреждения в каретку
 * Alt + Insert	                Генерация кода (Getters, Setters, Constructors, hashCode/equals, toString)
 * Ctrl + O	                    Переопределение метода
 * Ctrl + I	                    Реализация методов
 * Ctrl + Alt + T	            Поместить фрагмент кода в (if..else, try..catch, for, synchronized, etc.)
 * Ctrl + /	                    Однострочное комментирование / раскомментирование
 * Ctrl + Shift + /	            Многострочное комментирование / раскомментирование
 * Ctrl + W	                    Выбирает последовательность возрастающих блоков кода
 * Alt + Q	                    Контекстная информация
 * Alt + Enter	                Показать предлагаемое исправление
 * Ctrl + Alt + L	            Форматирование кода
 * Ctrl + Alt + O	            Удалить неиспользуемые импорты
 * Ctrl + Alt + I	            Авто-отступ линии
 * Tab / Shift + Tab	        Отступ / удаление отступа выбранному фрагменту кода
 * Ctrl + X or Shift + Delete	Вырезать фрагмент кода
 * Ctrl + C or Ctrl + Insert	Копировать фрагмент кода
 * Ctrl + V or Shift + Insert	Вставить фрагмент кода из буфера обмена
 * Ctrl + Shift + V	            Вставить последний фрагмент кода из буфера обмена
 * Ctrl + D         	        Дублирование строки
 * Ctrl + Y	                    Удаление строки
 * Ctrl + Shift + J	            Объединение строк
 * Ctrl + Enter	                Разделение строки
 * Shift + Enter	            Начать с новой строки
 * Ctrl + Shift + U	            Переключить стоящее слово рядом с кареткой в нижний / верхний регистр
 * Ctrl + Shift + ] / [	        Выделить код до конца / начала блока
 * Ctrl + Delete	            Удалить слово после каретки
 * Ctrl + Backspace	            Удалить слово перед каретки
 * Ctrl + NumPad+/-	            Развернуть / свернуть блок кода
 * Ctrl + Shift + NumPad+	    Развернуть все
 * Ctrl + Shift + NumPad-	    Свернуть все
 * Ctrl + F4	                Закрыть активное окно редактора
 *
  */
}
