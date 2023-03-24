package page_objects.Register;

import com.lazerycode.selenium.util.Query;
import constants.CommonInternet;
import constants.CommonRegister;
import net.fpt.utils.TimeUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static constants.Common.urlHome;
import static constants.CommonInternet.*;
import static constants.CommonInternet.inputStreetMenu;
import static net.fpt.utils.WebElementActionUtil.*;
import static net.fpt.utils.VNCharacterUtils.*;
import static net.fpt.utils.DateUtil.*;

import static constants.CommonFPTPlay.*;
import static constants.CommonRegister.*;
import static constants.CommonCamera.*;
import static constants.Common.*;

public class ActionsRegister extends ElementsRegister {
    static final Logger logger = LoggerFactory.getLogger(ActionsRegister.class);

    /**
     * Nhập giá trị vào trường input
     * Function: Nhập các giá trị dạng string mong muốn vào một trường input
     * author: HungNDT2
     * Input: - locator của trường input cần nhập giá trị
     * - Chuỗi giá trị nhập
     * Output: trả về giá trị chính nó
     */
    public ActionsRegister enterText(Query q, String fullname) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(q.by()));
        q.findWebElement().sendKeys(fullname);
        return this;
    }

    /**
     * Hàm điền thông tin vào trường input ở thông tin đăng ký và nhấn tiếp tục
     * author: HungNDT2
     */
    public void inputPrivateInfo() throws MalformedURLException {
        // Chọn giới tính và tên đường từ dropdown
        checkChooseDroplist(listItem_gender, dropdown_gender, inputGender);
        //checkChooseDroplist(listItem_street, dropdown_street, inputStreet1);

        // Điền các trường input text
        Query[] locator = {text_name, text_phone, text_birthday, text_idNumber, text_email};
        String[] text = {inputName, inputPhone, inputBirthday, inputIdNumber, inputEmail};
        for (int i = 0; i <= (locator.length - 1); i++) {
            clearInput(locator[i]);
            enterText(locator[i], text[i]);
        }

        checkChooseDroplist(listItem_gender, dropdown_gender, inputGender);
        checkChooseDroplist(listItem_province, dropdown_province, inputCity);
        checkChooseDroplist(listItem_district, dropdown_district, inputDistrict);
        checkChooseDroplist(listItem_ward, dropdown_ward, inputWard);
        checkChooseDroplist(listItem_street, dropdown_street, inputStreet1);
        enterText(text_address,inputAddress);

        // Nhấn xác nhận và kiềm tra webpage chuyển trang
        clickEl(wait, button_continue);

        checkCurrentURL(urlChooseService);
    }

    /**
     * Hàm lấy thông tin của các trường input đã điền
     * author: HungNDT2
     */
    public List listInfoRegistrationInputten() {
        Query[] locator = {text_name, text_phone, text_birthday, text_idNumber, text_email, text_address};
        List<String> listtext = new ArrayList<>();
        for (int i = 0; i < locator.length; i++) {
            listtext.add(locator[i].findWebElement().getAttribute("value"));
        }
        return listtext;
    }

    /**
     * Hàm tạo danh sách thông tin đăng ký mẫu
     * author: HungNDT2
     */
    public List listInfoRegistrationPattern() {
        String[] text = {inputName, inputPhone, inputBirthday, inputIdNumber, inputEmail, inputAddress};
        List<String> listpattern = new ArrayList<>();
        for (int i = 0; i < text.length; i++) {
            listpattern.add(text[i]);
        }
        return listpattern;
    }

    /**
     * Hàm kiểm tra thông tin sai định dạng
     * author: HungNDT2
     */
    public void enterWrongFormat() {
        Query[] locator = {text_phone, text_idNumber, text_email};
        for (int i = 0; i <= (locator.length - 1); i++) {
            clearInput(locator[i]);
            enterText(locator[i], textErrorFormat);
        }
    }

    /**
     * Hàm click nút tiếp tục trong quá trình thanh toán
     * author: HungNDT2
     */
    public ActionsRegister clickOnContinueButton() {
        waitAndClickToElement(button_continue, wait);
        return this;
    }

    /**
     * Hàm getText Thong Tin Loi khi không nhập thông tin đăng ký
     * author: HungNDT2
     * Output: trả về giá trị
     */
    public List getErrorText() {
        return getTextListItems(label_messageError);
    }

    /**
     * Hàm xóa thông tin trong các trường nhập
     * author: HungNDT2
     * Input: - locator của element cần xóa text
     */
    public ActionsRegister clearInput(Query input) {
        WebElement sendkeyName = wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(input.by())));
        sendkeyName.clear();
        return this;
    }

    /**
     * Hàm kiểm tra các đề mục header của trang thông tin đăng ký
     * Function: tạo một mảng gồm các locator của header cần duyệt sự tồn tại, hàm sẽ giúp xác minh điều đó
     * author: HungNDT2
     * Input: header (mảng dạng query) cung cấp cho hàm 1 mảng trong đó gồm các locator phần tử query
     * Output: trả về kết quả của assertion
     */
    public Boolean checkHeaderRegistrationInfoPage() {
        int count = 0;
        Query[] header = {label_registerInformation, label_service, label_paymentInformation, label_completeRegister, label_informationPersonal, label_adressSetUp_label};
        for (int i = 0; i <= (header.length - 1); i++) {
            if (isElementVisible(wait, header[i]) == true) {
                count++;
            }
        }
        if (count != header.length) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Kiểm tra tiêu đề của các trường điền thông tin
     * author: HungNDT2
     */
    public List listLabelInputField() {
        Query[] label = {label_userName, label_phone, label_birthday, label_idNumber, label_gender, label_email};
        return listTitleRegistrationInfo(wait, label);
    }

    /**
     * Kiểm tra thông báo lỗi
     * author: HungNDT2
     */
    public List listLabelErrorInput() {
        Query[] error = {label_ErrorNoticeNameEl, label_ErrorNoticePhoneEl, label_ErrorNoticeBirthdayEl, label_ErrorNoticeIdEl, label_ErrorNoticeAddressEl};
        Query[] inputFiled = {text_name, text_phone, text_birthday, text_idNumber, text_address};
        for (int i = 0; i < inputFiled.length; i++) {
            clearInput(inputFiled[i]);
        }
        sleepTo(3000);
        clickEl(wait, button_continue);
        return listTitleRegistrationInfo(wait, error);
    }

    /**
     * Kiểm tra lỗi sai định dạng
     * author: HungNDT2
     */
    public List listErrorFormatNotice() {
        Query[] locator = {label_ErrorNoticePhoneEl, label_ErrorNoticeIdEl, label_ErrorNoticeMailEl};
        clickEl(wait, button_continue);
        return listTitleRegistrationInfo(wait, locator);
    }

    /**
     * FPTPlay chọn dịch vụ - thay đổi gói cước
     * author: HungNDT2
     */
    public ActionsRegister clickChange() {
        clickEl(wait, button_modifyPackage);
        return this;
    }

    /**
     * FPTPlay chọn dịch vụ - Xác nhận popup dành cho thay đổi gói cước tồn tại
     * author: HungNDT2
     */
    public Boolean isPopupChangePackageExistance() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(button_confirmChangePackage.by()));
        return isElementVisible(wait, button_confirmChangePackage);
    }

    /**
     * FPTPlay chọn dịch vụ - xác nhận thay đổi gói cước
     * author: HungNDT2
     */
    public ActionsRegister clickConfirmChange() {
        clickEl(wait, button_confirmChangePackage);
        return this;
    }

    /**
     * Hàm nhấn nút tiếp tục
     * author: HungNDT2
     */
    public ActionsRegister clickConfirm() {
        WebElement confirm = wait.until(ExpectedConditions.elementToBeClickable(button_continue.by()));
        confirm.click();
        return this;
    }

    /**
     * FPT Play thông tin thanh toán - click xác nhận thanh toán gói cước
     * author: HungNDT2
     */
    public ActionsRegister clickPayment() {
        clickEl(wait, button_payment);
        return this;
    }

    /**
     * Hàm lấy tên gói cước từ url
     * Function: hàm sẽ lấy 1 số kí tự theo yêu cầu từ 1 chuỗi url lấy được (chuỗi đưa vào phải thuộc dạng regex)
     * author: HungNDT2
     * Input: Regex của chuỗi cần duyệt
     * Output: trả về chuỗi cần lấy và xóa đi các ký tự đặc biệt trong chuỗi
     */
    public String getPackageNameFromURL(String str) {
        String result = "";
        String currentURL = driver.getCurrentUrl();
        Pattern pattern = Pattern.compile(str);
        Matcher matcher = pattern.matcher(currentURL);
        while (matcher.find()) {
            result = matcher.group(1).replace("-", "").toUpperCase();
        }
        return result;
    }

    /**
     * Hàm lấy tên gói cước từ url - FPT Play
     * author: HungNDT2
     */
    public String getPackageNameFPTPlay() {
        return getPackageNameFromURL(getNamePackage);
    }

    /**
     * Hàm lấy tên gói cước từ url - FPT Camera
     * author: HungNDT2
     */
    public String getPackageNameFPTCamera() {
        return getPackageNameFromURL(regexPackageNameFromURL);
    }

    /**
     * Hàm lấy tên gói cước từ Title
     * Function: hàm sẽ lấy text của element được chỉ định, sau đó cắt phần cần lấy từ regex
     * author: HungNDT2
     * Output: trả về chuỗi cần tìm và xóa đi khoảng trắng cũng như ký tự đặc biệt trong chuỗi
     */
    public String getPackageNameFromTitle(Query locator, String regex) {
        String result = "";
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator.by()));
        String title = getTextElement(wait, locator);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(title);
        while (matcher.find()) {
            result = matcher.group(1).replace("-", "").replace(" ", "").toUpperCase();
        }
        return removeAccent(result);
    }

    /**
     * Hàm lấy tên gói cước từ Title - FPT Play
     * author: HungNDT2
     */
    public String getPackageTitleFPTPlay() {
        return getPackageNameFromTitle(label_namePackageChooseService, getNameTitle);
    }

    /**
     * Hàm lấy tên gói cước từ Title - FPT Camera
     * author: HungNDT2
     */
    public String getPackageTitleFPTCamera() {
        return getPackageNameFromTitle(label_cameraPackageName, regexPackageNameFromTitle);
    }

    /**
     * Lấy giá trị text thông tin tên và sdt - fpt play
     * author: HungNDT2
     */
    public String getTextNamePhone() {
        return getTextElement(wait, label_namePhone);
    }

    /**
     * Lấy giá trị text thông tin tên và sdt - fpt play
     * author: HungNDT2
     */
    public String getTextAddress() {
        return getTextElement(wait, label_address);
    }

    /**
     * Lấy giá trị text giá tiền trong chi tiết đơn hàng - FPT Play
     * author: HungNDT2
     */
    public String getTextTotalPriceOnOrderDetail() {
        return getTextElement(wait, label_priceTotalFPTPlay);
    }

    /**
     * Lấy giá trị text giá tiền trên nút thanh toán - FPT Play
     * author: HungNDT2
     */
    public String getTextTotalPriceOnBtn() {
        return getTextElement(wait, button_priceTotalFPTPlay);
    }

    /**
     * Lấy giá trị trạng thái thanh toán
     * author: HungNDT2
     */
    public String getTextStatusPayment() {
        return getTextElement(wait, label_statusPayment);
    }

    /**
     * Tạo chuỗi địa chỉ nhà tại trang thông tin đăng ký
     * author: HungNDT2
     */
    public String getAddressString(String address, String street, String ward, String district, String city) {
        return address + " " + street + ", " + ward + ", " + district + ", " + city;
    }

    /**
     * Tạo chuỗi tên - sdt tại trang thông tin đăng ký
     * author: HungNDT2
     */
    public String getNamePhoneString(String name, String phone) {
        return name + " - " + phone;
    }

    /**
     * Tạo chuỗi thời gian lắp đặt tại trang thông tin đăng ký
     * author: HungNDT2
     */
    public String getTimeString(String hour, String date) {
        return "Thời gian lắp đặt: " + hour + " " + date;
    }

