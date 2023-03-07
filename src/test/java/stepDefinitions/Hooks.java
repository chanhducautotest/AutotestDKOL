package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.fpt.driver_setting.DriverBase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;

import static net.fpt.driver_setting.DriverBase.closeDriverObjects;
import static net.fpt.driver_setting.DriverBase.instantiateDriverObject;

public class Hooks {

    @Before
    public void setUp() throws Exception {
        instantiateDriverObject();
    }

    @After
    public void embedScreenshot(Scenario scenario) throws IOException, InterruptedException {
        byte[] screenshot = ((TakesScreenshot) DriverBase.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "name");
        Thread.sleep(3000);
        closeDriverObjects();
    }
}
