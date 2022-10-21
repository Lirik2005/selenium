package com.lirik.selenium.pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.lirik.selenium.constants.CommonConstants.EXPLICIT_WAIT_TIME;

public class BasePage {

    protected WebDriver driver;

    public final By authWidget = By.xpath("//iframe[@src='https://login-widget.privat24.ua/']");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToUrl(String url) {
        driver.get(url);
    }

    public WebElement waitElementIsVisible(By element) {
        return new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_TIME)).until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void isAuthWidgetPresent() {
        waitElementIsVisible(authWidget);

    }
}
