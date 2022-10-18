package com.lirik.commands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class ThirdRun {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://github.com/Lirik2005");

        /**
         * В строке ниже создается Cookie с моими данными для авторизации на https://github.com
         * Для получения данной Cookie, необходимо авторизоваться на https://github.com в браузере, отличном от того, который запускается
         * WebDriver, и оставаться в системе (т.е. не выходить кнопкой Logout), иначе токен будет недействителен.
         */

        Cookie authCookie = new Cookie("user_session", "z94NgCNuXnoG9Cbb7BXNBYAdgwT7rBphS9HYucZCKYLHviOh");

        driver.manage().addCookie(authCookie); // Данный метод подложит Cookie авторизации на открывшуюся страницу
        driver.navigate().refresh(); // Необходимо сделать refresh(), чтобы подложенная Cookie провела авторизацию

        Set<Cookie> cookies = driver.manage().getCookies(); // Данный метод возвращает все Cookie со страницы и записывает их в Set

        Cookie user_session = driver.manage().getCookieNamed("user_session"); // Данный метод отдает Cookie с указанным названием

        driver.manage().deleteCookieNamed("user_session"); // Данный метод удаляет Cookie с указанным названием

        driver.manage().deleteAllCookies(); // Данный метод удаляет ВСЕ Cookie
    }
}
