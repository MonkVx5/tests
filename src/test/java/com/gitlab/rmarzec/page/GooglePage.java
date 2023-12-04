package com.gitlab.rmarzec.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class GooglePage extends BasePage {
    protected By cookiesButtonBy = By.cssSelector("button[id='L2AGLb']");
    protected By luckyButtonBy = By.cssSelector("div[class*='FPdoLc'] > center > input[class='RNmpXc']");
    protected By textAreaBy = By.cssSelector("textarea[id='APjFqb']");
    public GooglePage(WebDriver driver) {
        super("https://www.google.com", driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void acceptCookies() {
        driver.findElement(cookiesButtonBy).click();
    }

    public W3SchoolsPage openW3Schools() {
        String expectedUrl = "https://www.w3schools.com/tags/tag_select.asp";
        driver.findElement(textAreaBy).sendKeys("HTML select tag - W3Schools");
        driver.findElement(luckyButtonBy).click();
        System.out.println(driver.getTitle());
        W3SchoolsPage w3SchoolsPage;
        if (driver.getCurrentUrl().equalsIgnoreCase(expectedUrl)) {
            w3SchoolsPage = new W3SchoolsPage(driver);
        } else {
            w3SchoolsPage = new W3SchoolsPage(expectedUrl, driver);
        }

        return w3SchoolsPage;
    }
}
