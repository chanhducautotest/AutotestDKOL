package page_objects.Register;

import com.lazerycode.selenium.util.Query;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_objects.PageBase;

public class ElementsRegister extends PageBase {

    WebDriverWait wait = new WebDriverWait(driver, 5000);


    /**
     * Locator của màn hình thông tin đăng ký
     **/
    public Query label_informationPersonal = new Query().defaultLocator(By.xpath("(//h4[@class='text-16 text-bold mb-3 d-flex align-items-center'])[1]//span")).usingDriver(driver);
    public Query label_adressSetUp_label = new Query().defaultLocator(By.xpath("(//h4[@class='text-16 text-bold mb-3 d-flex align-items-center'])[2]//span")).usingDriver(driver);
    public Query button_continue = new Query().defaultLocator(By.xpath("(//button[contains(@class,'btn btn-custom')])[1]")).usingDriver(driver);
    public Query label_registerInformation = new Query().defaultLocator(By.xpath("(//li[@class='nav-item d-flex align-items-center active'])[1]//a")).usingDriver(driver);
    public Query label_service = new Query().defaultLocator(By.xpath("(//li[@class='nav-item d-flex align-items-center'])[1]//a")).usingDriver(driver);
    public Query label_paymentInformation = new Query().defaultLocator(By.xpath("(//li[@class='nav-item d-flex align-items-center'])[2]//a")).usingDriver(driver);
    public Query label_completeRegister = new Query().defaultLocator(By.xpath("(//li[@class='nav-item d-flex align-items-center'])[3]//a")).usingDriver(driver);
    public Query listRegisterInformationLabel = new Query().defaultLocator(By.xpath("//div[@class='container w-736 sec-plb-inside rd-t rd-b box-sdow']//div[@class='pdx09 py-4']//label")).usingDriver(driver);
    public Query listAmountingAddressLabel = new Query().defaultLocator(By.xpath("//div[@class='container w-736 sec-plb-inside rd-t mt-4 rd-b box-sdow']//div[@class='pdx09 py-4']//label")).usingDriver(driver);
    public Query listAddressLabelHomeOrAppartmentIsSelected = new Query().defaultLocator(By.xpath("//div[@class='container w-736 sec-plb-inside rd-t mt-4 rd-b box-sdow']//div[@class='form-infomation']/div/label")).usingDriver(driver);
    public Query listAddressTxtHomeOrAppartmentIsSelected = new Query().defaultLocator(By.xpath("//div[@class='container w-736 sec-plb-inside rd-t mt-4 rd-b box-sdow']//div[@class='form-infomation']/div/div/input")).usingDriver(driver);
    public Query label_userName = new Query().defaultLocator(By.xpath("//label[@for='name']")).usingDriver(driver);
    public Query label_phone = new Query().defaultLocator(By.xpath("(//label[@for='phone'])[1]")).usingDriver(driver);
    public Query label_birthday = new Query().defaultLocator(By.xpath("//label[@for='birthday']")).usingDriver(driver);
    public Query label_idNumber = new Query().defaultLocator(By.xpath("(//label[@for='phone'])[2]")).usingDriver(driver);
    public Query label_gender = new Query().defaultLocator(By.xpath("//label[@for='gender']")).usingDriver(driver);
    public Query label_email = new Query().defaultLocator(By.xpath("//label[@for='note']")).usingDriver(driver);
    public Query label_home = new Query().defaultLocator(By.xpath("(//span[@class='text-bold text-16 clo-black'])[1]")).usingDriver(driver);
    public Query label_tower = new Query().defaultLocator(By.xpath("(//span[@class='text-bold text-16 clo-black'])[2]")).usingDriver(driver);
    public Query label_adress = new Query().defaultLocator(By.xpath("//label[@for='address']")).usingDriver(driver);
    public Query text_name = new Query().defaultLocator(By.xpath("//input[@id='name']")).usingDriver(driver);
    public Query text_phone = new Query().defaultLocator(By.xpath("//input[@id='phone']")).usingDriver(driver);
    public Query text_birthday = new Query().defaultLocator(By.xpath("//input[@id='birthday']")).usingDriver(driver);
    public Query text_idNumber = new Query().defaultLocator(By.xpath("//input[@id='cmnd']")).usingDriver(driver);
    public Query text_email = new Query().defaultLocator(By.xpath("//input[@id='email']")).usingDriver(driver);
    public Query text_address = new Query().defaultLocator(By.xpath("//input[@id='address']")).usingDriver(driver);
    public Query text_note = new Query().defaultLocator(By.xpath("//input[@id='note']")).usingDriver(driver);
    public Query text_building = new Query().defaultLocator(By.xpath("//input[@id='building']")).usingDriver(driver);
    public Query text_block = new Query().defaultLocator(By.xpath("//input[@id='block']")).usingDriver(driver);
    public Query text_floor = new Query().defaultLocator(By.xpath("//input[@id='floor']")).usingDriver(driver);
    public Query text_room = new Query().defaultLocator(By.xpath("//input[@id='room']")).usingDriver(driver);
    public Query label_note = new Query().defaultLocator(By.xpath("//label[@for='note']")).usingDriver(driver);
    public Query radioButton_home = new Query().defaultLocator(By.xpath("(//input[@type='radio'])[1]")).usingDriver(driver);
    public Query radioButton_tower = new Query().defaultLocator(By.xpath("(//input[@type='radio'])[2]")).usingDriver(driver);
    public Query addressField = new Query().defaultLocator(By.xpath("//div[@class='container w-736 sec-plb-inside rd-t mt-4 rd-b box-sdow']//div[@class='col-12']")).usingDriver(driver);

