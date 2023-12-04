package com.gitlab.rmarzec.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class W3SchoolsPage extends BasePage {

    protected By cookiesButtonBy = By.cssSelector("div[id='accept-choices']");
    protected By tryItYourselfButtonBy = By.cssSelector("#main > div:nth-child(5) > a");
    protected By headerBy = By.cssSelector("body h1");
    protected By selectsCars = By.name("cars");
    protected By opelCar = By.cssSelector("option[value='opel']");
    protected By iFrame = By.cssSelector("#iframeResult");

    public W3SchoolsPage(String urlAddress, WebDriver driver) {
        super(urlAddress, driver);
    }

    public W3SchoolsPage(WebDriver driver) {
        super(driver);
    }

    public void acceptCookies() {
        driver.findElement(cookiesButtonBy).click();
    }

    public void openTryItYourself() {
        driver.findElement(tryItYourselfButtonBy).click();
    }

    public void printHeader() {
        System.out.println("HEADER: " + driver.findElement(headerBy).getText());
    }

    public void selectOpel() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iFrame));
        driver.findElement(selectsCars).click();
        WebElement opelElement = driver.findElement(opelCar);
        String text = opelElement.getText();
        String value = opelElement.getCssValue("value");
        WebElement selectElement = driver.findElement(selectsCars);
        Select select = new Select(selectElement);
        select.selectByVisibleText("Opel");
        System.out.println("Opel text = " + text + "opel value = " + value);


    }
}

