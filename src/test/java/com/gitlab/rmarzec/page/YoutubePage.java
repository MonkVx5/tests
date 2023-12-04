package com.gitlab.rmarzec.page;

import com.gitlab.rmarzec.model.YTTile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class YoutubePage extends BasePage {

    WebDriverWait wait;
    protected By cookiesButtonBy = By.cssSelector("ytd-button-renderer.ytd-consent-bump-v2-lightbox:nth-child(2) > yt-button-shape:nth-child(1) > button:nth-child(1)");
    protected By videoBy = By.cssSelector("ytd-rich-grid-media[class*='ytd-rich-item-renderer']");
    protected By lenghtBy = By.cssSelector("span[class*='ytd-thumbnail-overlay-time-status-renderer']");
    protected By channelBy = By.cssSelector("div[class*='ytd-channel-name']");
    protected By titleBy = By.id("video-title");
    List<WebElement> videoWebElements;
    public YoutubePage(WebDriver driver) {
        super("https://www.youtube.com", driver);
        wait = new WebDriverWait(driver, 60);
    }

    public void acceptCookies() {
        wait.until(ExpectedConditions.elementToBeClickable(cookiesButtonBy));
        driver.findElement(cookiesButtonBy).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(videoBy));
    }

    public List<WebElement> getVideoWebElements() {
        videoWebElements = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(videoBy, 11));
        assert videoWebElements.size() >= 12 : "Lack of videos";
        videoWebElements = videoWebElements.subList(0,12);
        return videoWebElements;
    }

    public List<YTTile> grabYTTileInformations() {
        List<YTTile> ytTileList = new ArrayList<>();
        for(WebElement video: videoWebElements) {
            wait.until(ExpectedConditions.textMatches(lenghtBy, Pattern.compile(".")));
            String title = video.findElement(titleBy).getText();
            String channelName = video.findElement(channelBy).getText();
            String length = video.findElement(lenghtBy).getText();
            if(length.equalsIgnoreCase("")) {
                length = "live";
            }
            YTTile ytTile = new YTTile();
            ytTile.setTitle(title);
            ytTile.setChannel(channelName);
            ytTile.setLength(length);
            ytTileList.add(ytTile);
        }
        return ytTileList;
    }
}
