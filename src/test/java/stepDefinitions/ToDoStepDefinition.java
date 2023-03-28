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
import org.opentestfactory.exception.ParameterFormatException;
import org.opentestfactory.exception.ParameterNotFoundException;
import org.opentestfactory.util.ParameterService;
import org.testng.Assert;
import page_objects.FPTPlayPage.ActionFPTPlayPage;
import page_objects.LandingPage.ActionLandingPage;
import page_objects.LandingPageInternet.ActionLandingPageInternet;
import page_objects.Menu.ActionsMenu;
import page_objects.Register.ActionsRegister;
import runners.RunCucumberByCompositionTest;

import java.io.IOException;

import static net.fpt.driver_setting.DriverBase.closeDriverObjects;
import static net.fpt.driver_setting.DriverBase.instantiateDriverObject;

public class ToDoStepDefinition extends RunCucumberByCompositionTest {
    public ActionLandingPage landingPage;
    public ActionsMenu menuPage;
    public ActionFPTPlayPage fptPlayPage;
    public ActionLandingPageInternet landingPageInternet;
    public ActionsRegister registerPage;

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
    public void chooseInternetPackage(String parameter){
        landingPage = new ActionLandingPage();
        parameter =  ParameterService.INSTANCE.getString("DS_ten_goi_cuoc",parameter);
        landingPage.clickChooseInternet(parameter);
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
        Assert.assertTrue(landingPage.verifyNameMessageDisplayed(expectedMsg), "Thông báo khi chưa nhập họ và tên chưa hợp lệ");
    }

    @Given("Truy cập hệ thống Websit DKOL")
    public void accessWebsiteDKOL() {
        landingPage = new ActionLandingPage();
        landingPage.goHere();
        sleepTo(3000);
        landingPage.maximizeWindow();
        sleepTo(3000);
        landingPage.checkClickBtnX();
    }

    @When("Chọn mục FPT Play")
    public void selectFPTPlay() {
        fptPlayPage = new ActionFPTPlayPage();
        fptPlayPage.accessFPTPlayPage();
        sleepTo(3000);
    }


    @And("Chọn {string}")
    public void selectnamePackage(String param) {
        fptPlayPage = new ActionFPTPlayPage();
        param =  ParameterService.INSTANCE.getTestString("DS_ten_goi","Gói VIP");
        if(param == "Gói VIP"){
            fptPlayPage.clickbtnPackageVIP();
        }else
        {
            fptPlayPage.clickbtnPackageMAX();
        }
        sleepTo(3000);
    }

    @And("Chọn nút mua ngay")
    public void selectbtnBuyNow() {
        fptPlayPage = new ActionFPTPlayPage();
        fptPlayPage.clickbtnBuyNow();
        sleepTo(3000);
    }

    @Then("Chọn btn Tiếp tục")
    public void selectbtnNext() {
        landingPage = new ActionLandingPage();
        landingPage.clickBtnContinue();
    }

    @When("Vào mục Internet")
    public void goToInternetsSection() throws InterruptedException {
        landingPage.clickLinkFPTInternetHeader();
    }

    @Then("Nhập Họ và tên lớn hơn một trăm ký tự {string}")
    public void inputNameGreaterThan100(String param) {
        landingPageInternet = new ActionLandingPageInternet();
        param = ParameterService.INSTANCE.getString("DS_ho_ten_lon_hon_100",param);
        landingPageInternet.sendTextToInputNameTxt(param);
    }

    @Then("Kiểm tra chỉ cho phép lấy tối đa một trăm ký tự {string}")
    public void verifyAcceptHundredCharacters(String param) {
        landingPageInternet = new ActionLandingPageInternet();
        param = ParameterService.INSTANCE.getString("DS_ho_ten_be_hon_bang_100",param);
        Assert.assertTrue(landingPageInternet.verify100TextToInputNameTxt(param), "The system allows Full name to enter more than 100 characters");
    }