    public Query dropdown_gender = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[2]/div[1]/span[1]/span[1]/span[1]/span[1]")).usingDriver(driver);
    public Query listItem_gender = new Query().defaultLocator(By.xpath("//ul[@role='listbox']//li")).usingDriver(driver);
    public Query label_male = new Query().defaultLocator(By.xpath("(//li[@role ='option'])[1]")).usingDriver(driver);
    public Query label_female = new Query().defaultLocator(By.xpath("(//li[@role ='option'])[2]")).usingDriver(driver);


    public Query dropdown_province = new Query().defaultLocator(By.xpath("(//span[@id='select2--container'])[2]")).usingDriver(driver);
    public Query dropdown_province_arrow = new Query().defaultLocator(By.xpath("(//span[@role='presentation'])[2]")).usingDriver(driver);
    public Query searchBox_province = new Query().defaultLocator(By.xpath("//input[@role='searchbox']")).usingDriver(driver);
    public Query listItem_province = new Query().defaultLocator(By.xpath("//ul[@role='listbox']//li")).usingDriver(driver);

    public Query dropdown_district = new Query().defaultLocator(By.xpath("(//span[@id='select2--container'])[3]")).usingDriver(driver);
    public Query searchBox_district = new Query().defaultLocator(By.xpath("//input[@role='searchbox']")).usingDriver(driver);
    public Query listItem_district = new Query().defaultLocator(By.xpath("//ul[@role='listbox']//li")).usingDriver(driver);

    public Query dropdown_ward = new Query().defaultLocator(By.xpath("(//span[@id='select2--container'])[4]")).usingDriver(driver);
    public Query searchBox_ward = new Query().defaultLocator(By.xpath("//input[@role='searchbox']")).usingDriver(driver);
    public Query listItem_ward = new Query().defaultLocator(By.xpath("//ul[@role='listbox']//li")).usingDriver(driver);
    public Query label_ward = new Query().defaultLocator(By.xpath("(//span[@id='select2--container'])[4]")).usingDriver(driver);

    public Query dropdown_street = new Query().defaultLocator(By.xpath("(//span[@id='select2--container'])[5]")).usingDriver(driver);
    public Query searchBox_street = new Query().defaultLocator(By.xpath("//input[@role='searchbox']")).usingDriver(driver);
    public Query listItem_street = new Query().defaultLocator(By.xpath("//ul[@role='listbox']//li")).usingDriver(driver);

    public Query dropdown_appartment = new Query().defaultLocator(By.xpath("(//span[@id='select2--container'])[6]")).usingDriver(driver);
    public Query searchBox_appartment = new Query().defaultLocator(By.xpath("//input[@role='searchbox']")).usingDriver(driver);
    public Query listItem_appartment = new Query().defaultLocator(By.xpath("//ul[@role='listbox']//li")).usingDriver(driver);

