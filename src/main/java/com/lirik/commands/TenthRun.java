package com.lirik.commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TenthRun {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.rambler.ru/");

        WebElement enterButton = driver.findElement(By.xpath("//span[text()='Вход']"));
        enterButton.click();

        WebElement loginFrame = driver.findElement(By.xpath(
                "//iframe[@src='https://id.rambler.ru/login-20/login?rname=head&session=false&back=https%3A%2F%2Fwww.rambler" +
                        ".ru%2F&param=iframe&iframeOrigin=https%3A%2F%2Fwww.rambler.ru']"));
        driver.switchTo().frame(loginFrame); // Этим методом переключаемся на фрейм для входа в аккаунт

        WebElement enterButtonInFrame = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@type='submit']/span" +
                                                                                                                "[text()='Войти']")));
        enterButtonInFrame.click();
    }
}
