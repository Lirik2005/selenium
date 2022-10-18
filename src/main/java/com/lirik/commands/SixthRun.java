package com.lirik.commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.Set;

public class SixthRun {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");

//        driver.manage().window().setSize(new Dimension(500, 1000)); // Метод позволяет установить рандомный размер окна браузера
//        driver.manage().window().maximize(); // Метод позволяет развернуть браузер на весь экран
        driver.manage().window().fullscreen(); // Метод на алогичен предыдущему и позволяет развернуть браузер на весь экран

        Dimension size = driver.manage().window().getSize();// Метод возвращает текущий размер окна

        /**
         * Метод setPosition() начинает свой отсчет координат с верхнего левого угла экрана. Для его работы надо указать координаты по
         * оси X и по оси Y. Значения X и Y вводятся в пикселях
         */

        driver.manage().window().setPosition(new Point(50, 50)); // Метод позволяет указать в каком месте экрана откроется браузер
        driver.manage().window().getPosition(); // Метод позволяет получить текущее место экрана, где открылся браузер

        /**
         * Метод ниже отдает нам доступные типы логов. Обычно это browser, driver, client
         */

        Set<String> availableLogTypes = driver.manage().logs().getAvailableLogTypes();

        /**
         * метод ниже отдает уже конкретный лог из консоли браузера
         */

        driver.get("https://google.com/222");
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry logEntry : logEntries) {
            System.out.println(logEntry);
        }
    }
}
