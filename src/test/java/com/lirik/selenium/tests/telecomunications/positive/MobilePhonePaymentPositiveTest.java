package com.lirik.selenium.tests.telecomunications.positive;

import com.lirik.selenium.tests.base.BaseTest;
import org.junit.jupiter.api.Test;

import static com.lirik.selenium.constants.ApplicationConstants.MOBILE_PAYMENT_URL;
import static com.lirik.selenium.constants.CommonConstants.MOBILE_PAYMENT_CARD;
import static com.lirik.selenium.constants.CommonConstants.MOBILE_PAYMENT_CARD_CVV_CODE;
import static com.lirik.selenium.constants.CommonConstants.MOBILE_PAYMENT_CARD_EXPIRE_DATE;
import static com.lirik.selenium.constants.CommonConstants.PHONE_NUMBER;

public class MobilePhonePaymentPositiveTest extends BaseTest {

    @Test
    void successRedirectToAuth() throws InterruptedException {
        basePage.goToUrl(MOBILE_PAYMENT_URL);
        Thread.sleep(5000);
        mobilePhonePaymentPage.clickMyWalletButton(mobilePhonePaymentPage.getWalletButton());
        basePage.isAuthWidgetPresent();
    }

    @Test
    void checkMinAmountForPayment() throws InterruptedException {
        basePage.goToUrl(MOBILE_PAYMENT_URL);
        Thread.sleep(5000);
        mobilePhonePaymentPage.enterPhoneNumber(mobilePhonePaymentPage.getPhoneNumberInput(), PHONE_NUMBER)
                              .enterAmountForPayment(mobilePhonePaymentPage.getAmountForPaymentInput(), "ф")
                              .enterCardForPayment(mobilePhonePaymentPage.getCardForPaymentInput(), MOBILE_PAYMENT_CARD)
                              .enterValidationTerm(mobilePhonePaymentPage.getValidationTermInput(), MOBILE_PAYMENT_CARD_EXPIRE_DATE)
                              .enterCvvCode(mobilePhonePaymentPage.getCvvCodeInput(), MOBILE_PAYMENT_CARD_CVV_CODE)
                              .clickSubmitAddToCartButton(mobilePhonePaymentPage.getSubmitAddToCartButton())
                              .checkPaymentDetails(mobilePhonePaymentPage.getPaymentDetails());
    }
}
