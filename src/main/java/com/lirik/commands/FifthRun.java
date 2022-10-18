package com.lirik.commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class FifthRun {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/login.php");

        WebElement loginInput = driver.findElement(By.xpath("//input[@type='text']"));
        loginInput.sendKeys("Hello from JAVA"); // Данный метод вводит указанный текст в поле для заполнения

        Thread.sleep(3000);

        loginInput.clear(); // Данный метод очищает поле для заполнения от введенного текста

        loginInput.isDisplayed(); // Данный метод показывает, присутствует ли данное поле на экране
        loginInput.isEnabled(); // Данный метод показывает, доступно ли данное поле (т.е. можно ли с ним взаимодействовать)
        loginInput.isSelected(); // Данный метод показывает, выбрано ли данное поле (используется для radio buttons или checkbox)
    }
}