    @Then("Nhập họ và tên bé hơn hoặc bằng một trăm ký tự {string} và các thông tin còn lại")
    public void inputNameIsLessThanOrEqualTo100Characters(String param) {
        landingPageInternet = new ActionLandingPageInternet();
        param = ParameterService.INSTANCE.getString("DS_ho_ten_be_hon_bang_100",param);
        landingPageInternet.sendTextToInputNameTxt(param);
        landingPageInternet.sendTextToOthersFieldsExceptNameField();
        sleepTo(3000);
    }

    @And("Nhấn tiếp tục") @And("Để trống trường Số điện thoại và nhấn tiếp tục") @And("Để trống trường Ngày sinh và nhấn tiếp tục") @And("Để trống trường Địa chỉ, Số nhà và Nhấn tiếp tục")
    public void clickContinueBtn() {
        sleepTo(2000);
        landingPageInternet = new ActionLandingPageInternet();
        landingPageInternet.chooseContinueBtn();
        sleepTo(2000);
    }

    @Then("Kiểm tra chuyển sang màn hình Chọn dịch vụ thành công")
    public void verifyRedirectToChooseServiceScreen() {
        landingPageInternet = new ActionLandingPageInternet();
        Assert.assertTrue(landingPageInternet.verifyGoToServicePage(),"Switch to service selection screen fail!");
    }

    @Then("Kiểm tra click vào logo FPT Telecom và trở về trang chủ DKOL")
    public void verifyClickLogoAndBackToHomePage() {
        landingPageInternet = new ActionLandingPageInternet();
        Assert.assertTrue(landingPageInternet.chooseLogoFPTAndCheckGoToHomePage(), "Failed to switch to Home screen!");
    }

    @Then("Kiểm tra giá trị default của trường giới tính {string}")
    public void verifyDefaultValueOfGenderField(String param) {
        landingPageInternet = new ActionLandingPageInternet();
        param = ParameterService.INSTANCE.getString("DS_default_gioi_tinh",param);
        Assert.assertTrue(landingPageInternet.verifyDefaultGender(param),"Default value of gender field is incorrect!");
    }

    @And("Chọn giới tính: {string}")
    public void chooseGender(String param) {
        landingPageInternet = new ActionLandingPageInternet();
        param = ParameterService.INSTANCE.getString("DS_gioi_tinh",param);
        landingPageInternet.sendTextToInputSearchGender(param);
    }

    @Then("Kiểm tra hiển thị đúng giá trị giới tính {string} vừa chọn")
    public void verifySelectedGenderValue(String param) {
        landingPageInternet = new ActionLandingPageInternet();
        param = ParameterService.INSTANCE.getString("DS_gioi_tinh",param);
        Assert.assertTrue(landingPageInternet.verifySelectedGender(param),"The value you just selected in the gender field is incorrect!");
    }

    @Then("Nhập Họ và tên {string}")
    public void inputFullName(String param) {
        landingPageInternet = new ActionLandingPageInternet();
        param = ParameterService.INSTANCE.getString("DS_ho_ten",param);
        landingPageInternet.sendTextToInputNameTxt(param);
    }

    @And("Nhấn chọn icon X")
    public void chooseIconX() {
        landingPageInternet = new ActionLandingPageInternet();
        landingPageInternet.chooseClearBtn();
    }

    @And("Kiểm tra nội dung vừa nhập ở textbox Họ và tên đã được xóa")
    public void verifyInputtedName() {
        landingPageInternet = new ActionLandingPageInternet();
        Assert.assertTrue(landingPageInternet.verifyInputtedNameValue(), "The name you just filled in has not been deleted!");
    }

    @Then("Kiểm tra default email {string}")
    public void verifyDefaultEmail(String param) {
        landingPageInternet = new ActionLandingPageInternet();
        param = ParameterService.INSTANCE.getString("DS_default_email",param);
        Assert.assertTrue(landingPageInternet.verifyDefaultEmailPlaceHolder(param),"Default email placeholder value is not match!");
    }

    @And("Nhập email sai format {string} và nhập tất cả thông tin còn lại")
    public void inputWrongEmailFormatAndOthers(String param) {
        landingPageInternet = new ActionLandingPageInternet();
        param = ParameterService.INSTANCE.getString("DS_error_format_email",param);
        landingPageInternet.sendTextToInputEmailTxt(param);
        landingPageInternet.sendTextToOthersFieldsExceptEmailField();
    }

