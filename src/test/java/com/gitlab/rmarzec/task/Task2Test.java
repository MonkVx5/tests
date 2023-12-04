package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.framework.utils.DriverFactory;
import com.gitlab.rmarzec.page.WikiPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;



public class Task2Test {
    @Test
    public void Task2Test(){
        DriverFactory driverFactory = new DriverFactory();
        WebDriver webDriver = driverFactory.initDriver();
        WikiPage wikiPage = new WikiPage(webDriver);
        wikiPage.getListOfLanguages();
        wikiPage.printLanguages();
        webDriver.quit();
    }
}
