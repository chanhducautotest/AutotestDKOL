package page_objects.FPTCameraPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import page_objects.FPTPlayPage.ActionFPTPlayPage;

import java.net.MalformedURLException;

import static constants.CommonCamera.*;
import static constants.CommonRegister.*;
import static net.fpt.driver_setting.DriverBase.getDriver;
import static net.fpt.utils.WebElementActionUtil.*;
import static net.fpt.utils.BrowserUtils.*;

public class ActionFPTCameraPage extends ElementsFPTCamera{

    static final Logger logger = LoggerFactory.getLogger(ActionFPTCameraPage.class);
    WebDriverWait wait = new WebDriverWait(driver,3000 );

    public ActionFPTCameraPage goHere() {
        logger.info("goHere");
        try {
            //driver = getDriver();
            //driver.get(urlCamera);
            loadPage(urlCamera,10000);

        } catch (Exception e) {
            logger.error(String.valueOf(e.getCause()));
        }
        //driver.manage().window().maximize();
        return this;
    }

    /** Hàm so sánh url của trang hiện tại với một url mong muốn
     * author: HungNDT2
     * Input: String - str: url mẫu dạng str của regex để so sánh dạng String
     * Output: Trả ra url của trang hiện tại dạng String
     * */
    public Boolean checkCurrentURL(String str) {
        String currentURL = driver.getCurrentUrl();
        return currentURL.matches(str);
    }

    /**
     * Click vào mua ngay ở trên có giá bán
     * */
    public ActionFPTCameraPage clickToBookingWithPrice(){
        logger.info("clickTobookingWithPrice");
        clickEl(wait,button_bookingWithPrice);
        return this;
    }

    /**
     * Click vào mua ngay ở dưới
     * */
    public ActionFPTCameraPage clickToBookingInBottom(){
        logger.info("clickToBooking");
        try {
            WebElement element =wait.until(ExpectedConditions.elementToBeClickable(button_booking.by()));
            Actions actions= new Actions(getDriver());
            actions.moveToElement(button_booking.findWebElement());
            sleepTo(5000);
            clickJS(element);
            sleepTo(5000);
        } catch (MalformedURLException e) {
            logger.error(""+e.getCause());
        }
        return this;
    }

    /**
     * Tab vào tab CameraIQ
     * */
    public ActionFPTCameraPage clickTabCameraIQ(){
        logger.info("clickTabCameraIQ");
        tab_cameraIQ.findWebElement().click();
        return this;
    }

    /**
     * Tab vào tab Trong nhà
     * */
    public ActionFPTCameraPage clickTabInDoor(){
        logger.info("clickTabInDoor");
        tab_indoorCamera.findWebElement().click();
        return this;
    }

    /**
     * Tab vào tab Ngoài trời
     * */
    public ActionFPTCameraPage clickTabOutDoor(){
        logger.info("clickTabOutDoor");
        tab_outdoorCamera.findWebElement().click();
        return this;
    }

    /**
     * Tab vào tab FPT Cloud
     * */
    public ActionFPTCameraPage clickTabFPTCloud(){
        logger.info("clickTabFPTCloud");
        tab_FPTCloud.findWebElement().click();
        return this;
    }

    /**
     * Tăng số lượng camera
     * */
    public ActionFPTCameraPage increaseItem(){
        logger.info("increaseItem");
        wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(button_increase.by())));
        //clickEl(wait,button_increase);
        clickJS(button_increase.findWebElement());
        return this;
    }

    /**
     * Giảm số lượng camera
     * */
    public ActionFPTCameraPage decreaseItem(){
        logger.info("decreaseItem");
        clickEl(wait,button_decrease);
        return this;
    }

    /**
     * Giảm số lượng camera
     * */
    public Integer getQuantityItem(){
        logger.info("getQuantityItem");
        return Integer.parseInt(text_quantity.findWebElement().getText());
    }

    /**
     * Tăng số lượng camera đến số lương muốn mua
     * */
    public ActionFPTCameraPage setNumberItemWantBuy(int numberItems) {
        for (int i=1;i <numberItems;i++){
            increaseItem();
        }
        return this;
    }

    /**
     * kiểm tra đường dẫn url
     * */
    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    /**
     * Mua gói camera trong nhà
     * */
    public void bookingInteriorCamera() {
        clickEl(wait,button_interiorCamera);
        wait.until(ExpectedConditions.elementToBeClickable(button_bookingWithPrice.by()));
        clickEl(wait,button_bookingWithPrice);
    }

    /**
     * Hàm click vòa góc trên màn hinh bỏ qua pop-up quản cáo
     * author: minhlh5
     * */
    public ActionFPTCameraPage skipPopUpAd() throws InterruptedException, MalformedURLException {
        Thread.sleep(6000);
        Actions actionProvider = new Actions(driver);
        // Thực hiện hành động click chuột phải lên butto
        actionProvider.click().build().perform();
        return this;
    }
}
