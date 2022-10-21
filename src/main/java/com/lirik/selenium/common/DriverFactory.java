package com.lirik.selenium.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;

import static com.lirik.selenium.constants.CommonConstants.DIMENSION_HEIGHT;
import static com.lirik.selenium.constants.CommonConstants.DIMENSION_WIDTH;
import static com.lirik.selenium.constants.CommonConstants.IMPLICIT_WAIT_TIME;
import static java.time.Duration.ofSeconds;

@UtilityClass
public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getWebDriver(BrowserName browserName) {
        switch (browserName) {
            case CHROME -> {
                WebDriverManager.chromiumdriver().setup();

                return Objects.requireNonNullElseGet(driver, ChromeDriver::new);
            }
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().setup();

                return Objects.requireNonNullElseGet(driver, FirefoxDriver::new);
            }
        }
        throw new WebDriverException();
    }

//    public static WebDriver getWebDriver(String browserName) {
//        switch (browserName) {
//            case "firefox": {
//                WebDriverManager.firefoxdriver().setup();
//            return new FirefoxDriver();
//            } default: {
//                WebDriverManager.chromiumdriver().setup();
//                return new ChromeDriver();
//            }
//        }
//    }

    public static void setPropertiesForDriver(WebDriver driver) {
        driver.manage().window().setSize(new Dimension(DIMENSION_WIDTH, DIMENSION_HEIGHT));
        driver.manage().timeouts().implicitlyWait(ofSeconds(IMPLICIT_WAIT_TIME));
    }
}
