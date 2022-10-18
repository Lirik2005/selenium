package com.lirik.commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SeventhRun {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        /**
         * Код ниже задает неявное ожидание. Это значит, что наш драйвер будет ждать 2 секунды каждый раз, как ему надо будет выполнить
         * метод findElement() и искать элемент на странице. Это делается для того, чтобы дать возможность элементу появиться в
         * DOM-дереве и стать доступным для использования.
         * Устанавливать неявное ожидание рекомендуется сразу после инициализации драйвера!!!
         */

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver.get("https://cars.av.by/");
        WebElement element = driver.findElement(By.xpath("//a[@rel='nofollow']"));
        element.click();
    }
}
