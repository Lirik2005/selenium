package com.lirik.selenium.tests.base;

import com.lirik.selenium.common.BrowserName;
import com.lirik.selenium.common.DriverFactory;
import com.lirik.selenium.pages.base.BasePage;
import com.lirik.selenium.pages.base.loans.CarLoansPage;
import com.lirik.selenium.pages.base.telecomunications.MobilePhonePaymentPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * Аннотация @Execution(ExecutionMode.CONCURRENT) необходима для запуска тестов в многопоточном режиме. Настройки для запуска тестов в
 * несколько потоков лежат в src/test/resources/junit-platform.properties.
 * Аннотация @ExtendWith(Listener.class) используется для создания скриншотов
 */

@ExtendWith(Listener.class)
@Execution(ExecutionMode.CONCURRENT)
@TestInstance(Lifecycle.PER_CLASS)

public class BaseTest {

    protected WebDriver driver = DriverFactory.getWebDriver(BrowserName.FIREFOX);
    protected BasePage basePage = new BasePage(driver);
    protected CarLoansPage carLoansPage = new CarLoansPage(driver);
    protected MobilePhonePaymentPage mobilePhonePaymentPage = new MobilePhonePaymentPage(driver);

    @AfterEach
    void clearAllCookiesAndLocalStorage() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        driver.manage().deleteAllCookies();
        executor.executeScript("window.sessionStorage.clear()"); // Используется для очистки всех оставшихся после теста данных
    }

    @AfterAll
    void close() {
        driver.close();
    }

}
