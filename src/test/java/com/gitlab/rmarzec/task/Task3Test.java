package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.framework.utils.DriverFactory;
import com.gitlab.rmarzec.page.GooglePage;
import com.gitlab.rmarzec.page.W3SchoolsPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Task3Test {

    @Test
    public void Task3Test(){
        DriverFactory driverFactory = new DriverFactory();
        WebDriver webDriver = driverFactory.initDriver();
        GooglePage googlePage = new GooglePage(webDriver);
        googlePage.acceptCookies();
        W3SchoolsPage w3SchoolsPage = googlePage.openW3Schools();
        w3SchoolsPage.acceptCookies();
        w3SchoolsPage.openTryItYourself();
        w3SchoolsPage.printHeader();
        w3SchoolsPage.selectOpel();
        webDriver.quit();
    }
}
