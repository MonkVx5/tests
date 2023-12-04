package com.gitlab.rmarzec.page;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected String urlAddress;
    protected WebDriver driver;

    public BasePage(String urlAddress, WebDriver driver) {
        this.urlAddress = urlAddress;
        this.driver = driver;
        driver.get(urlAddress);
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