    public Query label_messageError = new Query().defaultLocator(By.xpath("//small[@class='form-text text-12 clo-red']")).usingDriver(driver);
    public Query label_messageErrorBlankCMND = new Query().defaultLocator(By.xpath("//small[contains(text(),'Vui lòng nhập CMND/CCCD.')]")).usingDriver(driver);
    public Query label_messageErrorBlankBirthdate = new Query().defaultLocator(By.xpath("//small[contains(text(),'Vui lòng nhập ngày sinh')]")).usingDriver(driver);
    public Query label_messageErrorWrongBirthdate = new Query().defaultLocator(By.xpath("//small[contains(text(),'Năm sinh không hợp lệ')]")).usingDriver(driver);
    public Query label_messageErrorLessThan15YrsOBirthdate = new Query().defaultLocator(By.xpath("//small[contains(text(),'Khách hàng phải lớn hơn 15 tuổi')]")).usingDriver(driver);
    public Query label_messageErrorBlankAddress = new Query().defaultLocator(By.xpath("//small[contains(text(),'Vui lòng nhập địa chỉ/số nhà.')]")).usingDriver(driver);
    public Query label_messageErrorAppartmentInput = new Query().defaultLocator(By.xpath("//small[contains(text(),'Vui lòng nhập tên chung cư.')]")).usingDriver(driver);
    public Query label_messageErrorBlankFloor = new Query().defaultLocator(By.xpath("//small[contains(text(),'Vui lòng nhập số tầng.')]")).usingDriver(driver);
    public Query label_messageErrorBlankRoom = new Query().defaultLocator(By.xpath("//small[contains(text(),'Vui lòng nhập số phòng.')]")).usingDriver(driver);
    public Query label_messageErrorFormatCMND = new Query().defaultLocator(By.xpath("//small[contains(text(),'CMND/CCCD phải từ 9 đến 12 chữ số.')]")).usingDriver(driver);
    public Query element_imgLogo = new Query().defaultLocator(By.xpath("//img[@alt='FPT Telecom']")).usingDriver(driver);
    public Query element_popups = new Query().defaultLocator(By.xpath("//div[@id='__BVID__409___BV_modal_content_']")).usingDriver(driver);
    public Query text_popups = new Query().defaultLocator(By.xpath("//p[contains(text(),'Hệ thống chưa xác định được địa chỉ lắp đặt của Qu')]")).usingDriver(driver);
    public Query button_agree = new Query().defaultLocator(By.xpath("//button[@class='w-100 btn btn-custom orange']")).usingDriver(driver);
    public Query button_iconX = new Query().defaultLocator(By.xpath("//i[@class='btn-clear']")).usingDriver(driver);

    public Query popup_notiErrorFormatID = new Query().defaultLocator(By.xpath("(//p[@class='clo-black76'])[3]")).usingDriver(driver);
    public Query popup_notiConfirm = new Query().defaultLocator(By.xpath("((//button[@type='button'])[19]")).usingDriver(driver);

    public Query loading = new Query().defaultLocator(By.xpath("//div[@aria-label='Loading']")).usingDriver(driver);
    public Query popup_msgInfrastructure = new Query().defaultLocator(By.xpath("//p[@class='clo-black76']")).usingDriver(driver);

    /**
     * Locator của màn hình chọn dịch vụ
     **/
    public Query label_describeData = new Query().defaultLocator(By.xpath("//div[@class='info']")).usingDriver(driver);
    public Query label_chooseNamePackage = new Query().defaultLocator(By.xpath("//div[@class= 'd-flex align-items-center']")).usingDriver(driver);
    public Query button_chooseChange = new Query().defaultLocator(By.xpath("/html/body/div/div[2]/main/div/section[2]/div[1]/div/div/div/h4/div[2]")).usingDriver(driver);
    public Query lable_nameData = new Query().defaultLocator(By.xpath("//div[@class='d-flex align-items-center']")).usingDriver(driver);
    public Query label_locationProvince = new Query().defaultLocator(By.xpath("//a[@class='nav-link d-flex align-items-center text-bold']")).usingDriver(driver);
    public Query lable_priceData = new Query().defaultLocator(By.xpath("//span[@class='text-bold text-20 clo-orange']")).usingDriver(driver);
    public Query button_infoFsafe = new Query().defaultLocator(By.xpath("//i[@class='ico-grey']")).usingDriver(driver);
    public Query popup_InfoFsafe = new Query().defaultLocator(By.xpath("//div[@class='modal-dialog modal-md']")).usingDriver(driver);
    public Query button_closePopUpInfoFsafe = new Query().defaultLocator(By.xpath("(//button[@class='close'])[3]")).usingDriver(driver);
    public Query date_SetupTime = new Query().defaultLocator(By.xpath("//input[@type='text']")).usingDriver(driver);
    public Query label_SetupTime = new Query().defaultLocator(By.xpath("(//div[@class ='py-4'])[2]//h4//span")).usingDriver(driver);
    public Query listItem_TimeSetup = new Query().defaultLocator(By.xpath("//ul[@role='listbox']//li")).usingDriver(driver);
    public Query button_modifyPackage = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/h4[1]/div[2]")).usingDriver(driver);
    public Query button_confirmChangePackage = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/button[1]")).usingDriver(driver);

