package com.lirik.selenium.pages.base.loans;

import com.lirik.selenium.pages.base.BasePage;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Getter
public class CarLoansPage extends BasePage {

    public CarLoansPage(WebDriver driver) {
        super(driver);
    }

    public final By tabAgreementsButton = By.xpath("//a[@href='/auto-credit/my']/div");

    public CarLoansPage selectAgreementsTab(By element) {
        driver.findElement(element).click();
        return this;
    }
}
