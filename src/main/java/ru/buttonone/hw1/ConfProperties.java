package ru.buttonone.hw1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfProperties {

    private Properties properties;

    public String getProperty(String key) {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/conf.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            System.out.println("Файл properties отсутствует");
        }
        return properties.getProperty(key);
    }
}
