package com.gitlab.rmarzec.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

/*
Klasa odpowiadająca za stronę wikipedii.
Informacja: w aktualnym UI wikipedia lista języków już nie znajduje się w lewym dolnym rogu.
 */
public final class WikiPage extends BasePage {

    protected By languagesButtonBy = By.cssSelector("input[id='p-lang-btn-checkbox']");
    protected By languageBy = By.className("autonym");
    List<WebElement> languagesWebElements;
    public WikiPage(WebDriver driver) {

        super("https://pl.wikipedia.org/wiki/Wiki", driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println(driver.getTitle());
    }

    public void getListOfLanguages() {
        driver.findElement(languagesButtonBy).click();
        languagesWebElements = driver.findElements(languageBy);
        assert languagesWebElements.size() > 10 : "Lack of languages";
    }
    public void printLanguages() {
        String languageValue;
        for(WebElement languageElement: languagesWebElements) {
            languageValue = languageElement.getText();
            if (languageValue.equalsIgnoreCase("English")) {
                System.out.println(languageValue + " " + languageElement.getAttribute("href"));
            } else {
                System.out.println(languageValue);
            }
        }
    }
}
