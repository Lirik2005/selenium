package com.lirik.commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstRun {

    public static void main(String[] args) {

        /**
         * Строкой ниже мы подтягиваем необходимы нам веб-драйвер и избавляемся от необходимости хранить актуальную версию драйвера в
         * проекте. В данном случае мы подтягиваем себе драйвер для браузера Google Chrome
         */

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver(); // Инициализирует драйвер для браузера Google Chrome
        driver.get("https://google.com");  // Открывает указанный веб-ресурс

        WebElement searchLine = driver.findElement(By.name("q")); // Находим элемент на странице с именем "q" (здесь это строка поиска)
        searchLine.sendKeys("Hello from JAVA");  // Отправляет в строку поиска указанный текст
        searchLine.submit(); // Выполняет подтверждение. Т.е. нажимает ENTER

        driver.quit(); // Закрывает браузер и убирает все его элементы из памяти
    }
}