//    /**
//     * Kiềm trả thuộc tính của đối tượng
//     * author: HungNDT2
//     * */
//    public Boolean isAttributePresent(Query q, String str) {
//        try {
//            if ((q.getAttribute)) {
//                return true;
//            }
//        } catch (Exception e) {}
//        return false;
//    }

    /**
     * Hàm lấy mã đơn hàng tại xem chi tiết đơn hàng
     * author: HungNDT2
     */
    public String getGoodsCodeInOrderDetail() throws InterruptedException {
        clickEl(wait, label_orderDetail);
        Thread.sleep(5000);
        return getStringFromOtherString(getGoodsCode, getTextElement(wait, label_goodsCodeInOrderDetail));
    }

    /**
     * Hàm lấy mã đơn hàng tại trang finish
     * author: HungNDT2
     */
    public String getGoodsCodeTextInFinishPage() {
        return getTextElement(wait, label_orderCode);
    }

    /**
     * Kiểm tra tiêu đề của các trường điền thông tin đăng ký - camera
     * author: HungNDT2
     */
    public List listLabelInputFieldCamera() {
        Query[] label = {label_userName_camera, label_phone_camera, label_birthday_camera, label_idNumber_camera, label_email_camera};
        return listTitleRegistrationInfo(wait, label);
    }

    /**
     * Nhập giá trị text vào trường họ tên - camera
     * author: HungNDT2
     */
    public ActionsRegister inputTextName(String str) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(text_name_camera.by()));
        clearInput(text_name_camera);
        enterText(text_name_camera, str);
        return this;
    }

    /**
     * Kiểm tra giá trị điền của trường họ tên - camera
     * author: HungNDT2
     */
    public String getTextNameInput() {
        return text_name_camera.findWebElement().getAttribute("value");
    }

    /**
     * Click nút xóa trường họ tên - camera
     * author: HungNDT2
     */
    public ActionsRegister clickBtnX() {
        Actions actionProvider = null;
        try {
            actionProvider = new Actions(getDriver());
            actionProvider.moveToElement(text_name_camera.findWebElement());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        clickEl(wait, button_iconX_camera);
        return this;
    }

    /**
     * Kiểm tra định dạng khi nhập sai format - camera
     * author: HungNDT2
     *
     * @return
     */
    public List listFormatPhoneIdMail() throws InterruptedException {
        Query[] locator = {text_phone_camera, text_id_camera, text_email_camera};
        Query[] formatLocator = {label_wrongFormatPhone_camera, label_wrongFormatId_camera, label_wrongFormatMail_camera};
        for (int i = 0; i < locator.length; i++) {
            Thread.sleep(2000);
            wait.until(ExpectedConditions.elementToBeClickable(locator[i].by())).click();
            clearInput(locator[i]);
            enterText(locator[i], inputWrongFormat);
        }
        clickConfirm();
        return listTitleRegistrationInfo(wait, formatLocator);
    }

    public List<String> listWrongForamt() {
        List<String> listLabel = new ArrayList<>();
        listLabel.add(wrongFormatPhone);
        listLabel.add(wrongFormatId);
        listLabel.add(wrongFormatMail);
        return listLabel;
    }

    /**
     * Nhập text vào trường CMND/CCCD - camera
     * author: Hung
     */
    public ActionsRegister inputTextId() throws InterruptedException {
        clearInput(text_idNumber);
        enterText(text_idNumber, inputIdNumber);
        Thread.sleep(2000);
        return this;
    }

    /**
     * Kiểm tra giá trị nhập vào ô CMND/CCCD - camera
     * author: HungNDT2
     */
    public String getInputId() {
        return text_idNumber.findWebElement().getAttribute("value");
    }

    /**
     * Nhập giá trị mail - camera
     * author: HungNDT2
     */
    public ActionsRegister inputTextMail() throws InterruptedException {
        clearInput(text_email);
        enterText(text_email, inputEmail);
        Thread.sleep(2000);
        return this;
    }

    /**
     * Kiểm tra giá trị nhập vào ô mail - camera
     * author: HungNDT2
     */
    public String getInputMail() {
        return text_email.findWebElement().getAttribute("value");
    }

    /**
     * Hàm điền các thông tin đăng ký - camera
     * author: HungNDT2
     */
    public void inputInfoRegistCamera() {
        Query[] locator = {text_name, text_phone, text_birthday, text_idNumber, text_email, text_address_xpath_camera};
        String[] text = {inputName, inputPhone, inputBirthday, inputIdNumber, inputEmail, inputAddressCamera};
        for (int i = 0; i < locator.length; i++) {
            clearInput(locator[i]);
            enterText(locator[i], text[i]);
        }
        checkChooseDroplist(listItem_street, dropdown_district_camera, inputDistrictCamera);
        checkChooseDroplist(listItem_street, dropdown_ward_camera, inputWardCamera);
        checkChooseDroplist(listItem_street, dropdown_street_camera, inputStreetCamera);

        clickConfirm();
    }

    /**
     * Kiểm tra số lượng camera
     * author: HungNDT2
     */
    public String getCameraQuantity() {
        return getTextElement(wait, label_quantityPackageCamera);
    }

    /**
     * Chọn thời gian sử dụng
     * author: HungNDT2
     */
    public ActionsRegister chooseUseTime7Months() {
        wait.until(ExpectedConditions.elementToBeClickable(button_usedTime7Months.by()));
        clickEl(wait, button_usedTime7Months);
        return this;
    }

    /**
     * Mở lịch - camera
     * author: HungNDT2
     */
    public ActionsRegister openCalender() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(text_dateSetupCamera.by()));
        clickEl(wait, text_dateSetupCamera);
        return this;
    }

    /**
     * Chọn thời gian lắp đặt từ lịch - camera
     * author: HungNDT2
     */
    public void pickDateSetupCameraFromCalender()  {
        clickEl(wait, text_dateSetupCamera);
        WebElement dateWidget = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("b-calendar-grid-body"))).get(0);
        List<WebElement> date = dateWidget.findElements(By.xpath("//div[@role='button']"));
        clickGivenDay(date, getCurrentDayPlus(2));
        sleepTo(3000);
    }

    /**
     * Kiểm tra thông báo lỗi khi không chọn gói cloud kèm theo camera
     * author: HungNDT2
     */
    public String getNoticeNotChooseCloudPackage() {
        return label_cloudErrorMessage.findWebElement().getAttribute("class");
    }

    /**
     * Chọn 5 gói cloud cho camera
     * author: HungNDT2
     */
    public ActionsRegister chooseCloudPackage() {
        for (int i = 0; i < 5; i++) {
            clickEl(wait, button_increaseCloudPackage1Day);
        }
        return this;
    }

    /**
     * Lấy số lượng gói cloud camera
     * author: HungNDT2
     */
    public Integer getQuantityCloudPackage() {
        return Integer.valueOf(getTextElement(wait, text_quantityCloudPackage1Day));
    }

    /**
     * Chọn 1 gói cloud
     * author: HungNDT2
     */
    public Boolean chooseOnePackageCloud() {
        clickEl(wait, button_increaseCloudPackage1Day);
        return getTextElement(wait, text_quantityCloudPackage1Day).equals("1");
    }

    /**
     * Lấy giá trị Text của thông tin tên và sdt
     * author: HungNDT2
     */
    public String getNamePhone() {
        return getTextElement(wait, label_namePhoneCamera);
    }

    /**
     * Lấy giá trị Text của thông tin tên và sdt
     * author: HungNDT2
     */
    public String getAddress() {
        return getTextElement(wait, label_addressCamera);
    }

    /**
     * Lấy giá trị ngày lắp đặt camera
     * author: HungNDT2
     */
    public String getTextDateSetupCamera() {
        return text_dateSetupCamera.findWebElement().getAttribute("value");
    }

    /**
     * Lấy giá trị giờ lắp đặt camera
     * author: HungNDT2
     */
    public String getTextHourSetupCamera() {
        return getTextElement(wait, text_hourSetupCamera);
    }

    /**
     * Kiểm tra thời gian lắp đặt - camera
     * author: HungNDT2
     */
    public String getTextTimeSetup() {
        return getTextElement(wait, label_timeSetupCamera);
    }

    /**
     * Kiềm tra nút chuyển đổi vị trí lắp đặt - camera
     * author: HungNDT2
     */
    public ActionsRegister modifyLocationCamera() throws InterruptedException {
        clickEl(wait, button_modifyLocation_Camera);
        Thread.sleep(3000);
        return this;
    }

    /**
     * Kiểm tra nút thay đổi thời gian lắp đặt - camera
     * author: HungNDT2
     */
    public ActionsRegister modifyTimeSetupCamera() throws InterruptedException {
        clickEl(wait, button_modifyTimeSetup_Camera);
        Thread.sleep(3000);
        return this;
    }

    /**
     * Kiểm tra các phương thức thanh toán
     * author: HungNDT2
     */
    public List getListPaymentMethodCamera() {
        clickEl(wait, button_choosePaymentMethod);
        return getTextListItems(label_paymentMethods_Camera);
    }

    /**
     * Nhập voucher - camera
     * author: HungNDT2
     */
    public ActionsRegister inputVoucher() {
        clickEl(wait, button_chooseVoucher);
        wait.until(ExpectedConditions.visibilityOfElementLocated(text_inputVoucher_Camera.by()));
        enterText(text_inputVoucher_Camera, inputVoucherCamera);
        clickEl(wait, button_applyVoucher_Camera);
        sleepTo(2000);
        // Nhấn đồng ý khi popup thông báo apply mã GTBB thành công
        clickEl(wait, button_confirmPaymentMethod);
        return this;
    }

    /**
     * Nhập mã GTBB để lấy giảm giá
     * author: HungNDT2
     */
    public String getCodeVoucher() {
        return getTextElement(wait, label_voucherName);
    }

    /**
     * Chọn thanh toán bằng thẻ giao dịch quốc tế
     * author: HungNDT2
     */
    public ActionsRegister chooseMethodForPayment(Query methodLocator) throws InterruptedException {
        Query[] locator = {button_choosePaymentMethod, methodLocator, button_confirmPaymentMethod};
        for (int i = 0; i < locator.length; i++) {
            Thread.sleep(2000);
            clickEl(wait, locator[i]);
        }
        return this;
    }

    /**
     * Điền thông tin thẻ thanh toán
     * author: HungNDT2
     */
    public ActionsRegister inputATMCardInfo(String id, String name, String date) throws InterruptedException {
        Query[] locator = {text_numberCard, text_fullnameCard, text_dateCard};
        String[] text = {id, name, date};
        for (int i = 0; i < locator.length; i++) {
            clearInput(locator[i]);
            enterText(locator[i], text[i]);
            Thread.sleep(1000);
        }
        return this;
    }

    /**
     * Click tiếp tục khi điền thông tin thẻ thanh toán xong
     * author: HungNDT2
     */
    public ActionsRegister clickConfirmCardInfo() {
        clickEl(wait, button_continueCard);
        return this;
    }

    /**
     * Click tiếp tục khi điền OTP
     * author: HungNDT2
     */
    public ActionsRegister clickConfirmOTP() {
        clickEl(wait, button_continueOTP);
        return this;
    }

    /**
     * Lấy giá trị text của thông báo lỗi
     * author: HungNDT2
     */
    public String getTextAlarmWrongOTP() {
        return getTextElement(wait, text_alarmWrongOTP);
    }

    /**
     * Lấy giá trị text thông báo thanh toán thất bại
     * author: HungNDT2
     */
    public String getTextAlarmFailPayment() {
        return getTextElement(wait, text_alarmFailPayment);
    }

    /**
     * Close popup nhập mã thành công
     */
    public ActionsRegister closePopupSaleOffCode() {
        clickEl(wait, button_confirmPaymentMethod);
        return this;
    }

    /**
     * Kiểm tra điều khoản FPT
     */
    public Boolean isBtnFPTRuleWorked() throws InterruptedException, MalformedURLException {
        clickEl(wait, button_aboutFPTRule_Camera);
        Thread.sleep(3000);
        return checkCurrentURL(urlAboutFPTRule);
    }

    /**
     * Chọn location Phường/Xã lắp đặt để vào trang home
     * Input: String - tên đường dạng chuỗi
     */
    public ActionsRegister chooseWardInstall(String input) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement dropdownTT = wait.until(ExpectedConditions.elementToBeClickable(dropdown_ward.by()));
        dropdownTT.click();
        chooseList(listItem_ward, input);
        return this;
    }

    /**
     * Chọn location Phường/Xã lắp đặt để vào trang home
     * Input String - tên phường/xã dạng chuỗi
     */
    public ActionsRegister chooseStreet(String input) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement dropdownTT = wait.until(ExpectedConditions.elementToBeClickable(dropdown_street.by()));
        dropdownTT.click();
        chooseList(listItem_street, input);
        return this;
    }

    /**
     * Chờ đến khi hết loading
     * Input: String - link của trang đang mong chờ
     */
    public ActionsRegister waitGoToURL(String url) {
        wait.until(ExpectedConditions.urlToBe(url));
        wait.until(waitForLoadingCSSStype(loading.findWebElement(), "display: none;"));
        return this;
    }

    /**
     * Hàm chọn giới tính
     * Input: String - Cung cấp cho hàm giá trị mong muốn được chọn dạng chuỗi
     * Query - 2 query: locator của dropdown và danh sách các option trong đó
     * Output: Boolean - Hàm dùng param so sánh với các kết quả thu được, nếu chọn thành công trả về true và ngược lại
     */
    public ActionsRegister checkChooseDroplist(Query listitem, Query dropdownLocation, String input) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(dropdownLocation.by()));
        Actions actionProvider = new Actions(driver);
        actionProvider.moveToElement(element).click().build().perform();
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(listitem.by(), 0));
        chooseList(listitem, input);
