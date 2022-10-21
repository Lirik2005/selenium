package com.lirik.selenium.pages.base.telecomunications;

import com.lirik.selenium.pages.base.BasePage;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Getter
@Slf4j
public class MobilePhonePaymentPage extends BasePage {

    public MobilePhonePaymentPage(WebDriver driver) {
        super(driver);
    }

    private final By phoneNumberInput = By.xpath("//input[@data-qa-node='phone-number']");
    private final By amountForPaymentInput = By.xpath("//input[@data-qa-node='amount']");
    private final By walletButton = By.xpath("//div[text()='My wallet']");
    private final By cardForPaymentInput = By.xpath("//input[@data-qa-node='numberdebitSource']");
    private final By validationTermInput = By.xpath("//input[@data-qa-node='expiredebitSource']");
    private final By cvvCodeInput = By.xpath("//input[@data-qa-node='cvvdebitSource']");
    private final By submitAddToCartButton = By.xpath("//button[@data-qa-node='submit']");
    private final By paymentDetails = By.xpath("//div[@data-qa-node='details']");


    public MobilePhonePaymentPage clickMyWalletButton(By walletButtonLocator) {
        try {
            driver.findElement(walletButtonLocator).click();
        } catch (Exception e) {
            log.error("я упал: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return this;
    }

    public MobilePhonePaymentPage enterPhoneNumber(By phoneNumberLocator, String phoneNumber) {
        driver.findElement(phoneNumberLocator).sendKeys(phoneNumber);
        return this;
    }

    public MobilePhonePaymentPage enterAmountForPayment(By amountForPaymentLocator, String amountForPayment) {
        WebElement amountForPaymentElement = driver.findElement(amountForPaymentLocator);
        amountForPaymentElement.clear();
        amountForPaymentElement.sendKeys(amountForPayment);
        return this;
    }

    public MobilePhonePaymentPage enterCardForPayment(By cardForPaymentLocator, String cardNumber) {
        driver.findElement(cardForPaymentLocator).sendKeys(cardNumber);
        return this;
    }

    public MobilePhonePaymentPage enterValidationTerm(By validationTermLocator, String validationTerm) {
        driver.findElement(validationTermLocator).sendKeys(validationTerm);
        return this;
    }

    public MobilePhonePaymentPage enterCvvCode(By cvvCodeLocator, String cvvCode) {
        driver.findElement(cvvCodeLocator).sendKeys(cvvCode);
        return this;
    }

    public MobilePhonePaymentPage clickSubmitAddToCartButton(By submitAddToCartLocator) {
        driver.findElement(submitAddToCartLocator).click();
        return this;
    }

    public MobilePhonePaymentPage checkPaymentDetails (By paymentDetailsLocator) {
        waitElementIsVisible(paymentDetailsLocator).getText();
        return this;
    }
}
