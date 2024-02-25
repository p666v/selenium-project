package ru.buttonone.hw7.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfProperties {

    public String getProperty(String key) {
        Properties properties;
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/conf.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            System.out.println("Файл properties отсутствует");
            throw new RuntimeException();
        }
        return properties.getProperty(key);
    }
}