package com.lirik.commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EighthRun {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Метод задает явное ожидание в 5 секунд.

        driver.get("https://cars.av.by/");

        /**
         * Код ниже использует объект wait, чтобы задать ожидание для указанного элемента.
         * Здесь драйвер будет ждать появление элемента в течение 5 секунд.
         * В отличие от неявного ожидания, явное ожидание применятся лишь к тем элементам у которых оно вызвано.
         */

        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@rel='nofollow']")));
        element.click();
    }
}