    @Then("Hiện thông báo sai format email {string}")
    public void verifyMessageWhenInputtedWrongFormatEmail(String expectedMsg) {
        landingPageInternet = new ActionLandingPageInternet();
        Assert.assertTrue(landingPageInternet.verifyEmailMessageDisplayed(expectedMsg), "The message notify wrong email format does not appear");
    }

    @Then("Hiện thông báo khi để trống trường Số điện thoại {string}")
    public void verifyMessageWhenLeftPhoneFieldBlank(String expMessage) {
        landingPageInternet = new ActionLandingPageInternet();
        Assert.assertTrue(landingPageInternet.verifyBlankPhoneMessageDisplayed(expMessage),"The message leaving the Phone number field blank does not appear");
    }

    @And("Nhập số điện thoại có chứa chữ, ký tự đặc biệt {string}")
    public void inputPhoneNumberContainLetterAndSpecialCharacter(String param) {
        landingPageInternet = new ActionLandingPageInternet();
        param = ParameterService.INSTANCE.getString("DS_sdt_dac_biet",param);
        landingPageInternet.sendSpecialTextToInputPhoneTxt(param);
    }

    @Then("Kiểm tra hệ thống không cho phép nhập chữ, ký tự đặc biệt vào trường Số điện thoại")
    public void verifyInputSpecialTextInPhoneField() {
        landingPageInternet = new ActionLandingPageInternet();
        Assert.assertTrue(landingPageInternet.verifyInputSpecialTextPhoneField(),"The system allows entering letters and special characters in the Phone number field");
    }

    @And("Nhập số điện thoại bé hơn mười số {}")
    public void inputPhoneNumberLessThan10Number(String param) {
        landingPageInternet = new ActionLandingPageInternet();
        param = ParameterService.INSTANCE.getString("DS_sdt_be_hon_10",param);
        landingPageInternet.sendLessThan10NumberToInputPhoneTxt(param);
    }

    @Then("Hiện thông báo khi nhập vào số điện thoại bé hơn mười số {string}")
    public void verifyMessageWhenInputPhoneNumberLessThan10(String expMessage) {
        landingPageInternet = new ActionLandingPageInternet();
        Assert.assertTrue(landingPageInternet.verifyLessThan10PNumberMessageDisplayed(expMessage),"The message when input less than 10 numbers into phone field does not appear");
    }

    @And("Nhập số điện thoại có số đầu khác không {}")
    public void inputPhoneNumberWithPrefixOtherThan0(String param) {
        landingPageInternet = new ActionLandingPageInternet();
        param = ParameterService.INSTANCE.getString("DS_sdt_khac_0",param);
        landingPageInternet.sendPNumberDiverse0ToInputPhoneTxt(param);
    }

    @Then("Hiện thông báo khi nhập vào số điện thoại có đầu số khác không {string}")
    public void verifyMessageWhenInputPhoneNumberWithPrefixDiverse0(String expMessage) {
        landingPageInternet = new ActionLandingPageInternet();
        Assert.assertTrue(landingPageInternet.verifyPrefixDiverse0PNumberMessageDisplayed(expMessage),"The message when input less than 10 numbers into phone field does not appear");
    }

    @And("Nhập số điện thoại hợp lệ {} và các thông tin còn lại")
    public void inputValidPhoneNumberAndOthersInfo(String param) {
        landingPageInternet = new ActionLandingPageInternet();
        param = ParameterService.INSTANCE.getString("DS_sdt_hop_le",param);
        landingPageInternet.sendTextToInputPhoneTxt(param);
        landingPageInternet.sendTextToOthersFieldsExceptPhoneField();
        sleepTo(3000);
    }

