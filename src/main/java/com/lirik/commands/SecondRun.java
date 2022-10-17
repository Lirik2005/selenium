package com.lirik.commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SecondRun {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");

        WebElement searchLine = driver.findElement(By.name("q"));
        searchLine.sendKeys("Hello from JAVA");
        searchLine.submit();

        driver.navigate().to("https://selenium.dev"); //  В текущей вкладке перейдем на новый вб-ресурс
        driver.navigate().back(); // Позволит нам с веб-ресурса https://selenium.dev вернуться на предыдущую страницу
        driver.navigate().forward(); // Вернемся веб-ресурса https://selenium.dev на предыдущую страницу и потом на https://selenium.dev
        driver.navigate().refresh(); // Позволит обновить текущую страницу

        //   driver.quit();
    }
}