    public Query dropdown_time = new Query().defaultLocator(By.xpath("//span[@role= 'textbox']")).usingDriver(driver);
    public Query listItem_time01 = new Query().defaultLocator(By.xpath("(//li[@role= 'option'])[1]")).usingDriver(driver);
    public Query listItem_time02 = new Query().defaultLocator(By.xpath("(//li[@role ='option'])[2]")).usingDriver(driver);
    public Query listItem_time03 = new Query().defaultLocator(By.xpath("(//li[@role ='option'])[3]")).usingDriver(driver);
    public Query listItem_time04 = new Query().defaultLocator(By.xpath("(//li[@role ='option'])[4]")).usingDriver(driver);

    /**
     * Locator của màn hình thông tin thanh toán
     **/
    public Query label_infoCompleteRegister = new Query().defaultLocator(By.xpath("(//div[@class='d-flex align-items-center'])[1]//span")).usingDriver(driver);
    public Query label_choosePayment = new Query().defaultLocator(By.xpath("//p[@class='text-16 text-bold clo-black23 mb-2']")).usingDriver(driver);
    public Query label_detailOrder = new Query().defaultLocator(By.xpath("//h4[@class='text-16 text-bold mb-3 d-flex align-items-center']//span")).usingDriver(driver);
    public Query label_rules01 = new Query().defaultLocator(By.xpath("(//p[@class='text-12 mb-0']//span)[1]")).usingDriver(driver);
    public Query label_rules02 = new Query().defaultLocator(By.xpath("(//p[@class='text-12 mb-0']//span)[2]")).usingDriver(driver);

    public Query label_namePackage = new Query().defaultLocator(By.xpath("(//div[@class='d-flex justify-content-between'])[4]//p")).usingDriver(driver);
    public Query label_feeInternet = new Query().defaultLocator(By.xpath("(//div[@class='d-flex justify-content-between'])[5]//p")).usingDriver(driver);
    public Query label_modemInternet = new Query().defaultLocator(By.xpath("(//div[@class='d-flex justify-content-between'])[6]//p")).usingDriver(driver);
    public Query label_modemAccess = new Query().defaultLocator(By.xpath("(//div[@class='d-flex justify-content-between'])[7]//p")).usingDriver(driver);
    public Query label_priceTotal = new Query().defaultLocator(By.xpath("(//div[@class='d-flex justify-content-between'])[8]//p")).usingDriver(driver);
    public Query button_payment = new Query().defaultLocator(By.xpath("//div[@class='d-flex flex-column mt-3']")).usingDriver(driver);
    public Query button_changeAddressSetUp = new Query().defaultLocator(By.xpath("(//a[@href='/internet/register'])[2]")).usingDriver(driver);
    public Query button_changeTimeSetUp = new Query().defaultLocator(By.xpath("(//a[@href='/internet/service'])[2]")).usingDriver(driver);

    /**
     * Locator của màn hình popup thông tin thanh toán
     **/
    public Query link_methodPayment = new Query().defaultLocator(By.xpath("//a[contains(@class,'big-btn d-flex')]")).usingDriver(driver);
    public Query label_popupPayment = new Query().defaultLocator(By.xpath("//h5[@id='exampleModalLabel']")).usingDriver(driver);
    public Query label_popupNoteInfo = new Query().defaultLocator(By.xpath("//p[@class='clo-black76 mb-0 mt-3']//i")).usingDriver(driver);
    public Query label_popupCardInternation = new Query().defaultLocator(By.xpath("(//p[@class='text-16 text-bold mb-1'])[1]")).usingDriver(driver);
    public Query label_popupATM = new Query().defaultLocator(By.xpath("(//p[@class='text-16 text-bold mb-1'])[2]")).usingDriver(driver);
    public Query label_popupFoxpay = new Query().defaultLocator(By.xpath("(//p[@class='text-16 text-bold mb-1'])[3]")).usingDriver(driver);
    public Query label_popupMomo = new Query().defaultLocator(By.xpath("(//p[@class='text-16 text-bold mb-1'])[4]")).usingDriver(driver);
    public Query label_popupVNPay = new Query().defaultLocator(By.xpath("(//p[@class='text-16 text-bold mb-1'])[5]")).usingDriver(driver);
    public Query label_popupHome = new Query().defaultLocator(By.xpath("(//p[@class='text-16 text-bold mb-1'])[6]")).usingDriver(driver);
    public Query label_defaultMethodPay = new Query().defaultLocator(By.xpath("/html/body/div/div[2]/main/div[1]/section[2]/div[2]/div[2]/div/div/div[1]/a/div[1]/span")).usingDriver(driver);

