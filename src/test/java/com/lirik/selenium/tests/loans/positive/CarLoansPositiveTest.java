package com.lirik.selenium.tests.loans.positive;

import com.lirik.selenium.tests.base.BaseTest;
import org.junit.jupiter.api.Test;

import static com.lirik.selenium.constants.ApplicationConstants.CAR_LOAN_URL;

public class CarLoansPositiveTest extends BaseTest {

    @Test
    void selectAgreementsTabInPublicSession() {
        basePage.goToUrl(CAR_LOAN_URL);
        carLoansPage.selectAgreementsTab(carLoansPage.getTabAgreementsButton());
        basePage.isAuthWidgetPresent();
    }
}
