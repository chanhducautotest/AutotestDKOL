package page_objects.FPTPlayPage;

import com.lazerycode.selenium.util.Query;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import static constants.CommonFPTPlay.*;
import static constants.CommonRegister.*;
import static net.fpt.utils.WebElementActionUtil.*;
import static org.assertj.core.api.Assertions.assertThat;

import page_objects.Register.ActionsRegister;
import page_objects.Register.ElementsRegister;

public class ActionFPTPlayPage extends ElementsFPTPlayPage {

    WebDriverWait wait = new WebDriverWait(driver, 15, 2000);
    public ElementsRegister el;

    /**
     * Chọn gói Vip
     * author: HungNDT2
     * */
    public ActionFPTPlayPage chooseVIPPackage() {
        clickEl(wait,button_vipPackage);
        return this;
    }

    /**
     * Chọn gói Max
     * author: HungNDT2
     * */
    public ActionFPTPlayPage chooseMAXPackage() {
        clickEl(wait,button_maxPackage);
        return this;
    }

    /**
     * Lấy giá trị giá gốc
     * author: HungNDT2
     * */
    public String getTextPriceOriginal() {
        return getTextElement(wait,label_priceOriginalPackage);
    }

    /**
     * Lấy giá trị giá giảm
     * author: HungNDT2
     * */
    public String getTextPriceSaleOff() {
        return getTextElement(wait,label_priceSaleOffPackage);
    }

    /**
     * Hàm truy cập trang FPT Play
     * author: HungNDT2
     * */
    public void accessFPTPlayPage() {
        clickEl(wait,headermenu_FPTPlay);
    }

    /** Kiểm tra tồn tại của gói FPT Play VIP
     * author: HungNDT2
     * */
    public Boolean isVipPackageDisplayed() {
        return isElementVisible(wait,button_vipPackage);
    }

    /** Kiểm tra tồn tại của gói FPT Play MAX
     * author: HungNDT2
     * */
    public Boolean isMaxPackageDisplayed() {
        return isElementVisible(wait,button_maxPackage);
    }

    /** Hàm mua gói và kiểm tra webpage chuyển qua trang thanh toán
     * author: HungNDT2
     * */
    public void clickToBuyFPTPlayPackage() {
        clickEl(wait,button_buyPackage);
    }

    /**
     * Kiểm tra tên các option tùy chọn tồn tại
     * author: HungNDT2
     * */
    public Boolean isTitleOptionDisplayed() {
        return isElementVisible(wait,label_usedTime);
    }

    /**
     * Chọn thời gian sử dụng
     * author: HungNDT2
     * */
    public ActionFPTPlayPage clickChooseUsedTime() {
        wait.until(ExpectedConditions.elementToBeClickable(button_optionUsedTime2.by()));
        clickEl(wait,button_optionUsedTime2);
        return this;
    }

    /**
     * Lấy giá trị text thông tin thanh toán trước khi chọn
     * author: HungNDT2
     * */
    public String nameMethod() {
        return getTextElement(wait,label_namePaymentMethods);
    }

    /**
     * Chọn phương thức thanh toán
     * author: HungNDT2
     * */
    public ActionFPTPlayPage choosePaymentMethod() throws InterruptedException {
        clickEl(wait,button_paymentMethods);
        wait.until(ExpectedConditions.visibilityOfElementLocated(button_confirmPaymentMethods.by()));
        chooseList(list_paymentMethods,paymentMethod);
        Thread.sleep(1000);
        clickEl(wait,button_confirmPaymentMethods);
        return this;
    }

    /**
     * Hàm chọn phương thức thanh toán là thẻ ATM - FPT Play
     * author: HungNDT2
     * */
    public void chooseATMPaymentMethod() throws InterruptedException {
        clickEl(wait,button_paymentMethods);
        wait.until(ExpectedConditions.visibilityOfElementLocated(button_confirmPaymentMethods.by()));
        chooseList(list_paymentMethods,atmPaymentMethod);
        Thread.sleep(1000);
        clickEl(wait,button_confirmPaymentMethods);
        wait.until(ExpectedConditions.visibilityOfElementLocated(label_namePaymentMethods.by()));
    }

    /**
     * Hàm kiểm tra nút chuyển hướng điều khoản FPT - FPT Play
     * author: HungNDT2
     * */
    public ActionFPTPlayPage clickBtnFPTRule() throws InterruptedException{
        wait.until(ExpectedConditions.elementToBeClickable(button_aboutFPTRule.by()));
        clickEl(wait,button_aboutFPTRule);
        Thread.sleep(3000);
        return this;
    }

    /**
     * Hàm kiềm tra nút thay đổi địa chỉ lắp đặt
     * author: HungNDT2
     * */
    public ActionFPTPlayPage clickBtnChangeAddress() throws InterruptedException{
        Thread.sleep(6000);
        clickEl(wait,button_changeAddressSetup);
        Thread.sleep(3000);
        return this;
    }

    /**
     * Hàm click vòa góc trên màn hinh bỏ qua pop-up quản cáo
     * author: minhlh5
     * */
    public ActionFPTPlayPage skipPopUpAd() throws InterruptedException, MalformedURLException {
        Thread.sleep(6000);
        Actions actionProvider = new Actions(driver);
        // Thực hiện hành động click chuột phải lên butto
        actionProvider.click().build().perform();
        return this;
    }

}