    public Query radio_cardInternation = new Query().defaultLocator(By.xpath("//input[@id='baz[1]']")).usingDriver(driver);
    public Query radio_cardATM = new Query().defaultLocator(By.xpath("(//input[@id='type_payment'])[1]")).usingDriver(driver);
    public Query radio_FoxPay = new Query().defaultLocator(By.xpath("//input[@id='baz[2]']")).usingDriver(driver);
    public Query radio_MoMo = new Query().defaultLocator(By.xpath("//input[@id='baz[3]']")).usingDriver(driver);
    public Query radio_VNPay = new Query().defaultLocator(By.xpath("//input[@id='baz[4]']")).usingDriver(driver);
    public Query radio_paymentHome = new Query().defaultLocator(By.xpath("//input[@id='baz[5]']")).usingDriver(driver);
    public Query icon_close = new Query().defaultLocator(By.xpath("(//button[@class='close'])[1]//span")).usingDriver(driver);
    public Query button_popupConfirm = new Query().defaultLocator(By.xpath("(//button[@type='button'])[2]")).usingDriver(driver);

    public Query label_namePackageChooseService = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/h4[1]/div[1]/span[1]")).usingDriver(driver);
    public Query label_ErrorNoticeNameEl = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/small[1]")).usingDriver(driver);
    public Query label_ErrorNoticePhoneEl = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/small[1]")).usingDriver(driver);
    public Query label_ErrorNoticeBirthdayEl = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[2]/small[1]")).usingDriver(driver);
    public Query label_ErrorNoticeIdEl = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/small[1]")).usingDriver(driver);
    public Query label_ErrorNoticeAddressEl = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[6]/small[1]")).usingDriver(driver);
    public Query label_ErrorNoticeMailEl = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[4]/div[1]/div[1]/small[1]")).usingDriver(driver);

    public Query label_numberBeforePriceTotal = new Query().defaultLocator(By.xpath("//p[contains(text(),'Tổng tiền')]//following-sibling::span")).usingDriver(driver);
    public Query label_numberAfterPriceTotal = new Query().defaultLocator(By.xpath("//p[contains(text(),'Tổng tiền')]//following-sibling::span")).usingDriver(driver);
    public Query label_numberCloseVoucherPriceTotal = new Query().defaultLocator(By.xpath("(//span[@class='text-bold clo-orange'])[5]")).usingDriver(driver);
    public Query text_inputVoucher = new Query().defaultLocator(By.xpath("//input[@id='voucher']")).usingDriver(driver);
    public Query button_closeVoucher = new Query().defaultLocator(By.xpath("(//button[@class='close'])[1]")).usingDriver(driver);
    public Query popup_notiSuccess = new Query().defaultLocator(By.xpath("//div[@role='dialog']//div[@tabindex='-1']")).usingDriver(driver);
    public Query button_Yes = new Query().defaultLocator(By.xpath("(//span[@class='text-16 text-bold'])[3]")).usingDriver(driver);
    public Query button_ChooseCode = new Query().defaultLocator(By.xpath("//a[@class='kd-vou-btn']")).usingDriver(driver);

    public Query label_registerNamePhone = new Query().defaultLocator(By.xpath("(//div[@class = 'info']//div)[1]//p")).usingDriver(driver);
    public Query label_registerAddress = new Query().defaultLocator(By.xpath("(//div[@class = 'info']//div)[2]//p")).usingDriver(driver);
    public Query label_registerTimeSetup = new Query().defaultLocator(By.xpath("(//div[@class = 'info']//div)[3]//p")).usingDriver(driver);
    public Query label_registerNamePackage = new Query().defaultLocator(By.xpath("(//div[@class = 'info']//div)[4]//p")).usingDriver(driver);
    public Query button_registerChangeAddress = new Query().defaultLocator(By.xpath("(//div[@class = 'info']//div)[2]//a")).usingDriver(driver);
    public Query button_registerChangeTime = new Query().defaultLocator(By.xpath("(//div[@class = 'info']//div)[3]//a")).usingDriver(driver);