//        Boolean status = null;
//        try {
//            if (element.getText().equals(input)) {
//                status = true;
//            } else status = false;
//        } catch (Exception e) {
//            logger.error(" " + e.getCause());
//        }
        return this;
    }

    /**
     * Author:HaoBH
     * Chờ tới khi element có text mong muốn
     */
    public ActionsRegister waitForDropdownLoad(Query element, String text) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(element.by(), text));
        return this;
    }

    /**
     * Author: HaoBH
     * Function: chọn 1 giá trị trong list của 1 dropdown, dùng chung cho dropdown Tỉnh thành, Quận Huyện, Phường Xã, Đường Phố
     *
     * @param dropdown dropdown cần click chọn giá trị
     * @param list     list giá trị tương ứng với dropdown
     * @param option   giá trị muốn chọn trong list
     */
    public ActionsRegister chooseValueInDropdown(Query dropdown, Query list, String option) throws InterruptedException {
        Thread.sleep(3000);
        dropdown.findWebElement().click();
        wait.until(ExpectedConditions.presenceOfElementLocated(list.by()));
        chooseList(list, option);
        return this;
    }

    /**
     * Author: HaoBH
     * Nhập vào searchBox của dropdown từ khóa có - không dấu -> check xem có match với từ khóa không
     *
     * @return boolean
     */
    public boolean checkSearchBoxDropdown(Query dropdown, Query searchBox, Query listItem, List<String> input) throws InterruptedException {
        Thread.sleep(3000);
        String resultInList = "";
        dropdown.findWebElement().click();
        int count = 0;
        for (int i = 0; i < input.size(); i++) {
            searchBox.findWebElement().sendKeys(input.get(i));
            wait.until(ExpectedConditions.presenceOfElementLocated(listItem.by()));
            resultInList = (String) getTextListItems(listItem).get(0);
            if (resultInList.equalsIgnoreCase(input.get(0))) {
                count++;
                searchBox.findWebElement().clear();
            } else searchBox.findWebElement().clear();
        }
        chooseList(listItem, resultInList);
        if (count == input.size())
            return true;
        return false;
    }

    /**
     * Kiểm tra hiển thị logo
     * author: DienLT2
     */
    public Boolean verifyDisplayLogoFPT() {
        List<WebElement> elementImg = new ArrayList<>(element_imgLogo.findWebElements());
        Boolean imageLoaded1 = null;
        for (WebElement i : elementImg) {
            imageLoaded1 = isLoadingImage(i);
        }
        return imageLoaded1;
    }

    /**
     * Nhập thông tin trên màn hình đăng ký
     * author: DienLT2
     */
    public void inputInformationRegister() {
        logger.debug("inputInformationRegister");
        sleepTo(1000);
        Query[] locator = {text_name, text_phone, text_birthday, text_idNumber, text_email, text_address};
        String[] text = {inputName, inputPhone, inputBirthday, inputIdNumber, inputEmail, inputAddress};
        for (int i = 0; i <= (locator.length - 1); i++) {
            sleepTo(1000);
            clearInput(locator[i]);
            sleepTo(1000);
            enterText(locator[i], text[i]);
        }
        checkChooseDroplist(listItem_gender, dropdown_gender, inputGender);
        checkChooseDroplist(listItem_province, dropdown_province, inputCity);
        checkChooseDroplist(listItem_district, dropdown_district, inputDistrict);
        checkChooseDroplist(listItem_ward, dropdown_ward, inputWard);
        checkChooseDroplist(listItem_street, dropdown_street, inputStreet1);
        /*Actions actionProvider = new Actions(driver);
        actionProvider.moveToElement(button_continue.findWebElement()).build().perform();*/
        clickEl(wait, button_continue);
    }

    /**
     * Nhập số điện thoại vào test field
     * author: DienLT2
     */
    public ActionsRegister enterPhone(String phone) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(text_phone.by()));
        text_phone.findWebElement().sendKeys(phone);
        return this;
    }

    /**
     * Nhập số họ tên vào test field
     * author: DienLT2
     */
    public ActionsRegister enterName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(text_name.by()));
        text_name.findWebElement().sendKeys(name);
        return this;
    }

