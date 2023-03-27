package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.fpt.driver_setting.DriverBase;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import runners.RunCucumberByCompositionTest;

import java.io.IOException;

import static net.fpt.driver_setting.DriverBase.closeDriverObjects;
import static net.fpt.driver_setting.DriverBase.instantiateDriverObject;

public class Hooks {
    static final Logger logger = LoggerFactory.getLogger(Hooks.class);
    @Before
    public void setUp() throws Exception {
        instantiateDriverObject();
    }

    @After
    public void embedScreenshot(Scenario scenario) throws IOException, InterruptedException, NoSuchSessionException {
        byte[] screenshot = ((TakesScreenshot) DriverBase.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "name");
        Thread.sleep(3000);
        try {
            closeDriverObjects();
        }catch (org.openqa.selenium.NoSuchSessionException ex){
            logger.info("[NoSuchSessionException TestNGListenerP onTestSuccess]"+ex);
        }

    }
}
