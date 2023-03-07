package net.fpt.utils;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static net.fpt.driver_setting.DriverBase.getDriver;
import static net.fpt.utils.WebElementActionUtil.sleepTo;

public class BrowserUtils  {
    /**
     * waitForURL method to wait up to a designated period before
     * throwing exception if URL is not found
     *
     * @param url
     * @param seconds
     * @throws Exception
     */
    public static void waitForURL(String url,
                                  int seconds)
            throws Exception {
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver,
                seconds);
        wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.urlContains(url)));
    }

    /**
     * isPageReady - method to verify that a page has completely rendered
     *
     * @param driver
     * @return boolean
     */
    public static boolean isPageReady(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        return (Boolean)js.executeScript("return document.readyState")
                .equals("complete");
    }


    /**
     * loadPage method to navigate to Target URL
     *
     * @param url
     * @param timeout
     * @throws Exception
     */
    public static void loadPage(String url,
                         int timeout)
            throws Exception {
        WebDriver driver = getDriver();
        driver.navigate().to(url);
        // wait for page download, sync. against endpoint URL
        BrowserUtils.isPageReady(driver);
        BrowserUtils.waitForURL(url, timeout);
    }

    public static String getItemFromLocalStorage(WebDriver driver,String key) {
      JavascriptExecutor js = (JavascriptExecutor)driver;
      return (String) js.executeScript(String.format("return window.localStorage.getItem('%s');", key));
    }

    /**
     * driverWait method pauses the driver in seconds
     *
     * @param seconds to pause
     */
    public static void driverWait(long seconds) {
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(seconds));
        }
        catch (InterruptedException e) {
            // do something
        }
    }

}