    @Then("Kiểm tra hiển thị: Logo FPT Telecom, Thông tin đăng ký, Chọn dịch vụ, Thông tin thanh toán, Hoàn tất đăng ký")
    public void verifyDisplayElementsOnRegisterPage() {
        landingPageInternet = new ActionLandingPageInternet();
        Assert.assertTrue(landingPageInternet.verifyElementsOnNavbarRegisterPage(),"Logo FPT Telecom, Thông tin đăng ký, Chọn dịch vụ, Thông tin thanh toán, Hoàn tất đăng ký are not displayed");
    }

    @Then("Kiểm tra hiển thị các label: Họ và tên *, Số điện thoại *, Số CMND,CCCD *, Ngày sinh *, Giới tính, Địa chỉ email ở mục thông tin khách hàng")
    public void verifyDisplayElementsOnCustomerInformationSection() {
        registerPage = new ActionsRegister();
        Assert.assertTrue(registerPage.verifyElementsDisplayOnInfoSectionRegisterPage(),"Họ và tên *, Số điện thoại *, Số CMND,CCCD *, Ngày sinh *, Giới tính, Địa chỉ email are not displayed");
        Assert.assertTrue(registerPage.compareElementListsOnInfoSectionRegisterPage(),"The text of these label Họ và tên *, Số điện thoại *, Số CMND,CCCD *, Ngày sinh *, Giới tính, Địa chỉ email are not matched the expected value");
    }

    @Then("Kiểm tra hiển thị các mục Tỉnh, Thành phố, Quận, huyện, Phường, xã, Đường, Radio button: NHÀ RIÊNG, CHUNG CƯ, Địa chỉ, số nhà , Ghi chú, Btn Tiếp tục")
    public void verifyDisplayElementsOnMountingAddressSection() {
        registerPage = new ActionsRegister();
        Assert.assertTrue(registerPage.verifyElementsDisplayOnAmountingAddressSectionRegisterPage(),"Tỉnh, Thành phố, Quận, huyện, Phường, xã, Đường, Radio button: NHÀ RIÊNG, CHUNG CƯ, Địa chỉ, số nhà , Ghi chú, Btn Tiếp tục are not displayed");
        Assert.assertTrue(registerPage.compareElementListsOnAmountingAddressSectionRegisterPage(),"The value of these label Tỉnh, Thành phố, Quận, huyện, Phường, xã, Đường, Radio button: NHÀ RIÊNG, CHUNG CƯ, Địa chỉ, số nhà , Ghi chú, Btn Tiếp tục are not matched the expected value");
    }

    @Then("Hiện thông báo chưa nhập CMND, CCCD {string}")
    public void verifyMessageWhenLeftCMNDBlanked(String expectedMsg) {
        registerPage = new ActionsRegister();
        Assert.assertTrue(registerPage.verifyBlankedCMNDMessageDisplayed(expectedMsg),"The message of CMND Fields when its blanked not match the expected message");
    }

    @And("Nhập Số CMND, CCCD bé hơn chín số {}")
    public void inputCMNDLessThan9Numbers(String param) {
        registerPage = new ActionsRegister();
        param = ParameterService.INSTANCE.getString("DS_cmnd_be_hon_9",param);
        registerPage.sendCMNDLessThan9Num(param);
    }

    @Then("Hiện thông báo nhập sai format CMND, CCCD {string}")
    public void verifyMessageWhenInputWrongCMNDFormat(String expectedMsg) {
        registerPage = new ActionsRegister();
        Assert.assertTrue(registerPage.verifyWrongFormatCMNDMessageDisplayed(expectedMsg),"The message of CMND Fields when its blanked not match the expected message");
    }

    @And("Nhập Số CMND, CCCD có chứa chữ, ký tự đặc biệt {string}")
    public void inputCMNDContainLetterAndSpecialCharacter(String param) {
        registerPage = new ActionsRegister();
        param = ParameterService.INSTANCE.getString("DS_cmnd_ky_tu_dac_biet",param);
        registerPage.sendSpecialTextCMNDField(param);
    }

    @Then("Kiểm tra hệ thống không cho phép nhập chữ và ký tự đặc biệt vào trường CMND, CCCD")
    public void verifyInputSpecialTextInCMNDField() {
        registerPage = new ActionsRegister();
        Assert.assertTrue(registerPage.verifySpecialTextCMNDMessageDisplayed(),"The system allows entering letters and special characters in the CMND field");
    }