    /**
     * Locator của màn hình Check out thẻ ATM
     **/
    public Query text_numberCard = new Query().defaultLocator(By.xpath("(//input[@type='tel'])[1]")).usingDriver(driver);
    public Query text_fullnameCard = new Query().defaultLocator(By.xpath("(//input[@type='text'])[3]")).usingDriver(driver);
    public Query text_dateCard = new Query().defaultLocator(By.xpath("(//input[@type='tel'])[2]")).usingDriver(driver);
    public Query button_continueCard = new Query().defaultLocator(By.xpath("(//button[@type='button'])[2]")).usingDriver(driver);
    public Query text_OTPCard = new Query().defaultLocator(By.xpath("(//input[@type='text'])[2]")).usingDriver(driver);
    public Query button_continueOTP = new Query().defaultLocator(By.xpath("(//button[@type='button'])[4]")).usingDriver(driver);

    /**
     * Locator của popup Voucher/ mã giới thiệu
     **/
    public Query label_voucher = new Query().defaultLocator(By.xpath("(//h5[@id = 'exampleModalLabel']//span)[1]")).usingDriver(driver);
    public Query button_apply = new Query().defaultLocator(By.xpath("//div[@class='mr-2']")).usingDriver(driver);
    public Query label_available = new Query().defaultLocator(By.xpath("//div[@class= 'form-infomation']//h5")).usingDriver(driver);
    public Query button_voucherX = new Query().defaultLocator(By.xpath("//button[@type = 'button']")).usingDriver(driver);
    public Query popup_voucher = new Query().defaultLocator(By.xpath("//div[@class = 'modal-dialog modal-md']")).usingDriver(driver);

    /**
     * Locator của popup hủy voucher/ mã giới thiệu
     **/
    public Query label_conformClose = new Query().defaultLocator(By.xpath("(//h5[@id = 'exampleModalLabel']//span)[1]")).usingDriver(driver);
    public Query label_messageClose = new Query().defaultLocator(By.xpath("//div[@class = 'modal-body']/p")).usingDriver(driver);
    public Query button_no = new Query().defaultLocator(By.xpath("(//button[@type = 'button'])[2]")).usingDriver(driver);
    public Query button_yes = new Query().defaultLocator(By.xpath("(//button[@type = 'button'])[3]")).usingDriver(driver);
    public Query button_X = new Query().defaultLocator(By.xpath("//span[@class = 'click-del']")).usingDriver(driver);
    public Query popup_iconX = new Query().defaultLocator(By.xpath("//button[@class= 'close']")).usingDriver(driver);

    /**
     * Locator của popup thông báo mã giới thiệu thất bại
     **/
    public Query label_messageNotiError = new Query().defaultLocator(By.xpath("//p[@class = 'clo-black76']")).usingDriver(driver);

    /**
     * Locator của màn hình Thông tin đăng ký FPT Play
     * */
    public Query label_namePhone = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/p[1]")).usingDriver(driver);
    public Query label_address = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/p[1]")).usingDriver(driver);
    public Query label_priceTotalFPTPlay = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/div[2]/div[2]/div[1]/div[1]/div[4]/span[1]")).usingDriver(driver);
    public Query button_priceTotalFPTPlay = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/div[2]/div[2]/div[1]/div[1]/div[6]/a[1]/span[2]")).usingDriver(driver);


    /**
     * Locator của màn hình hoàn tất đăng ký
     **/
    public Query label_orderCode = new Query().defaultLocator(By.xpath("(//span[@class='text-bold'])[2]")).usingDriver(driver);
    public Query label_totalPrice = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/div[2]/div[2]/div[1]/div[1]/div[2]/span[1]")).usingDriver(driver);
    public Query label_copy = new Query().defaultLocator(By.xpath("(//a[@class='text-bold clo-orange'])[1]")).usingDriver(driver);
    public Query label_orderDetail = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/div[2]/div[2]/div[1]/div[1]/div[3]/a[1]")).usingDriver(driver);
    public Query label_electronic_contract = new Query().defaultLocator(By.xpath("(//a[@class='text-bold clo-orange'])[3]")).usingDriver(driver);
    public Query label_goodsCodeInOrderDetail = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[2]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/h4[1]/div[1]/span[1]")).usingDriver(driver);
    public Query label_statusPayment = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[2]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[2]/p[2]")).usingDriver(driver);

