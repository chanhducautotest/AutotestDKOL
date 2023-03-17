package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.opentestfactory.exception.ParameterException;
import org.opentestfactory.exception.ParameterNotFoundException;
import org.opentestfactory.util.ParameterService;
import org.testng.Assert;
import page_objects.LandingPage.ActionLandingPage;
import page_objects.Menu.ActionsMenu;
import runners.RunCucumberByCompositionTest;

import java.io.IOException;

import static net.fpt.driver_setting.DriverBase.closeDriverObjects;
import static net.fpt.driver_setting.DriverBase.instantiateDriverObject;

public class ToDoStepDefinition extends RunCucumberByCompositionTest {
    public ActionLandingPage landingPage;
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
        landingPage = new ActionLandingPage();
        landingPage.goHere();
    }

    @Then("Verify website correct")
    public void verifyWebsiteCorrect() {
        Assert.assertEquals(landingPage.getTitle(),"Đăng ký Online dịch vụ internet, truyền hình, camera - FPT Telecom");
    }

    @Given("Mở và kết nối với website")
    public void openAndConnectWebsite() {
        landingPage = new ActionLandingPage();
        landingPage.goHere();
    }

    @Then("Xác minh đã truy cập website thành công")
    public void verifyAccessWebsiteCompleted() {
        Assert.assertEquals(landingPage.getTitle(),"Đăng ký Online dịch vụ internet, truyền hình, camera - FPT Telecom");
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
        Assert.assertEquals(landingPage.getTitle(),"FPT Telecom");
    }

    @Given("Truy cập hệ thống DKOL")
    public void accessDKOLSystem() {
        landingPage = new ActionLandingPage();
        landingPage.goHere();
        sleepTo(3000);
        landingPage.maximizeWindow();
        sleepTo(3000);
        landingPage.checkClickBtnX();
    }

    @When("Vào mục internet")
    public void goToInternetSection() throws InterruptedException {
        landingPage.clickLinkFPTInternetHeader();
    }

    @Then("Chọn gói cước: {string}")
    public void chooseInternetPackage(String param) throws  InterruptedException {
        landingPage = new ActionLandingPage();
        param =  ParameterService.INSTANCE.getTestString("DS_ten_goi_cuoc","Sky");
        if(param == null){
            landingPage.clickChooseInternet("Sky");
        }else{
            landingPage.clickChooseInternet(param);
        }
        sleepTo(3000);
    }

    @And("Nhấn Tiếp Tục")
    public void chooseContinue() {
        landingPage = new ActionLandingPage();
        landingPage.clickBtnContinue();
    }

    @Then("Hiện thông báo {string}")
    public void showNotification(String expectedMsg) {
        landingPage = new ActionLandingPage();
        expectedMsg = "Vui lòng nhập họ và tên.";
        Assert.assertTrue(landingPage.verifyMessageDisplayed(expectedMsg), "Thông báo khi chưa nhập họ và tên chưa hợp lệ");
    }

}