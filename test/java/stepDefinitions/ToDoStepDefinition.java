package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.opentestfactory.exception.ParameterException;
import org.opentestfactory.util.ParameterService;
import org.testng.Assert;
import page_objects.LandingPage.ActionLandingPage;
import page_objects.Menu.ActionsMenu;
import runners.RunCucumberByCompositionTest;

import java.io.IOException;

import static net.fpt.driver_setting.DriverBase.closeDriverObjects;
import static net.fpt.driver_setting.DriverBase.instantiateDriverObject;

public class ToDoStepDefinition extends RunCucumberByCompositionTest {
    public ActionLandingPage langdingPage;
    public ActionsMenu menuPage;

    public static void sleepTo(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Given("Open browser and connect website")
    public void openBrowserAndConnectWebsite() {
        langdingPage = new ActionLandingPage();
        langdingPage.goHere();
    }

    @Then("Verify website correct")
    public void verifyWebsiteCorrect() {
        Assert.assertEquals(langdingPage.getTitle(),"Đăng ký Online dịch vụ internet, truyền hình, camera - FPT Telecom");
    }

    @Given("Mở và kết nối với website")
    public void openAndConnectWebsite() {
        langdingPage = new ActionLandingPage();
        langdingPage.goHere();
    }

    @Then("Xác minh đã truy cập website thành công")
    public void verifyAccessWebsiteCompleted() {
        Assert.assertEquals(langdingPage.getTitle(),"Đăng ký Online dịch vụ internet, truyền hình, camera - FPT Telecom");
    }

    @Then("Fill {string} to search box")
    public void fillParameter_aToSearchBox(final String search) throws ParameterException {
        menuPage = new ActionsMenu();
        System.out.println(">>>>>>>>>>>>"+ search);
        String param = ParameterService.INSTANCE.getString("DS_parameter_a");
        System.out.println(param);
        menuPage.clickIconTimKiem();
        menuPage.senKeyTXTTimKiem(param);
    }

    @Then("Hit Enter")
    public void hitEnter() {
        menuPage.clickIconTimKiem();
    }

    @Then("Xác minh đã truy cập website tùy chọn thành công")
    public void verifyAccessWebsiteCompletedWithURL() {
        verifyAccessWebsiteCompleted();
    }

    @Given("Fail verify website correct")
    public void failVerifyWebsiteCorrect() {
        sleepTo(5000);
        Assert.assertEquals(langdingPage.getTitle(),"FPT Telecom");
    }
}