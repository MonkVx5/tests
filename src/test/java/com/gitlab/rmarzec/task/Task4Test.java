package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.framework.utils.DriverFactory;
import com.gitlab.rmarzec.model.YTTile;
import com.gitlab.rmarzec.page.YoutubePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class Task4Test {

    @Test
    public void Task4Test(){
        DriverFactory driverFactory = new DriverFactory();
        WebDriver webDriver = driverFactory.initDriver();
        webDriver.manage().window().fullscreen();
        YoutubePage youtubePage = new YoutubePage(webDriver);
        youtubePage.acceptCookies();
        youtubePage.getVideoWebElements();
        //Lista kafelkow
        List<YTTile> ytTileList = new ArrayList<YTTile>();
        ytTileList = youtubePage.grabYTTileInformations();
        for (YTTile ytTile : ytTileList) {
            if(!ytTile.getLength().equalsIgnoreCase("live")) {
                System.out.println(ytTile.getTitle() + " || " + ytTile.getLength());
            }
        }
        webDriver.quit();
    }
}