    @And("Nhập Số CMND, CCCD lớn hơn mười hai số {}")
    public void inputCMNDMoreThan12Numbers(String param) {
        registerPage = new ActionsRegister();
        param = ParameterService.INSTANCE.getString("DS_cmnd_lon_hon_12",param);
        registerPage.sendCMNDMoreThan12Num(param);
    }

    @Then("Kiểm tra hệ thống chỉ cho phép nhập vào CMND, CCCD mười hai số {}")
    public void verifyCMNDFieldAcceptInputMax12Numbers(String param) {
        registerPage = new ActionsRegister();
        param = ParameterService.INSTANCE.getString("DS_cmnd_12_so",param);
        Assert.assertTrue(registerPage.verifyMax12NumToInputCMNDField(param),"The system allows CMND to enter more than 12 numbers");
    }

    @And("Nhập Số CMND, CCCD hợp lệ {} và các thông tin còn lại")
    public void inputValidCMNDAndOthersInfo(String param) {
        registerPage = new ActionsRegister();
        param = ParameterService.INSTANCE.getString("DS_cmnd_hop_le",param);
        registerPage.sendValidCMND(param);
        registerPage.sendTextToOthersFieldsExceptPhoneField();
        sleepTo(2000);
    }

    @Then("Hiện thông báo khi để trống trường Ngày sinh {string}")
    public void verifyMessageWhenLeavingBirthdayFieldBlank(String expectedMsg) {
        registerPage = new ActionsRegister();
        Assert.assertTrue(registerPage.verifyBlankedBirthdayMessageDisplayed(expectedMsg),"The message of Birthday Field when its blanked not match the expected message");
    }

    @And("Nhập sai thông tin vào trường ngày sinh {string}")
    public void inputWrongInfoIntoBirthdayField(String param) {
        registerPage = new ActionsRegister();
        param = ParameterService.INSTANCE.getString("DS_ngay_sinh_sai",param);
        registerPage.sendBirthdayValue(param);
    }

    @Then("Hiện thông báo khi nhập sai thông tin trong trường ngày sinh {string}")
    public void verifyMessageWhenInputWrongBirthday(String expectedMsg) {
        registerPage = new ActionsRegister();
        Assert.assertTrue(registerPage.verifyWrongBirthdayMessageDisplayed(expectedMsg),"The message of Birthday Field when its wrong not match the expected message");
    }
    @And("Nhập ngày sinh có chứa chữ, ký tự đặc biệt {string}")
    public void inputSpecialTxtIntoBirthdayField(String param) {
        registerPage = new ActionsRegister();
        param = ParameterService.INSTANCE.getString("DS_ngay_sinh_dac_biet",param);
        registerPage.sendBirthdayValue(param);
    }
    @Then("Kiểm tra hệ thống không cho phép nhập chữ, ký tự đặc biệt vào trường Ngày sinh")
    public void verifyNotAllowInputSpecialTxtToBDField() {
        registerPage = new ActionsRegister();
        Assert.assertTrue(registerPage.verifySpecialTextBirthdayMessageDisplayed(),"The system allows entering letters and special characters in the Birthday field");
    }

    @And("Nhập ngày tháng năm sinh nhỏ hơn mười lăm tuổi {}")
    public void inputBirthdayLessThan15YearsOld(String param) {
        registerPage = new ActionsRegister();
        param = ParameterService.INSTANCE.getString("DS_ngay_sinh_nho_hon_15t",param);
        registerPage.sendBirthdayValue(param);
    }

    @Then("Hiển thị thông báo khi nhập vào ngày sinh nhỏ hơn mười lăm tuổi {string}")
    public void verifyMessageWhenInputLessThan15YearsOld(String expectedMsg) {
        registerPage = new ActionsRegister();
        Assert.assertTrue(registerPage.verifyLess15YrsOBirthdayMessageDisplayed(expectedMsg),"The message of Birthday Field when input less than 15 years old birthdate not match the expected message");
    }