    /**
     * Locator của màn hình thông tin đăng ký camera
     **/
    public Query list_TextError_camera = new Query().defaultLocator(By.cssSelector(".error-message")).usingDriver(driver);
    public Query label_userName_camera = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/label[1]")).usingDriver(driver);
    public Query label_phone_camera = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/div[1]/div[1]/div[2]/div[1]/label[1]")).usingDriver(driver);
    public Query label_birthday_camera = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/div[1]/div[1]/div[2]/div[2]/label[1]")).usingDriver(driver);
    public Query label_idNumber_camera = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/div[1]/div[1]/div[3]/div[1]/label[1]")).usingDriver(driver);
    public Query label_email_camera = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/div[1]/div[1]/div[4]/div[1]/label[1]")).usingDriver(driver);
    public Query text_name_camera = new Query().defaultLocator(By.cssSelector("#name")).usingDriver(driver);
    public Query text_phone_camera = new Query().defaultLocator(By.cssSelector("#phone")).usingDriver(driver);
    public Query text_birthday_camera = new Query().defaultLocator(By.cssSelector("#birthday")).usingDriver(driver);
    public Query text_id_camera = new Query().defaultLocator(By.cssSelector("#cmnd")).usingDriver(driver);
    public Query text_email_camera = new Query().defaultLocator(By.cssSelector("#email")).usingDriver(driver);
    public Query text_address_camera = new Query().defaultLocator(By.cssSelector("#address")).usingDriver(driver);
    public Query button_iconX_camera = new Query().defaultLocator(By.cssSelector("body.loading:nth-child(2) div.wrapper main.main-container.payment-flow:nth-child(2) div.container-fluid.banner-pm.pb-5.camera-check-page.mt-lg-5 section.sec-payment div.container.sec-plb-inside.rd-t.rd-b.box-sdow.my-3.p-4.w-736.mt-4:nth-child(1) div.form-infomation div.form-group.form-row:nth-child(1) div.col div.position-relative:nth-child(2) button.btn-clear > svg:nth-child(1)")).usingDriver(driver);
    public Query label_wrongFormatPhone_camera = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/div[1]/div[1]/div[2]/div[1]/small[1]")).usingDriver(driver);
    public Query label_wrongFormatId_camera = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/div[1]/div[1]/div[3]/div[1]/small[1]")).usingDriver(driver);
    public Query label_wrongFormatMail_camera = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/div[1]/div[1]/div[4]/div[1]/small[1]")).usingDriver(driver);
    public Query dropdown_street_camera = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/div[2]/div[1]/section[1]/div[4]/div[1]/div[1]/span[1]/span[1]/span[1]/span[1]")).usingDriver(driver);
    public Query listItem_street_camera = new Query().defaultLocator(By.xpath("/html[1]/body[1]/span[1]/span[1]/span[2]/ul[1]")).usingDriver(driver);
    public Query text_address_xpath_camera = new Query().defaultLocator(By.xpath("//input[@id='houseNumber']")).usingDriver(driver);
    public Query dropdown_ward_camera = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/div[2]/div[1]/section[1]/div[3]/div[1]/div[1]/span[1]/span[1]/span[1]/span[1]")).usingDriver(driver);
    public Query dropdown_district_camera = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/div[2]/div[1]/section[1]/div[2]/div[1]/div[1]/span[1]/span[1]/span[1]/span[1]")).usingDriver(driver);

