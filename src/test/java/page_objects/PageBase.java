package page_objects;


import net.fpt.driver_setting.DriverBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;


public abstract class PageBase {
    protected static RemoteWebDriver driver;
    static final Logger logger = LoggerFactory.getLogger(PageBase.class);
    public PageBase(){
        logger.info("PageBase");
        try{
            driver = DriverBase.getDriver();
            new WebDriverWait(driver, 3000, 1000);
        }catch (MalformedURLException ignored){

        }
    }

}