    @And("Nhập ngày tháng năm sinh bằng mười lăm tuổi {} và các thông tin còn lại")
    public void nhậpNgàyThángNămSinhBằngMườiLămTuổiNgay_sinh_TVàCácThôngTinCònLại(String param) {
        registerPage = new ActionsRegister();
        param = ParameterService.INSTANCE.getString("DS_ngay_sinh_15t",param);
        registerPage.sendBirthdayValue(param);
        registerPage.sendTextToOthersFieldsExceptBirthdayField();
    }

    @Then("Kiểm tra giá trị default của trường Tỉnh, Thành phố {string} và Combobox cho phép chọn giá trị")
    public void verifyDefaultValueOfCityAndChooseComboboxValue(String param) {
        registerPage = new ActionsRegister();
        param = ParameterService.INSTANCE.getString("DS_default_tinh_thanh",param);
        Assert.assertTrue(registerPage.verifyCityHolderPlace(param),"Default value on city dropdown box not matched");
        registerPage.chooseComboBoxCity();
    }

    @Then("Kiểm tra giá trị default của trường Quận, huyện {string} và Combobox cho phép chọn giá trị")
    public void verifyDefaultValueOfDistrictAndChooseComboboxValue(String param) {
        registerPage = new ActionsRegister();
        param = ParameterService.INSTANCE.getString("DS_default_quan_huyen",param);
        Assert.assertTrue(registerPage.verifyDistrictHolderPlace(param),"Default value on district dropdown box not matched");
        registerPage.chooseComboBoxDistrict();
    }

    @Then("Kiểm tra giá trị default của trường Phường, xã {string} và Combobox cho phép chọn giá trị")
    public void verifyDefaultValueOfWardAndChooseComboboxValue(String param) {
        registerPage = new ActionsRegister();
        param = ParameterService.INSTANCE.getString("DS_default_phuong_xa",param);
        Assert.assertTrue(registerPage.verifyWardHolderPlace(param),"Default value on ward dropdown box not matched");
        registerPage.chooseComboBoxWard();
    }

    @Then("Kiểm tra giá trị default của trường Đường, Phố {string} và Combobox cho phép chọn giá trị")
    public void verifyDefaultValueOfStreetAndChooseComboboxValue(String param) {
        registerPage = new ActionsRegister();
        param = ParameterService.INSTANCE.getString("DS_default_duong_pho",param);
        Assert.assertTrue(registerPage.verifyStreetHolderPlace(param),"Default value on street dropdown box not matched");
        registerPage.chooseComboBoxStreet();
    }

    @Then("Nhập giá trị có dấu vào trường Tỉnh, Thành phố {string} và kiểm tra hiển thị đúng giá trị có dấu tương ứng trong dropdown list Tỉnh, Thành phố")
    public void inputSignedValueIntoCityFieldAndVerifyDisplayedValueInDropdownList(String param) {
        registerPage = new ActionsRegister();
        param = ParameterService.INSTANCE.getString("DS_tinh_thanh_co_dau",param);
        Assert.assertTrue(registerPage.enteredValueWithSpecifiedSignIntoCitySearch(param),"Do not display the corresponding signed value in City dropdown list When inputted signed value");
    }

    @Then("Nhập giá trị không dấu vào trường Tỉnh, thành {string} và kiểm tra hiển thị đúng giá trị có dấu {string} tương ứng trong dropdown list Tỉnh, Thành phố")
    public void inputUnsignedValueIntoCityFieldAndVerifyDisplayedSignedValueInDropdownList(String param1, String param2) {
        registerPage = new ActionsRegister();
        param1 = ParameterService.INSTANCE.getString("DS_tinh_thanh_khong_dau",param1);
        param2 = ParameterService.INSTANCE.getString("DS_tinh_thanh_co_dau",param2);
        Assert.assertTrue(registerPage.enteredValueWithUnspecifiedSignIntoCitySearch(param1, param2),"Do not display the corresponding signed value in City dropdown list When inputted unsigned value");
    }