    /**
     * Locator của màn hình chọn dịch vụ camera
     * */
    public Query label_cameraPackageName = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/div[1]/div[1]/h4[1]/div[1]/span[1]")).usingDriver(driver);
    public Query label_quantityPackageCamera = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/div[2]/div[2]/div[1]/div[1]/span[1]")).usingDriver(driver);
    public Query button_usedTime14Months = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[3]/div[1]/div[1]/div[3]/ul[1]/li[1]/label[1]/div[2]/input[1]")).usingDriver(driver);
    public Query button_usedTime7Months = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[3]/div[1]/div[1]/div[3]/ul[1]/li[2]/label[1]/div[2]/input[1]")).usingDriver(driver);
    public Query text_dateSetupCamera = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[3]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]")).usingDriver(driver);
    public Query text_hourSetupCamera = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/span[1]/span[1]/span[1]")).usingDriver(driver);
    public Query table_calenderCameraSetup = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]")).usingDriver(driver);
    public Query label_cloudErrorMessage = new Query().defaultLocator(By.xpath("/html/body/div/div[2]/main/div/section[3]/div[1]/div/div[1]/div")).usingDriver(driver);
    public Query button_increaseCloudPackage1Day = new Query().defaultLocator(By.xpath("/html/body/div/div[2]/main/div/section[3]/div[1]/div/div[2]/div[1]/div[2]/div/a[2]")).usingDriver(driver);
    public Query button_descreaseCloudPackage1Day = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/a[1]")).usingDriver(driver);
    public Query button_increaseCloudPackage3Day = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[3]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/a[2]")).usingDriver(driver);
    public Query button_descreaseCloudPackage3Day = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[3]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/a[1]")).usingDriver(driver);
    public Query button_increaseCloudPackage7Day = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[3]/div[1]/div[1]/div[2]/div[3]/div[2]/div[1]/a[2]")).usingDriver(driver);
    public Query button_descreaseCloudPackage7Day = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[3]/div[1]/div[1]/div[2]/div[3]/div[2]/div[1]/a[1]")).usingDriver(driver);
    public Query text_quantityCloudPackage1Day = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/span[1]")).usingDriver(driver);
    public Query text_quantityCloudPackage3Day = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[3]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/span[1]")).usingDriver(driver);
    public Query text_quantityCloudPackage7Day = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[3]/div[1]/div[1]/div[2]/div[3]/div[2]/div[1]/span[1]")).usingDriver(driver);

    /**
     * Locator của màn hình Thông tin thanh toán và Hoàn tất đăng ký - camera
     * */
    public Query label_namePhoneCamera = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/section[1]/div[1]/div[1]/div[1]/div[1]")).usingDriver(driver);
    public Query label_addressCamera = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]")).usingDriver(driver);
    public Query label_timeSetupCamera = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/section[1]/div[1]/div[1]/div[1]/div[3]/div[1]")).usingDriver(driver);
    public Query button_modifyLocation_Camera = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/section[1]/div[1]/div[1]/div[1]/div[2]/a[1]")).usingDriver(driver);
    public Query button_modifyTimeSetup_Camera = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/section[1]/div[1]/div[1]/div[1]/div[3]/a[1]")).usingDriver(driver);
    public Query button_modifyPackage_Camera = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/section[1]/div[1]/div[1]/div[1]/div[4]/div[1]/a[1]")).usingDriver(driver);
    public Query label_paymentMethods_Camera = new Query().defaultLocator(By.xpath("//p[@class='text-16 text-bold m-0 title']")).usingDriver(driver);
    public Query button_choosePaymentMethod = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/section[1]/div[2]/div[2]/div[1]/a[1]")).usingDriver(driver);
    public Query button_confirmPaymentMethod = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]")).usingDriver(driver);
    public Query button_chooseVoucher = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/section[1]/div[2]/div[2]/div[2]/div[1]/div[2]/a[1]")).usingDriver(driver);
    public Query label_voucherName = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/section[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/span[1]")).usingDriver(driver);
    public Query text_inputVoucher_Camera = new Query().defaultLocator(By.xpath("//input[@id='voucher']")).usingDriver(driver);
    public Query button_applyVoucher_Camera = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/a[1]")).usingDriver(driver);
    public Query button_aboutFPTRule_Camera = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/section[1]/div[2]/div[2]/div[3]/div[6]/p[1]/a[1]/span[1]")).usingDriver(driver);
    public Query button_chooseInternationalCard = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/ul[1]/div[1]/li[1]/label[1]/div[2]/input[1]")).usingDriver(driver);
    public Query button_chooseATMCard = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/ul[2]/li[1]/div[2]/input[1]")).usingDriver(driver);
    public Query button_chooseFoxpay = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/ul[3]/li[1]/div[2]/input[1]")).usingDriver(driver);
    public Query button_chooseMomo = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/ul[4]/li[1]/div[2]/input[1]")).usingDriver(driver);
    public Query button_chooseVNPay = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/ul[5]/li[1]/div[2]/input[1]")).usingDriver(driver);
    public Query text_alarmWrongOTP = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[4]/div[1]")).usingDriver(driver);
    public Query text_alarmFailPayment = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]")).usingDriver(driver);

    public Query list_paymentMethods = new Query().defaultLocator(By.cssSelector("#modal-payment-methods___BV_modal_body_")).usingDriver(driver);
}