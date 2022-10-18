package com.lirik.commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FourthRun {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/login.php");

        WebElement loginButton = driver.findElement(By.xpath("//button[@id='loginbutton']"));
        loginButton.submit(); // Т.к. у этой кнопки на сайте указан type="submit", то это действие позволит нажать на эту кнопку
//        loginButton.click(); // Так тоже можно нажать на эту кнопку

        Thread.sleep(5000); // Просто небольшое ожидание для того, чтобы увидеть работу драйвера

        driver.get("https://www.facebook.com/login.php");

        WebElement createNewAccountButton = driver.findElement(By.xpath("//a[@rel='nofollow']"));
//        createNewAccountButton.submit(); // Т.к. у этой кнопки на сайте не указан type="submit", код не выполнится и будет ошибка
        createNewAccountButton.click(); // В таком варианте код отработает и мы перейдем по ссылке в кнопке

    }
}