    @Then("Nhập giá trị có dấu vào trường Quận, huyện {string} và kiểm tra hiển thị đúng giá trị có dấu tương ứng trong dropdown list Quận, Huyện")
    public void inputSignedValueIntoDistrictFieldAndVerifyDisplayedValueInDropdownList(String param) {
        registerPage = new ActionsRegister();
        param = ParameterService.INSTANCE.getString("DS_quan_huyen_co_dau",param);
        Assert.assertTrue(registerPage.enteredValueWithSpecifiedSignIntoDistrictSearch(param),"Do not display the corresponding signed value in District dropdown list When inputted signed value");
    }

    @Then("Nhập giá trị không dấu vào trường Quận, huyện {string} và kiểm tra hiển thị đúng giá trị có dấu {string} tương ứng trong dropdown list Quận, Huyện")
    public void inputUnsignedValueIntoDistrictFieldAndVerifyDisplayedValueInDropdownList(String param1, String param2) {
        registerPage = new ActionsRegister();
        param1 = ParameterService.INSTANCE.getString("DS_quan_huyen_khong_dau",param1);
        param2 = ParameterService.INSTANCE.getString("DS_quan_huyen_co_dau",param2);
        Assert.assertTrue(registerPage.enteredValueWithUnspecifiedSignIntoDistrictSearch(param1, param2),"Do not display the corresponding signed value in District dropdown list When inputted unsigned value");
    }

    @Then("Nhập giá trị có dấu vào trường Phường, xã {string} và kiểm tra hiển thị đúng giá trị có dấu tương ứng trong dropdown list Phường, xã")
    public void inputSignedValueIntoWardFieldAndVerifyDisplayedValueInDropdownList(String param) {
        registerPage = new ActionsRegister();
        param = ParameterService.INSTANCE.getString("DS_phuong_xa_co_dau",param);
        Assert.assertTrue(registerPage.enteredValueWithSpecifiedSignIntoWardSearch(param),"Do not display the corresponding signed value in Ward dropdown list When inputted signed value");
    }

    @Then("Nhập giá trị không dấu vào trường Phường, xã {string} và kiểm tra hiển thị đúng giá trị có dấu {string} tương ứng trong dropdown list Phường, xã")
    public void inputUnsignedValueIntoWardFieldAndVerifyDisplayedValueInDropdownList(String param1, String param2) {
        registerPage = new ActionsRegister();
        param1 = ParameterService.INSTANCE.getString("DS_phuong_xa_khong_dau",param1);
        param2 = ParameterService.INSTANCE.getString("DS_phuong_xa_co_dau",param2);
        Assert.assertTrue(registerPage.enteredValueWithUnspecifiedSignIntoWardSearch(param1, param2),"Do not display the corresponding signed value in Ward dropdown list When inputted unsigned value");
    }

    @Then("Nhập giá trị có dấu vào trường Đường, Phố {string} và kiểm tra hiển thị đúng giá trị có dấu tương ứng trong dropdown list Đường, Phố")
    public void inputSignedValueIntoStreetFieldAndVerifyDisplayedValueInDropdownList(String param) {
        registerPage = new ActionsRegister();
        param = ParameterService.INSTANCE.getString("DS_duong_pho_co_dau",param);
        Assert.assertTrue(registerPage.enteredValueWithSpecifiedSignIntoWardSearch(param),"Do not display the corresponding signed value in Street dropdown list When inputted signed value");
    }

    @Then("Nhập giá trị không dấu vào trường Đường, Phố {string} và kiểm tra hiển thị đúng giá trị có dấu {string} tương ứng trong dropdown list Đường, Phố")
    public void inputUnsignedValueIntoStreetFieldAndVerifyDisplayedValueInDropdownList(String param1, String param2) {
        registerPage = new ActionsRegister();
        param1 = ParameterService.INSTANCE.getString("DS_duong_pho_khong_dau",param1);
        param2 = ParameterService.INSTANCE.getString("DS_duong_pho_co_dau",param2);
        Assert.assertTrue(registerPage.enteredValueWithUnspecifiedSignIntoStreetSearch(param1, param2),"Do not display the corresponding signed value in Street dropdown list When inputted unsigned value");
    }

