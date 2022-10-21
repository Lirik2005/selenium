package com.lirik.selenium.tests.base;

import io.qameta.allure.Attachment;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

/**
 * Данный класс предназначен для работы со скриншотами.
 */

@Slf4j
public class Listener implements TestWatcher {

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {

        log.info("Test {} failed ", (context.getTestMethod().get().getName()));
        String screenshotName = context.getTestMethod().get().getName() + String.valueOf(System.currentTimeMillis()).substring(9, 13);

        log.info("Try to trace screenshot... ");

        TakesScreenshot screenshot = (TakesScreenshot) ((BaseTest) context.getRequiredTestInstance()).driver;

        File source = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(source, new File("build/allure-results/screenshots/" + screenshotName + ".png"));
        } catch (IOException e) {
            log.info("Exception on saving screenshot: \n {} ", e.getMessage());
            throw new RuntimeException(e);
        }
        attachScreenShotToAllure(screenshot);
    }

    @Attachment
    public byte[] attachScreenShotToAllure(TakesScreenshot takesScreenshot) {
        return takesScreenshot.getScreenshotAs(OutputType.BYTES);
    }
}
