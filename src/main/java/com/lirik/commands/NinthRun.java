package com.lirik.commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NinthRun {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        Alert alert;

        driver.get("https://javascript.info/alert-prompt-confirm");

        /**
         * Обычное модальное окно (alert) с текстовым сообщением и одной кнопкой (ok, accept, confirm, submit и так далее)
         */

        WebElement alertButton = driver.findElement(By.xpath("(//a[@title='run'])[1]"));
        alertButton.click();

        alert = driver.switchTo().alert();
        Thread.sleep(2000);
        String alertText = alert.getText(); // Данный метод возвращает текст с экрана модального окна
        System.out.println("Text from alert window: " + alertText);
        alert.accept(); // Данный метод нажимает кнопку подтверждения на модальном окне (ok, accept, confirm, submit и так далее)

        /**
         * Модальное окно (confirm) с текстовым сообщением, кнопкой подтверждения (ok, accept, confirm, submit и так далее) и кнопкой
         * отказа (no, dismiss, abort, отмена и так далее)
         */

        WebElement confirmButton = driver.findElement(By.xpath("(//a[@title='run'])[5]"));
        confirmButton.click();

        alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.dismiss(); // Данный метод нажимает кнопку отмены на модальном окне (no, dismiss, abort, отмена и так далее)
        Thread.sleep(1500);
        alert.accept();

        /**
         * Модальное окно (prompt) с текстовым сообщением, полем для заполнения, кнопкой подтверждения (ok, accept, confirm, submit и так
         * далее) и кнопкой отказа (no, dismiss, abort, отмена и так далее)
         */

        WebElement promptButton = driver.findElement(By.xpath("(//a[@title='run'])[2]"));
        promptButton.click();

        alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.sendKeys("22"); // Данный метод позволяет ввести текст в поле для ввода (в примере этого не будет видно)
        alert.accept(); // Выполнив этот метод, мы увидим, что значение из строки выше успешно было введено в поле для ввода
        Thread.sleep(1500);
        alert.accept();
    }
}