    @Then("Kiểm tra hiển thị trường txtbox Địa chỉ, Số nhà, txtbox Ghi chú khi trường Loại nhà là default: Nhà riêng")
    public void verifyDisplayedFieldsWhenDefaultIsSelectedHome() {
        registerPage = new ActionsRegister();
        Assert.assertTrue(registerPage.verifyDisplayedLabelWhenRdBtnIsSelectedHomeOrAppartment(),"Labels are not appeared when default value is Home");
        Assert.assertTrue(registerPage.verifyDisplayedTxtWhenRdBtnIsSelectedHomeOrAppartment(),"Txt inputs are not appeared when default value is Home");
    }

    @Then("Kiểm tra placeholder text của trường Địa chỉ, Số nhà {string}")
    public void verifyDisplayedPlaceholderValueOfHouseNumberField(String param) {
        registerPage = new ActionsRegister();
        param = ParameterService.INSTANCE.getString("DS_placeholder_diachi",param);
        Assert.assertTrue(registerPage.verifyPlaceholderOfHouseNumberField(param),"The placeholder value of house number is not matched ");
    }

    @Then("Hiện thông báo khi để trống trường Địa chỉ, số nhà {string}")
    public void verifyMessageWhenLeavingAddressBlanked(String expectedMsg) {
        registerPage = new ActionsRegister();
        Assert.assertTrue(registerPage.verifyBlankedAddressMessageDisplayed(expectedMsg),"The message when leaving the address/house number field blanked not matched expected message");
    }

    @And("Nhập vào trường Địa chỉ, Số nhà lớn hơn ba mươi ký tự {}")
    public void inputIntoAddressValueGreaterThan30Characters(String param) {
        registerPage = new ActionsRegister();
        param = ParameterService.INSTANCE.getString("DS_dia_chi_lon_hon_30",param);
        registerPage.sendTextToAddressField(param);
    }

    @Then("Kiểm tra hệ thống chỉ cho phép nhập tối đa ba mươi ký tự {}")
    public void verifyAddressFieldAcceptedMax30Characters(String param) {
        registerPage = new ActionsRegister();
        param = ParameterService.INSTANCE.getString("DS_dia_chi_30",param);
        Assert.assertTrue(registerPage.verifyMax30NumToInputAddressField(param),"The system allows to input more than 30 characters into address field");
    }

    @And("Click radio button Loại nhà: CHUNG CƯ")
    public void clickRadioButtonTypeAppartment() {
        registerPage = new ActionsRegister();
        registerPage.chooseAppartmentRdBtn();
    }

    @Then("Kiểm tra hiển thị Combobox: CHỌN CHUNG CƯ, Textbox TÒA NHÀ, LÔ,BLOCK, Textbox : SỐ TẦNG*, Textbox : SỐ PHÒNG*, Textbox : GHI CHÚ")
    public void verifyDisplayedFieldsWhenDefaultIsSelectedAppartment() {
        registerPage = new ActionsRegister();
        Assert.assertTrue(registerPage.verifyDisplayedLabelWhenRdBtnIsSelectedHomeOrAppartment(),"Labels are not appeared when default value is Appartment");
        Assert.assertTrue(registerPage.verifyDisplayedTxtWhenRdBtnIsSelectedHomeOrAppartment(),"Txt inputs are not appeared when default value is Appartment");
    }

    @Then("Kiểm tra hiển thị các placeholder của các textbox TÒA NHÀ,LÔ,BLOCK, SỐ TẦNG*, SỐ PHÒNG*, GHI CHÚ")
    public void verifyDisplayedPlaceholderOfTxtInpuntWhenAppartmentIsSelected() {
        registerPage = new ActionsRegister();
        Assert.assertTrue(registerPage.comparePlaceholderElementsOnAddressAppartmentSelected(),"Placeholder of textbox TÒA NHÀ,LÔ,BLOCK, SỐ TẦNG*, SỐ PHÒNG*, GHI CHÚ is not matched");
    }
}