//    /**
//     * Click button xác nhận
//     * author: DienLT2
//     */
//    public ActionsRegister clickButtonConfirmNoti() {
//        WebElement buttonConfirm = wait.until(ExpectedConditions.elementToBeClickable(button_agree.by()));
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        buttonConfirm.click();
//        return this;
//    }
//
//    /**
//     * Check popup được hiển thị không
//     * author: DienLT2
//     */
//    public boolean checkIsDisplayPopupNoti() {
//        return checkElementDisplayed(wait, button_agree);
//    }
//
//    /**
//     * Tắt thông báo popup
//     * author: DienLT2
//     *
//     * @return
//     */
//    public Boolean skipToPopupNotification() {
//        logger.info("skipToPopupNotification");
//        if (checkIsDisplayPopupNoti()) {
//            ActionsRegister register = new ActionsRegister();
//            register.clickButtonConfirmNoti();
//        }
//        return true;
//    }

    /**
     * Kiểm tra thông tin trên màn hình lắp đặt
     * author: DienLT2
     */
    public List getListInfoSetUp() {
        Query[] element = {label_adressSetUp_label, label_home, label_tower, label_adress};
        return listTitleRegistrationInfo(wait, element);
    }

    /**
     * Click vào button Fsafe
     * * author: DienLT2
     */
    public ActionsRegister clickInfoFsafe() {
        wait.until(ExpectedConditions.elementToBeClickable(button_infoFsafe.by()));
        button_infoFsafe.findWebElement().click();
        return this;
    }

    /**
     * Click vào button close trên màn hình Fsafe
     * author: DienLT2
     */
    public ActionsRegister clickCloseInfoFsafe() {
        button_closePopUpInfoFsafe.findWebElement().click();
        return this;
    }

    /**
     * Get thông tin ngày được cài đặt
     * author: DienLT2
     */
    public String getDateSetupTime() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(date_SetupTime.by()));
        return element.getAttribute("value");
    }

    /**
     * Get thông tin trên màn hình thông tin thanh toán
     * author: DienLT2
     */
    public List verifyInformationPayment() {
        Query[] element = {label_infoCompleteRegister, label_choosePayment, label_detailOrder, label_rules01, label_rules02};
        return listTitleRegistrationInfo(wait, element);
    }

    /**
     * kiếm tra button thành toán được hiển thị
     * author: DienLT2
     */
    public Boolean checkDisplayInfoPayment() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(button_payment.by()));
        if (element.isDisplayed()) {
            return true;
        } else return false;
    }

    /**
     * Get thông tin trên chi tiết đơn hàng
     * author: DienLT2
     */
    public List verifyListDetailOrder() {
        Query[] element = {label_namePackage, label_feeInternet, label_modemInternet, label_modemAccess};
        return listTitleRegistrationInfo(wait, element);
    }

    /**
     * Get thông tin trên chi tiết đơn hàng
     * author: DienLT2
     */
    public List verifyInformationChooseService() {
        Query[] element = {label_namePackage, label_feeInternet, label_modemInternet, label_modemAccess};
        return listTitleRegistrationInfo(wait, element);
    }

    /**
     * Kiểm tra hiển thị mục Thông tin dịch vụ ở màn hình Chọn dịch vụ
     * author: DienLT2
     **/
    public List verifyChooseService() {
        Query[] element = {label_describeData, label_chooseNamePackage, button_chooseChange, lable_nameData, label_locationProvince, lable_priceData, label_SetupTime, button_continue};
        return listTitleRegistrationInfo(wait, element);
    }

    /**
     * Kiểm tra mục hoàn tất đăng ký ở màn hình Thông tin thanh toán
     * author: DienLT2
     **/
    public List verifyCompleteRegister() {
        Query[] element = {label_registerNamePhone, label_registerAddress, label_registerTimeSetup, label_registerNamePackage, button_registerChangeAddress, button_registerChangeTime};
        return listTitleRegistrationInfo(wait, element);
    }

    /**
     * Click vào button thay đổi địa chỉ lắp đặt
     * author: DienLT2
     */
    public void checkClickLinkChangeAddressSetUp() {
        clickEl(wait, button_changeAddressSetUp);
    }

    /**
     * Click vào button thay đổi thời gian lắp đặt
     * author: DienLT2
     */
    public void checkClickLinkChangeTimeSetUp() {
        clickEl(wait, button_changeTimeSetUp);
    }

    /**
     * Click vào button để chọn phương thức thanh toán
     * author: DienLT2
     */
    public void clickButtonMethodPayment() {
        clickEl(wait, link_methodPayment);
    }

    /**
     * Click radio chọn phương thức thanh toán Momo
     * author: DienLT2
     */
    public void clickRadioMomo() {
        clickEl(wait, radio_MoMo);
        clickEl(wait, button_popupConfirm);
    }

    /**
     * Click radio chọn phương thức thanh toán VNPay
     * author: DienLT2
     */
    public void clickRadioVNPay() {
        clickEl(wait, radio_VNPay);
        clickEl(wait, button_popupConfirm);
    }

    /**
     * Click radio chọn phương thức thanh toán thẻ quốc tế
     * author: DienLT2
     */
    public void clickRadioCardInternation() {
        clickEl(wait, radio_cardInternation);
        clickEl(wait, button_popupConfirm);
    }

    /**
     * Click radio chọn phương thức thanh toán thẻ Foxpay
     * author: DienLT2
     */
    public void clickRadioFoxpay() {
        clickEl(wait, radio_cardInternation);
    }

    /**
     * Click radio chọn phương thức thanh toán thẻ Foxpay
     * author: DienLT2
     */
    public void clickIconXPopupMethod() {
        clickEl(wait, icon_close);
    }

    /**
     * Get thông tin trong popup thanh toán
     * author: DienLT2
     */
    public List verifyListPopupPayment() {
        Query[] element = {label_popupPayment, label_popupNoteInfo, label_popupCardInternation, label_popupATM, label_popupFoxpay, label_popupMomo, label_popupVNPay, label_popupHome};
        return listTitleRegistrationInfo(wait, element);
    }

    /**
     * Kiểm tra thông tin trong popup voucher giới thiệu bạn bè
     * author: DienLT2
     */
    public List verifyInformationPopupVoucher() {
        Query[] element = {label_voucher, button_apply, label_available};
        return listTitleRegistrationInfo(wait, element);
    }

    /**
     * Kiểm tra thông tin trong popup hủy mã giới thiệu bạn bè
     * author: DienLT2
     */
    public List verifyInformationPopupClose() {
        Query[] element = {label_conformClose, label_messageClose, button_no, button_yes};
        return listTitleRegistrationInfo(wait, element);
    }

    /**
     * Kiểm tra thông tin trong popup hủy mã giới thiệu bạn bè
     * author: DienLT2
     */
    public String verifyInformationNotificationError() {
        String message = label_messageNotiError.findWebElement().getText();
        return message;
    }

    /**
     * Kiểm tra tắt popup khi click X và click button đồng ý
     * author: DienLT2
     */
    public Boolean isPopupDisplayVoucher() {
        return isElementVisible(wait, popup_voucher);
    }

    /**
     * kiểm tra radio button tương ứng với mỗi hình thức thanh toán
     * author: DienLT2
     */
    public Boolean checkRadioButton() {
        Query[] radioButton = {radio_cardInternation, radio_cardATM, radio_FoxPay, radio_MoMo, radio_VNPay, radio_paymentHome, icon_close, button_popupConfirm};
        int count = 0;
        for (int i = 0; i <= (radioButton.length - 1); i++) {
            if (isElementVisible(wait, radioButton[i]) == true) {
                count++;
            }
        }
        if (count != radioButton.length) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Click vào button xác nhận thanh toán
     * author: DienLT2
     */
    public void clickButtonConfirmPayment() {
        clickEl(wait, button_popupConfirm);
    }

    /**
     * Click vào phương thức thanh toán Momo
     * author: DienLT2
     */
    public void clickChooseMomo() {
        clickEl(wait, radio_MoMo);
        clickEl(wait, button_popupConfirm);
    }

    /**
     * Click vào button Thanh toán
     * author: DienLT2
     */
    public ActionsRegister clickButtonPayment() throws InterruptedException {
        Thread.sleep(2000);
        clickEl(wait, button_payment);
        return this;
    }

    /**
     * Click vào button chọn mã khác
     * author: DienLT2
     */
    public void clickButtonChooseCode() {
        clickEl(wait, button_ChooseCode);
    }

    /**
     * Click vào button chọn mã khác
     * author: DienLT2
     */
    public void clickButtonApply() {
        clickEl(wait, button_apply);
    }

    /**
     * Click vào button đồng ý sau khi hiển thị popup đã áp dụng mã GTBB thành công
     * DienLT2
     */
    public void clickButtonPupopYes() {
        clickEl(wait, button_Yes);
    }

    /**
     * Apply mã giới thiệu bạn bè
     * author: DienLT2
     */
    public void inputApplyVoucher() {
        text_inputVoucher.findWebElement().sendKeys(codeFriendsVoucher);
        clickButtonApply();
    }

    /**
     * Apply mã giới thiệu bạn bè thất bại
     * author: DienLT2
     */
    public void inputApplyVoucherError() {
        text_inputVoucher.findWebElement().sendKeys(codeFriendsVoucherError);
        clickButtonApply();
    }

    /**
     * Click vào dấu X mã giảm giá
     * author: DienLT2
     */
    public void clickButtonXVoucherClose() {
        clickEl(wait, button_X);
    }

    /**
     * Click vào dấu X mã giảm giá
     * author: DienLT2
     */
    public void clickIconXVoucherClose() {
        clickEl(wait, popup_iconX);
    }

    /**
     * Click vào dấu X trong popup voucher
     * author: DienLT2
     */
    public void clickButtonXVoucher() {
        clickEl(wait, button_voucherX);
    }

    /**
     * kiếm tra hình thức thanh toán khi không click button [X]
     * author: DienLT2
     */
    public void compareMethodPay() {
        String valueDefaultMethod = label_defaultMethodPay.findWebElement().getText();
        clickRadioFoxpay();
        clickIconXPopupMethod();
        String valueAfterChoose = label_defaultMethodPay.findWebElement().getText();
        Assert.assertEquals(valueDefaultMethod, valueAfterChoose);
    }

    /**
     * kiếm tra thông tin trên màn hình áp dụng voucher
     * author: DienLT2
     */
    public void checkButtonNoYesClose() throws InterruptedException {
        String valueBeforeClickButtonTotalPriceVoucher = getTextElement(wait, label_numberAfterPriceTotal).trim();
        Thread.sleep(2000);
        clickButtonXVoucherClose();
        clickEl(wait, button_no);
        String valueAfterClickButtonNoTotalPriceVoucher = getTextElement(wait, label_numberAfterPriceTotal).trim();
        Assert.assertEquals(valueBeforeClickButtonTotalPriceVoucher, valueAfterClickButtonNoTotalPriceVoucher);
        Thread.sleep(2000);
        clickButtonXVoucherClose();
        clickEl(wait, button_yes);
        Thread.sleep(2000);
        String valueAfterClickButtonYesTotalPriceVoucher = getTextElement(wait, label_numberCloseVoucherPriceTotal).trim();
        Assert.assertNotEquals(valueBeforeClickButtonTotalPriceVoucher, valueAfterClickButtonYesTotalPriceVoucher);
    }

    /**
     * kiếm tra thông tin trên màn hình áp dụng voucher
     * author: DienLT2
     */
    public void verifyPopupVoucher() throws InterruptedException {
        String valueBeforeTotalPriceVoucher = getTextElement(wait, label_numberBeforePriceTotal).trim();
        Thread.sleep(2000);
        clickButtonChooseCode();
        inputApplyVoucher();
        Assert.assertTrue(checkElementDisplayed(wait, popup_notiSuccess));
        Assert.assertTrue(checkElementDisplayed(wait, button_closeVoucher));
        Assert.assertTrue(checkElementDisplayed(wait, button_Yes));
        clickButtonPupopYes();
        String valueAfterTotalPriceVoucher = getTextElement(wait, label_numberAfterPriceTotal).trim();
        Assert.assertNotEquals(valueBeforeTotalPriceVoucher, valueAfterTotalPriceVoucher);
    }

    /**
     * Nhập thông tin trên màn hình đăng ký
     * author: DienLT2
     */
    public ActionsRegister inputInformationPaymentATM() throws InterruptedException {
        Thread.sleep(1000);
        Query[] locator = {text_numberCard, text_fullnameCard, text_dateCard};
        String[] text = {inputNumberCard, inputFullNameCard, inputDateCard};
        for (int i = 0; i <= (locator.length - 1); i++) {
            clearInput(locator[i]);
            enterText(locator[i], text[i]);
        }
        clickEl(wait, button_continueCard);
        enterOTP(inputOTPCard);
        clickEl(wait, button_continueOTP);
        Thread.sleep(30000);
        return this;
    }

    /**
     * Nhập mã OTP vào test field
     * author: DienLT2
     */
    public ActionsRegister enterOTP(String otp) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(text_OTPCard.by()));
        clearInput(text_OTPCard);
        text_OTPCard.findWebElement().sendKeys(otp);
        return this;
    }

    /**
     * kiếm tra thông tin trên màn hình hoàn tất đăng ký
     * author: DienLT2
     **/
    public List verifyDisplayFinish() {
        Query[] element = {label_orderCode, label_totalPrice, label_copy, label_orderDetail, label_electronic_contract};
        return listTitleRegistrationInfo(wait, element);
    }

    /**
     * Kiểm tra khung search trong Dropdown Tỉnh/thành, quận/huyện, phường/xã, đường/phố
     * author: DienLT2
     **/
    public void checkSearchDropdown() throws InterruptedException {
        List<String> inputProvince = Stream.of(inputSearchProvince01, inputSearchProvince02).collect(Collectors.toList());
        Assert.assertTrue(checkSearchBoxDropdown(dropdown_province
                , searchBox_province
                , listItem_province
                , inputProvince));

        List<String> inputDistrict = Stream.of(inputSearchDistrict01, inputSearchDistrict02).collect(Collectors.toList());
        Assert.assertTrue(checkSearchBoxDropdown(dropdown_district
                , searchBox_district
                , listItem_district
                , inputDistrict));

        List<String> inputWard = Stream.of(inputSearchWard01, inputSearchWard02).collect(Collectors.toList());
        Assert.assertTrue(checkSearchBoxDropdown(dropdown_ward
                , searchBox_ward
                , listItem_ward
                , inputWard));

        List<String> inputStreet = Stream.of(inputSearchStreet01, inputSearchStreet02).collect(Collectors.toList());
        Assert.assertTrue(checkSearchBoxDropdown(dropdown_street
                , searchBox_street
                , listItem_street
                , inputStreet));
    }

    /**
     * Kiểm tra hiển thị popup thông báo khi không có hạ tầng
     * author: DienLT2
     **/
    public void inputInformationDisplayPopupNotification() throws InterruptedException {
        Thread.sleep(1000);
        Query[] locator = {text_name, text_birthday, text_idNumber, text_email, text_address};
        String[] text = {inputName, inputBirthday, inputIdNumber, inputEmail, inputAddress};
        for (int i = 0; i <= (locator.length - 1); i++) {
            clearInput(locator[i]);
            enterText(locator[i], text[i]);
        }
        clearInput(text_phone);
        enterPhone(inputPhoneNumber + TimeUtil.generateRandomString());
        checkChooseDroplist(listItem_gender, dropdown_gender, inputGender);
        checkChooseDroplist(listItem_province, dropdown_province, inputSearchDropdownProvince);
        checkChooseDroplist(listItem_district, dropdown_district, inputSearchDropdownDistrict);
        checkChooseDroplist(listItem_ward, dropdown_ward, inputSearchDropdownWard);
        checkChooseDroplist(listItem_street, dropdown_street, inputSearchDropdownStreet);
        clickEl(wait, button_continue);
        Thread.sleep(5000);
        WebElement msgNotification = wait.until(ExpectedConditions.visibilityOfElementLocated(popup_msgInfrastructure.by()));
        Assert.assertEquals(msgNotification, msgPopupNotification);
    }

    /**
     * Kiểm tra hiển thị đã được input trước đó
     * author: DienLT2
     **/
    public List checkInformationRegister() {
        Query[] locator = {text_name, text_phone, text_birthday, text_idNumber, text_email, text_address};
        List<String> listelement = new ArrayList<>();
        for (int i = 0; i < locator.length; i++) {
            listelement.add(locator[i].findWebElement().getAttribute("value"));
        }
        return listelement;
    }

    public List listInformationRegistration() {
        String[] text = {inputName, inputPhone, inputBirthday, inputIdNumber, inputEmail, inputAddress};
        List<String> listinformation = new ArrayList<>();
        for (int i = 0; i < text.length; i++) {
            listinformation.add(text[i]);
        }
        return listinformation;
    }

    /**
     * Kiểm tra trường giới tính
     * author: DienLT2
     **/
    public List checkDropdownGender() {
        clickEl(wait, dropdown_gender);
        Query[] locator = {label_male, label_female};
        List<String> listelement = new ArrayList<>();
        for (int i = 0; i < locator.length; i++) {
            listelement.add(locator[i].findWebElement().getText());
        }
        return listelement;
    }

    public List listDropdownGender() {
        String[] text = {inputMale, inputFemale};
        List<String> listinformation = new ArrayList<>();
        for (int i = 0; i < text.length; i++) {
            listinformation.add(text[i]);
        }
        return listinformation;
    }

    /**
     * Kiểm tra các giá trị trong dropdown thời gian
     * author: DienLT2
     **/
    public List checkDropdownTimeSetup() {
        clickEl(wait, dropdown_time);
        Query[] locator = {listItem_time01, listItem_time02, listItem_time03, listItem_time04};
        List<String> listelement = new ArrayList<>();
        for (int i = 0; i < locator.length; i++) {
            listelement.add(locator[i].findWebElement().getText());
        }
        return listelement;
    }

    public List listDropdownTimeSetup() {
        String[] text = {inputTime01, inputTime02, inputTime03, inputTime04};
        List<String> listinformation = new ArrayList<>();
        for (int i = 0; i < text.length; i++) {
            listinformation.add(text[i]);
        }
        return listinformation;
    }

    public String clickDropdownTimeSetup() {
        clickEl(wait, listItem_time04);
        String time = dropdown_time.findWebElement().getText();
        return time;
    }

    /**
     * Kiểm tra thông tin dropdown của địa chỉ lắp đặt
     * author: DienLT2
     **/
    public void checkDatePicker() {
        String ward = label_ward.findWebElement().getText();
    }

    /**
     * Kiểm tra thông tin dropdown của địa chỉ lắp đặt
     * author: DienLT2
     **/
    public String checkDropdownWard() {
        String ward = label_ward.findWebElement().getText();
        return ward;
    }

    /**
     * Kiểm tra hiển thị popup thông báo khi nhập thông tin đăng ký
     * author: MinhLH5
     **/
    public List getlistErrorCamera() {
        sleepTo(2000);
        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(list_TextError_camera.by()));
        return getTextListItems(list_TextError_camera);
    }

    /**
     * Kiểm tra icon X filed Name
     * author: DienLT2
     **/
    public void checkIconXName() throws InterruptedException {
        Query[] locator = {text_birthday, text_idNumber, text_email, text_address};
        String[] text = {inputBirthday, inputIdNumber, inputEmail, inputAddress};
        for (int i = 0; i <= (locator.length - 1); i++) {
            clearInput(locator[i]);
            Thread.sleep(1000);
            enterText(locator[i], text[i]);
            Thread.sleep(1000);
        }
        clearInput(text_phone);
        enterPhone(inputPhoneNumber + TimeUtil.generateRandomString());
        checkChooseDroplist(listItem_gender, dropdown_gender, inputGender);
        Thread.sleep(1000);
        checkChooseDroplist(listItem_street, dropdown_street, inputStreet1);
        Thread.sleep(1000);
        clickEl(wait, button_continue);
        enterName(inputName);
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        actions.moveToElement(button_iconX.findWebElement()).click().build().perform();
        Thread.sleep(1000);
        //clickEl(wait, button_iconX);
    }

    /**
     * Kiểm tra giá trị điền của trường họ tên
     * author: DienLT2
     **/
    public String getTextNameInputNull() {
        return text_name.findWebElement().getAttribute("value");
    }

    /**
     * Chờ đến khi dùng loading
     * author: MinhLH5
     **/
    public ActionsRegister waitStopLoading() {
        logger.debug("waitStopLoading");
        //fix
        wait.withTimeout(Duration.ofMinutes(5));
        wait.until(waitForLoadingCSSStype(loading.findWebElement(), "display: none;"));
        return this;
    }

    public ActionsRegister waitReturnMainPage() {
        wait.until(ExpectedConditions.urlContains(url));
        return this;
    }

    /**
     * Click vào button thay đổi địa chỉ lắp đặt
     * author: DienLT2
     */
    public String checkClickLinkInformation() {
        clickEl(wait, label_registerInformation);
        return driver.getCurrentUrl();
    }

    /**
     * Hàm chọn phương thức thanh toán
     * author: HungNDT2
     * */
    public void choosePaymentMethod(String PaymentMethod)  {
        clickEl(wait,button_choosePaymentMethod);
        wait.until(ExpectedConditions.visibilityOfElementLocated(button_confirmPaymentMethod.by()));
        chooseList(list_paymentMethods,PaymentMethod);
        sleepTo(1000);
        clickEl(wait,button_confirmPaymentMethod);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(label_namePaymentMethods.by()));
        sleepTo(1000);
    }
    public boolean areElementsDisplayed(List<WebElement> elementsList) {
        for (WebElement element : elementsList) {
            if (!element.isDisplayed()) {
                return false;
            }
        }
        return true;
    }
    public boolean verifyElementsDisplayOnInfoSectionRegisterPage(){
        List<WebElement> elementsList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(listRegisterInformationLabel.by()));
        return areElementsDisplayed(elementsList);
    }
    public boolean compareElementListsOnInfoSectionRegisterPage() {
        List<WebElement> elementsList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(listRegisterInformationLabel.by()));
        List listExpected = CommonRegister.listPrivateInfo;
        if (elementsList.size() != listExpected.size()) {
            return false;
        }
        for (int i = 0; i < elementsList.size(); i++) {
            if (!elementsList.get(i).getText().equals(listExpected.get(i).toString())) {
                return false;
            }
        }
        return true;
    }
    List<WebElement> elementsList = new ArrayList<WebElement>(){
    };
    public boolean compareElementListsOnAmountingAddressSectionRegisterPage() {
        elementsList.add(dropdown_province.findWebElement());
        elementsList.add(dropdown_district.findWebElement());
        elementsList.add(dropdown_ward.findWebElement());
        elementsList.add(dropdown_street.findWebElement());
        elementsList.add(label_home.findWebElement());
        elementsList.add(label_tower.findWebElement());
        elementsList.add(label_adress.findWebElement());
        elementsList.add(label_note.findWebElement());
        elementsList.add(button_continue.findWebElement());
        List listExpected = CommonRegister.getListSetUpInfo;
        if (elementsList.size() != listExpected.size()) {
            return false;
        }
        for (int i = 0; i < elementsList.size(); i++) {
            if (!elementsList.get(i).getText().equals(listExpected.get(i).toString())) {
                return false;
            }
        }
        return true;
    }
    public boolean verifyElementsDisplayOnAmountingAddressSectionRegisterPage(){
        return areElementsDisplayed(elementsList);
    }
    public boolean verifyBlankedCMNDMessageDisplayed(String expectedMsg) {
        WebDriverWait wait = new WebDriverWait(driver,60);
        WebElement cmndBlankVerifyMessageText = wait.until(ExpectedConditions.visibilityOfElementLocated(label_messageErrorBlankCMND.by()));
        return cmndBlankVerifyMessageText.getText().equalsIgnoreCase(expectedMsg);
    }
    public void sendCMNDLessThan9Num(String param){
        WebElement inputCMND = wait.until(ExpectedConditions.visibilityOfElementLocated(text_idNumber.by()));
        inputCMND.clear();
        wait.until(ExpectedConditions.textToBePresentInElementValue(inputCMND, ""));
        text_idNumber.findWebElement().sendKeys(param);
        sleepTo(2000);
    }
    public boolean verifyWrongFormatCMNDMessageDisplayed(String expectedMsg) {
        WebDriverWait wait = new WebDriverWait(driver,60);
        WebElement cmndWrongFormatVerifyMessageText = wait.until(ExpectedConditions.visibilityOfElementLocated(label_messageErrorFormatCMND.by()));
        return cmndWrongFormatVerifyMessageText.getText().equalsIgnoreCase(expectedMsg);
    }
    public void sendSpecialTextCMNDField(String param){
        WebElement inputCMND = wait.until(ExpectedConditions.visibilityOfElementLocated(text_idNumber.by()));
        inputCMND.clear();
        wait.until(ExpectedConditions.textToBePresentInElementValue(inputCMND, ""));
        text_idNumber.findWebElement().sendKeys(param);
        sleepTo(2000);
    }
    public boolean verifySpecialTextCMNDMessageDisplayed() {
        String specialTextPhoneField = text_idNumber.findWebElement().getText();
        return specialTextPhoneField.equalsIgnoreCase("");
    }
    public void sendCMNDMoreThan12Num(String param){
        WebElement inputCMND = wait.until(ExpectedConditions.visibilityOfElementLocated(text_idNumber.by()));
        inputCMND.clear();
        wait.until(ExpectedConditions.textToBePresentInElementValue(inputCMND, ""));
        text_idNumber.findWebElement().sendKeys(param);
        sleepTo(2000);
        text_idNumber.findWebElement().sendKeys(Keys.ENTER);
    }
    public boolean verifyMax12NumToInputCMNDField(String param) {
        String cmndMax12NumVerifyText = text_idNumber.findWebElement().getAttribute("value");
        return cmndMax12NumVerifyText.equalsIgnoreCase(param);
    }
    public void sendValidCMND(String param){
        WebElement inputCMND = wait.until(ExpectedConditions.visibilityOfElementLocated(text_idNumber.by()));
        inputCMND.clear();
        wait.until(ExpectedConditions.textToBePresentInElementValue(inputCMND, ""));
        text_idNumber.findWebElement().sendKeys(param);
    }
    public void sendTextToInputCitySearchBox(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox_province.by()));
        searchBox_province.findWebElement().sendKeys(inputProvinceMenu);
        List<WebElement> listProvince = Collections.singletonList(wait.until(ExpectedConditions.visibilityOfElementLocated(listItem_province.by())));
        listProvince.get(0).click();
    }
    public void sendTextToInputDistrictSearchBox(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox_district.by()));
        searchBox_district.findWebElement().sendKeys(inputDistrictMenu);
        List<WebElement> listProvince = Collections.singletonList(wait.until(ExpectedConditions.visibilityOfElementLocated(listItem_district.by())));
        listProvince.get(0).click();
    }
    public void sendTextToInputWardSearchBox(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox_ward.by()));
        searchBox_ward.findWebElement().sendKeys(inputWardMenu);
        List<WebElement> listProvince = Collections.singletonList(wait.until(ExpectedConditions.visibilityOfElementLocated(listItem_ward.by())));
        listProvince.get(0).click();
    }
    public void sendTextToInputStreetSearchBox(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox_street.by()));
        searchBox_street.findWebElement().sendKeys(inputStreetMenu);
        List<WebElement> listProvince = Collections.singletonList(wait.until(ExpectedConditions.visibilityOfElementLocated(listItem_street.by())));
        listProvince.get(0).click();
    }
    public void sendTextToOthersFieldsExceptPhoneField(){
        text_name.findWebElement().sendKeys(inputFullNameTxt);
        text_birthday.findWebElement().sendKeys(CommonInternet.inputBirthdayTxt);
        text_phone.findWebElement().sendKeys(CommonInternet.inputPhoneTxt);
        text_email.findWebElement().sendKeys(CommonInternet.inputEmailTxt);
        sleepTo(2000);
        JavascriptExecutor jsExecutor = driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", addressField.findWebElement());
        sleepTo(1000);
        clickEl(wait,dropdown_province);
        sendTextToInputCitySearchBox();
        sleepTo(500);
        clickEl(wait,dropdown_district);
        sendTextToInputDistrictSearchBox();
        sleepTo(500);
        clickEl(wait,dropdown_ward);
        sendTextToInputWardSearchBox();
        sleepTo(500);
        clickEl(wait,dropdown_street);
        sendTextToInputStreetSearchBox();
        text_address.findWebElement().sendKeys(inputHouseNumberMenu);
    }
    public void waitForRefreshURL()  {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.not(ExpectedConditions.urlContains(urlHome))));
    }

}

